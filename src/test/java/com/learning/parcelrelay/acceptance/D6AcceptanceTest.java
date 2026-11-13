package com.learning.parcelrelay.acceptance;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/** Required test exercises. Read docs/ACCEPTANCE_TESTS.md for setup and expected results. */
@Tag("D6")
class D6AcceptanceTest {
    /** BR-601: One poison message is dead-lettered while valid messages continue. Replay a fixed failure without duplicating already committed effects. */
    @Test void br601_acceptance() {
        fail("TODO: D6 BR-601 replace this with a behavior test; do not disable or delete it");
    }
    /** BR-602: A mutation that marks outbox published before confirm or ACKs before DB commit must fail the tests. */
    @Test void br602_acceptance() {
        fail("TODO: D6 BR-602 replace this with a behavior test; do not disable or delete it");
    }
}
