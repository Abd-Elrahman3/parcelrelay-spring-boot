package com.learning.parcelrelay.domain;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;


/** M1 domain skeleton. REQUESTED → DISPATCHED → IN_TRANSIT → DELIVERED; CANCELLED only before dispatch. See README sections 4–5. */
public class Shipment {
    private UUID id;
    private String ownerSubject;
    private String destination;
    private ShipmentStatus status;
    private long carrierSequence;
    private long version;

    /** TODO: M1 BR-101 BR-102: validate, normalize and assign; preserve documented nullability. */
    public Shipment(UUID id, String ownerSubject, String destination, ShipmentStatus status, long carrierSequence, long version) {
        throw new UnsupportedOperationException("TODO: M1 BR-101 BR-102 domain construction");
    }
    public UUID getId() { return id; }
    public String getOwnerSubject() { return ownerSubject; }
    public String getDestination() { return destination; }
    public ShipmentStatus getStatus() { return status; }
    public long getCarrierSequence() { return carrierSequence; }
    public long getVersion() { return version; }

    /** M1 BR-101. Only REQUESTED can cancel. */
    public void cancel() {
        throw new UnsupportedOperationException("TODO: M1 BR-101");
    }

    /** D4 BR-402. Ignore old sequences; quarantine impossible transitions at the service boundary. */
    public boolean applyCarrierEvent(long sequence, ShipmentStatus target) {
        throw new UnsupportedOperationException("TODO: D4 BR-402");
    }
}
