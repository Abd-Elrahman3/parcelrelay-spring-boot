package com.learning.parcelrelay.acceptance;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** Required test exercises. Read docs/ACCEPTANCE_TESTS.md for setup and expected results. */
@Tag("D4")
class D4AcceptanceTest {
    /** BR-401: Changing whitespace in a signed body invalidates the signature; stale, missing or malformed signatures return 401 and write nothing. */
    @Test void br401_acceptance() {
        fail("TODO: D4 BR-401 replace this with a behavior test; do not disable or delete it");
    }
    /** BR-402: DELIVERED sequence 9 then IN_TRANSIT sequence 8 leaves DELIVERED. Duplicate sequence 9 produces no new outgoing event. */
    @Test void br402_acceptance() {
        fail("TODO: D4 BR-402 replace this with a behavior test; do not disable or delete it");
    }
}
