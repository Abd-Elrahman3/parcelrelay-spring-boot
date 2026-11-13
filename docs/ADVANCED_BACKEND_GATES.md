# Advanced Backend Gates

CRUD alone does not complete this project. Every README rule is required, including the following demonstrations.

| Gate | Required demonstration |
| --- | --- |
| D5 | A DNS-rebinding endpoint and redirect to metadata IP are blocked; endpoint data never becomes an unrestricted server-side fetch. |
| D5 | Restart during backoff: next attempt remains scheduled. A failing endpoint does not block a healthy endpoint. |
| D6 | One poison message is dead-lettered while valid messages continue. Replay a fixed failure without duplicating already committed effects. |
| D6 | A mutation that marks outbox published before confirm or ACKs before DB commit must fail the tests. |
| D7 | Trace one shipment end-to-end; alert when oldest unpublished age exceeds 60s for 5 minutes. |
| D7 | No accepted shipment intent is lost; replaying events older than the dedup horizon requires an explicit reconciliation procedure. |

## Explain before advancing

1. Which invariant belongs in the domain, database, transport and worker respectively?
2. Where is the transaction boundary, and what happens if the process dies immediately after commit?
3. Which operations can safely retry, and how are duplicates or uncertain results resolved?
4. What is bounded: threads, connections, queues, buffers, retries and query sizes?
5. How is authorization enforced below the controller and across caches/messages?
6. Which metric tells you this system is failing before users report it?
7. How do you restore data and prove correctness after recovery?

Project-specific concepts to defend: REST integration, signed webhooks, RabbitMQ, transactional outbox/inbox, at-least-once delivery, retry budgets, circuit breakers, dead-letter queues, tracing.

Record commands and results in evidence files. An owner can alter CI; the gates are an honest learning contract, not tamper-proof certification. Mark incomplete behavior openly.
