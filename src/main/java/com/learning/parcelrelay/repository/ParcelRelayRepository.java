package com.learning.parcelrelay.repository;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;
import com.learning.parcelrelay.domain.*;

public interface ParcelRelayRepository {
    Optional<Shipment> findShipment(UUID id);
    Shipment saveShipment(Shipment shipment);
    void appendOutbox(OutboxEvent event);
    boolean recordInbox(String consumer, UUID eventId);
    List<OutboxEvent> claimOutbox(Instant now, int limit);
}
