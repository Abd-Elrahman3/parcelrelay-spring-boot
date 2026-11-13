# Developer Track (D4–D7)

Rules are mandatory and cumulative. README section 5 is authoritative. Testing is part of each milestone; the AQA guide is complementary, not an alternative that skips implementation.

## D4 — API contracts and authorization

**Branch:** `feature/d4-api`

**Goal:** Verify incoming webhook bytes; Apply ordered updates.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-401 | Verify incoming webhook bytes — Changing whitespace in a signed body invalidates the signature; stale, missing or malformed signatures return 401 and write nothing. |
| [ ] | BR-402 | Apply ordered updates — DELIVERED sequence 9 then IN_TRANSIT sequence 8 leaves DELIVERED. Duplicate sequence 9 produces no new outgoing event. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/D4AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D4.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D5 — Advanced behavior and resource limits

**Branch:** `feature/d5-advanced`

**Goal:** Deliver outbound webhooks durably; Bound retries and isolate failures.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-501 | Deliver outbound webhooks durably — A DNS-rebinding endpoint and redirect to metadata IP are blocked; endpoint data never becomes an unrestricted server-side fetch. |
| [ ] | BR-502 | Bound retries and isolate failures — Restart during backoff: next attempt remains scheduled. A failing endpoint does not block a healthy endpoint. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/D5AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D5.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D6 — Failure testing and recovery

**Branch:** `feature/d6-failures`

**Goal:** Handle poison messages and replay; Use contract and failure tests.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-601 | Handle poison messages and replay — One poison message is dead-lettered while valid messages continue. Replay a fixed failure without duplicating already committed effects. |
| [ ] | BR-602 | Use contract and failure tests — A mutation that marks outbox published before confirm or ACKs before DB commit must fail the tests. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/D6AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D6.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## D7 — Operations and design defense

**Branch:** `feature/d7-operations`

**Goal:** Trace asynchronous work; Recover from outages.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-701 | Trace asynchronous work — Trace one shipment end-to-end; alert when oldest unpublished age exceeds 60s for 5 minutes. |
| [ ] | BR-702 | Recover from outages — No accepted shipment intent is lost; replaying events older than the dedup horizon requires an explicit reconciliation procedure. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/D7AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/D7.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.
