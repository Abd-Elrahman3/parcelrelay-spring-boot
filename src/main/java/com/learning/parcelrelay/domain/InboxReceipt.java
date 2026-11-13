package com.learning.parcelrelay.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;


/** M1 domain skeleton. Unique(consumer,eventId); committed with consumer effects. See README sections 4–5. */
public class InboxReceipt {
    private String consumer;
    private UUID eventId;
    private Instant processedAt;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public InboxReceipt(String consumer, UUID eventId, Instant processedAt) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public String getConsumer() { return consumer; }
    public UUID getEventId() { return eventId; }
    public Instant getProcessedAt() { return processedAt; }
}
