# API Test Specification

The authoritative contract is [API Requirements](../API_REQUIREMENTS.md). Build a test matrix for all 6 operations.

For each: test successful response/status/headers, malformed payload, boundary values, missing resource, duplicate request, authorization denial and relevant unavailable dependency. Check database side effects after rejection. Use exact request bytes for signatures, real JWT validation tests for issuer/audience, and protocol-specific assertions for GraphQL/gRPC/streaming.

| Rule | Required sample |
| --- | --- |
| BR-401 | Changing whitespace in a signed body invalidates the signature; stale, missing or malformed signatures return 401 and write nothing. |
| BR-402 | DELIVERED sequence 9 then IN_TRANSIT sequence 8 leaves DELIVERED. Duplicate sequence 9 produces no new outgoing event. |
| BR-501 | A DNS-rebinding endpoint and redirect to metadata IP are blocked; endpoint data never becomes an unrestricted server-side fetch. |
| BR-502 | Restart during backoff: next attempt remains scheduled. A failing endpoint does not block a healthy endpoint. |

Do not call real carrier/payment/customer services. Build deterministic local provider fixtures and record request counts and idempotency keys.
