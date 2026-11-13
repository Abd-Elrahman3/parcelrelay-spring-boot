package com.learning.parcelrelay.repository;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;
import com.learning.parcelrelay.domain.*;

/** M2 BR-201/BR-202. Implement using real PostgreSQL; do not substitute an in-memory map. */
@org.springframework.stereotype.Repository
public class PostgresParcelRelayRepository implements ParcelRelayRepository {
    @Override public Optional<Shipment> findShipment(UUID id) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 findShipment");
    }
    @Override public Shipment saveShipment(Shipment shipment) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 saveShipment");
    }
    @Override public void appendOutbox(OutboxEvent event) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 appendOutbox");
    }
    @Override public boolean recordInbox(String consumer, UUID eventId) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 recordInbox");
    }
    @Override public List<OutboxEvent> claimOutbox(Instant now, int limit) {
        throw new UnsupportedOperationException("TODO: M2 BR-201 BR-202 claimOutbox");
    }
}
