# Database Requirements

## 1. Ownership and schema

PostgreSQL owns shipments(id,owner_subject,destination,status,carrier_sequence,version), outbox_events(id,aggregate_id,type,schema_version,payload JSONB,occurred_at,published_at NULL,lease_until NULL), inbox_receipts(consumer,event_id,processed_at, PK(consumer,event_id)), webhook_endpoints(id,owner_subject,url,secret_reference,active), delivery_attempts(id,event_id FK,endpoint_id FK,attempt,next_attempt_at,status,last_error_code, UNIQUE(event_id,endpoint_id,attempt)), quarantine_events(id,event_id UNIQUE,reason,payload_redacted,created_at), request_keys(subject,key,request_hash,response_body,expires_at). External idempotency is separate from inbox dedup. Use FK, NOT NULL and CHECK(attempt>=1). RabbitMQ exchange parcel.events routes shipment.* to durable queues, each with bounded retries and DLQ. Store secret references, never plaintext webhook secrets in logs or payloads. Prepare a schema evolution plan before changing event types.

## 2. Required artifacts

- ERD with cardinality, PK, FK, nullability and ownership.
- Versioned forward migrations for every constraint/index; no automatic schema update in final configuration.
- Seed fixtures for normal, duplicate, missing-reference and boundary cases.
- Explicit transaction isolation, lock order, timeout and retry policy.
- EXPLAIN (ANALYZE, BUFFERS) for the busiest query before and after an index; include row counts and hardware.
- Upgrade test from a prior schema fixture, not only create-from-empty.
- Backup/restore commands for a disposable destination and SQL integrity checks.

## 3. Testing rules

Run actual PostgreSQL semantics. Use separate connections/processes for concurrent transactions and deterministic barriers; bound all waits. A service-level existence check is not a uniqueness guarantee. If the app relies on a constraint, test direct SQL violating it. Explain any SELECT FOR UPDATE, SKIP LOCKED, RLS, serializable retry or projection checkpoint used here.

## 4. Migration discipline

An applied migration is immutable. Use expand/backfill/contract for incompatible changes, and state how old/new application versions coexist. Separate migration privileges from runtime privileges. Document retention and restore behavior for derived data, deduplication records and secrets. Do not ship real user data in fixtures.

See [Implementation Labs and Contract Details](IMPLEMENTATION_LABS.md) for concrete fixtures, payload semantics and boundary experiments. These are required, not optional extras.
