# Event Contracts

Target envelope is in [AsyncAPI](../api/asyncapi.json). Every event includes eventId,aggregateId,type,schemaVersion,occurredAt,correlationId,payload. Schema version is 1. Unknown optional fields are tolerated; incompatible semantics need a new version and migration. Maximum encoded message size is 64KiB.

RabbitMQ exchange `parcel.events` is a durable topic exchange. Routing keys `shipment.created.v1`, `shipment.dispatched.v1`, `shipment.in_transit.v1`, `shipment.delivered.v1`, `shipment.cancelled.v1` use the same envelope; bind workers explicitly. Payload includes shipmentId,status,carrierSequence. Configure durable queues, DLX and a replay procedure. Publisher confirms and routing returns both matter.

At-least-once delivery permits duplicates. Consumer identity plus eventId deduplicates effects in the same transaction. Never assume ordering across unrelated partitions/queues. Record trace context in headers without bearer tokens. Read README rules for crash windows, retention and replay.
