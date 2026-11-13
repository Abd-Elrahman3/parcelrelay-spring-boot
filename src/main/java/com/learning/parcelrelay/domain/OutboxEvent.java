package com.learning.parcelrelay.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;


/** M1 domain skeleton. Inserted in the same transaction as shipment state. See README sections 4–5. */
public class OutboxEvent {
    private UUID id;
    private UUID aggregateId;
    private String type;
    private int schemaVersion;
    private String payload;
    private Instant occurredAt;
    private Instant publishedAt;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public OutboxEvent(UUID id, UUID aggregateId, String type, int schemaVersion, String payload, Instant occurredAt, Instant publishedAt) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public UUID getAggregateId() { return aggregateId; }
    public String getType() { return type; }
    public int getSchemaVersion() { return schemaVersion; }
    public String getPayload() { return payload; }
    public Instant getOccurredAt() { return occurredAt; }
    public Instant getPublishedAt() { return publishedAt; }
}
