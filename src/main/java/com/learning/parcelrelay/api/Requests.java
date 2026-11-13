package com.learning.parcelrelay.api;
import java.util.*;
import java.time.*;
import java.math.BigDecimal;
/** Transport shapes. TODO: D4 BR-401 add field validation, defensive copies and mapping tests.
 * Treat secrets and internal persistence fields as excluded unless explicitly part of the contract.
 */
public final class Requests {
    private Requests() {}
    public record CreateShipment(String destination) {}
    public record RegisterEndpoint(String url) {}
}
