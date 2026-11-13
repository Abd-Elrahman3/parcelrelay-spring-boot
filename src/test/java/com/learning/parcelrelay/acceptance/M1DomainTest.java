package com.learning.parcelrelay.acceptance;
import com.learning.parcelrelay.domain.*;
import com.learning.parcelrelay.exception.*;
import java.util.*;
import java.time.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** Provided behavioral examples. These fail until M1 is implemented. Add boundary cases. */
@Tag("M1")
class M1DomainTest {
    @Test void dispatchedShipmentCannotCancel() {
        var shipment = new Shipment(UUID.randomUUID(), "alice", "12 Example Street", ShipmentStatus.DISPATCHED, 1, 0);
        assertThrows(ConflictException.class, shipment::cancel);
        assertEquals(ShipmentStatus.DISPATCHED, shipment.getStatus());
    }
    @Test void requestedShipmentCanCancel() {
        var shipment = new Shipment(UUID.randomUUID(), "alice", "12 Example Street", ShipmentStatus.REQUESTED, 0, 0);
        shipment.cancel();
        assertEquals(ShipmentStatus.CANCELLED, shipment.getStatus());
    }
}
