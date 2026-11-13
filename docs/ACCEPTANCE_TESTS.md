# Acceptance Tests

Every row is mandatory. M1 includes provided examples in starters; later test skeletons must become real behavior tests. Test names below are descriptions, not a hidden API.

| Milestone | Rule | Scenario and expected result |
| --- | --- | --- |
| M1 | BR-101 | IN_TRANSIT → DISPATCHED fails without changing the object; DELIVERED → CANCELLED fails. |
| M1 | BR-102 | Replaying one event 10 times preserves eventId and business outcome; a v1 consumer tolerates an added optional field. |
| M2 | BR-201 | Inject failure before commit: no shipment or event remains. Crash after commit: unpublished event is later recoverable. |
| M2 | BR-202 | Crash after consumer commit but before broker ACK; redelivery creates no duplicate notification or shipment transition. |
| M3 | BR-301 | Crash after broker acceptance before published_at update: duplicate appears and is safely deduplicated. |
| M3 | BR-302 | Carrier accepted then timed out: reconciliation finds one shipment; no second external shipment is created. |
| D4 | BR-401 | Changing whitespace in a signed body invalidates the signature; stale, missing or malformed signatures return 401 and write nothing. |
| D4 | BR-402 | DELIVERED sequence 9 then IN_TRANSIT sequence 8 leaves DELIVERED. Duplicate sequence 9 produces no new outgoing event. |
| D5 | BR-501 | A DNS-rebinding endpoint and redirect to metadata IP are blocked; endpoint data never becomes an unrestricted server-side fetch. |
| D5 | BR-502 | Restart during backoff: next attempt remains scheduled. A failing endpoint does not block a healthy endpoint. |
| D6 | BR-601 | One poison message is dead-lettered while valid messages continue. Replay a fixed failure without duplicating already committed effects. |
| D6 | BR-602 | A mutation that marks outbox published before confirm or ACKs before DB commit must fail the tests. |
| D7 | BR-701 | Trace one shipment end-to-end; alert when oldest unpublished age exceeds 60s for 5 minutes. |
| D7 | BR-702 | No accepted shipment intent is lost; replaying events older than the dedup horizon requires an explicit reconciliation procedure. |

## Failure drills

1. Kill publisher after broker confirm and before DB mark.
2. Kill consumer after commit and before ACK.
3. Simulate carrier success followed by response timeout.

## Evidence standard

Record setup, exact command, controlled failure point, durable before/after state, expected result and actual result. A test that only asserts an exception or mocks all persistence cannot prove a database invariant. Use bounded timeouts and deterministic coordination; avoid sleeps as a race strategy. Record a seed for randomized tests. Do not turn an unavailable Docker dependency into a silently skipped passing test.

For D6, deliberately introduce one representative bug and verify a test detects it. For D7, record machine configuration, dataset, concurrency, p50/p95/p99, throughput, errors and resource usage. Restore tests use a different database from the source.
