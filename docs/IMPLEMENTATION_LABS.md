# Implementation Labs and Contract Details

These details are part of the requirements and refine the README rules.

## Provider contract and uncertain results

The local carrier simulator supports POST /carrier/shipments with {shipmentId,destination} and Idempotency-Key=shipmentId. It returns 201 {carrierShipmentId,status:"DISPATCHED"}; identical replay returns the original object. GET /carrier/shipments/by-key/{shipmentId} returns 200 found or 404 not-yet-found. Configure success, declined 422, delayed 2xx, 429 and 500 fixtures. After a timeout, persist dispatch attempt state UNKNOWN separately from ShipmentStatus; reconcile before retrying a new business action.

Public create-shipment keys are scoped to subject+operation, retained 24h, and committed with request hash and original response. Same key/hash returns the original 202 receipt; changed body returns 409. Auth audience is parcelrelay-api; shipments:write owns creation/cancellation, webhooks:manage registers endpoints and operations:replay replays failed deliveries. Receipt {id,status} refers to the persisted shipment. Incoming webhook response is {outcome:"APPLIED"|"IGNORED"|"QUARANTINED"}; authenticated malformed JSON →400, unknown shipment →404. No signature bypass for ordinary API bearer tokens.

## Outbound endpoint registration

Create a random webhook secret, store its vault/reference location, and return only endpoint id/url through the documented endpoint. Deliver the secret once using a protected setup channel you design and test. Each outbound attempt signs the exact bytes using that secret. Use a fake destination-policy adapter only in tests to reach a local mock server; separately test the production policy rejects private addresses, redirects and DNS rebinding. Do not add a runtime production switch that permits arbitrary local URLs.

## Transaction and broker lab

Use a deterministic crash hook between broker confirmation and published_at update, and another between consumer DB commit and ACK. A durable inbox prevents duplicate business effects. Delivery_attempts represent send attempts; also introduce a delivery identity unique(event_id,endpoint_id) to track eventual success across attempts. A timeout may mean the recipient already processed the event; recipients must deduplicate eventId. Do not claim externally exactly-once HTTP delivery.

## Reproducible HMAC fixture

Test-only secret `local-test-secret`; timestamp `1767225600`; fixed verification clock at that Unix timestamp; body below is UTF-8 with **no final newline**:

```json
{"eventId":"00000000-0000-0000-0000-000000000001","shipmentId":"00000000-0000-0000-0000-000000000002","sequence":1,"status":"DISPATCHED"}
```

Expected X-Webhook-Signature: `v1=87a8f268684fbd77c23de9cae42255cff2cc6bc01c32b6525add8b1073869100`. Appending a newline must fail verification with this signature. Never use this fixture secret in a deployment.
