package com.learning.parcelrelay.api;
import java.util.*;
import java.time.*;
import java.math.BigDecimal;
/** Transport shapes. TODO: D4 BR-401 add field validation, defensive copies and mapping tests.
 * Treat secrets and internal persistence fields as excluded unless explicitly part of the contract.
 */
public final class Responses {
    private Responses() {}
    public record ShipmentView(UUID id, String ownerSubject, String destination, String status, long carrierSequence, long version) {}
    public record ShipmentReceipt(UUID id, String status) {}
    public record EndpointView(UUID id, String url) {}
    public record WebhookResult(String outcome) {}
    public record ReplayReceipt(UUID deliveryId, String status) {}
}
