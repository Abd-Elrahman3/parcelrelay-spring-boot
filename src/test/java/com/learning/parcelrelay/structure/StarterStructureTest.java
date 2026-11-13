package com.learning.parcelrelay.structure;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** A packaging check only; does not grade business behavior. */
@Tag("structure")
class StarterStructureTest {
    @Test void applicationAndPortArePresent() throws Exception {
        assertTrue(Class.forName("com.learning.parcelrelay.repository.ParcelRelayRepository").isInterface());
        assertTrue(Class.forName("com.learning.parcelrelay.ParcelRelayApplication").isAnnotationPresent(
            org.springframework.boot.autoconfigure.SpringBootApplication.class));
    }
    @Test void clockBeanUsesUtc() {
        assertEquals(java.time.ZoneOffset.UTC, new com.learning.parcelrelay.config.TimeConfig().clock().getZone());
    }
}
