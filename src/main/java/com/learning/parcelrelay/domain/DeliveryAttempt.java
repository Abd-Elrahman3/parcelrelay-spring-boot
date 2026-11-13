package com.learning.parcelrelay.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;


/** M1 domain skeleton. Unique(eventId,endpointId,attempt); durable retry state. See README sections 4–5. */
public class DeliveryAttempt {
    private UUID id;
    private UUID eventId;
    private UUID endpointId;
    private int attempt;
    private Instant nextAttemptAt;
    private String status;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public DeliveryAttempt(UUID id, UUID eventId, UUID endpointId, int attempt, Instant nextAttemptAt, String status) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public UUID getEventId() { return eventId; }
    public UUID getEndpointId() { return endpointId; }
    public int getAttempt() { return attempt; }
    public Instant getNextAttemptAt() { return nextAttemptAt; }
    public String getStatus() { return status; }
}
