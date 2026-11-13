# Shared Milestones (M1–M3)

Rules are mandatory and cumulative. README section 5 is authoritative. Testing is part of each milestone; the AQA guide is complementary, not an alternative that skips implementation.

## M1 — Domain and invariants

**Branch:** `feature/m1-domain`

**Goal:** Protect shipment transitions; Define event envelopes.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-101 | Protect shipment transitions — IN_TRANSIT → DISPATCHED fails without changing the object; DELIVERED → CANCELLED fails. |
| [ ] | BR-102 | Define event envelopes — Replaying one event 10 times preserves eventId and business outcome; a v1 consumer tolerates an added optional field. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/M1DomainTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M1.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## M2 — Database and persistence

**Branch:** `feature/m2-database`

**Goal:** Write state and event atomically; Deduplicate consumers transactionally.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-201 | Write state and event atomically — Inject failure before commit: no shipment or event remains. Crash after commit: unpublished event is later recoverable. |
| [ ] | BR-202 | Deduplicate consumers transactionally — Crash after consumer commit but before broker ACK; redelivery creates no duplicate notification or shipment transition. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/M2AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M2.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.

## M3 — Transactional use cases

**Branch:** `feature/m3-transactions`

**Goal:** Publish with confirms; Integrate an unreliable carrier.

**You will practise:** REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

| Done | Rule | What to implement |
| --- | --- | --- |
| [ ] | BR-301 | Publish with confirms — Crash after broker acceptance before published_at update: duplicate appears and is safely deduplicated. |
| [ ] | BR-302 | Integrate an unreliable carrier — Carrier accepted then timed out: reconciliation finds one shipment; no second external shipment is created. |

**Files:** consult [Starter Map](STARTER_MAP.md); add focused classes, DTOs, entities and adapters as needed. Test file: `src/test/java/com/learning/parcelrelay/acceptance/M3AcceptanceTest.java`.

**Required tests:** both rule examples, at least one boundary and one failure/rollback scenario from [Acceptance Tests](ACCEPTANCE_TESTS.md).

**Done when:** these tests and every earlier milestone pass; `docs/evidence/M3.md` contains reproducible evidence and an explanation of the invariant.

**Trap:** implementing only the HTTP happy path, or checking a rule in Java while leaving the database race unprotected.
