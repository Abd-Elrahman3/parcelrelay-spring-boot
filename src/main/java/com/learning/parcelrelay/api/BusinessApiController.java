package com.learning.parcelrelay.api;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import static com.learning.parcelrelay.api.Responses.*;
import com.learning.parcelrelay.service.ParcelRelayService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

/** D4 transport skeleton. Implement validation, authorization and DTO/service mapping.
 * Throwing TODOs is deliberate: no endpoint claims business success yet.
 */
@RestController
public class BusinessApiController {
    private final ParcelRelayService service;
    public BusinessApiController(ParcelRelayService service) { this.service = service; }
    @PostMapping("/api/v1/shipments")
    public ResponseEntity<ShipmentReceipt> createShipment(@Valid @RequestBody Requests.CreateShipment request, @RequestHeader("Idempotency-Key") String key, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 createShipment");
    }
    @GetMapping("/api/v1/shipments/{shipmentId}")
    public ResponseEntity<ShipmentView> shipment(@PathVariable UUID shipmentId, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 shipment");
    }
    @PostMapping("/api/v1/shipments/{shipmentId}/cancel")
    public ResponseEntity<ShipmentView> cancel(@PathVariable UUID shipmentId, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 cancel");
    }
    @PostMapping("/api/v1/carrier-events")
    public ResponseEntity<WebhookResult> carrierEvent(@RequestBody byte[] rawBody, @RequestHeader("X-Webhook-Timestamp") String timestamp, @RequestHeader("X-Webhook-Signature") String signature) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 carrierEvent");
    }
    @PostMapping("/api/v1/webhook-endpoints")
    public ResponseEntity<EndpointView> registerEndpoint(@Valid @RequestBody Requests.RegisterEndpoint request, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 registerEndpoint");
    }
    @PostMapping("/api/v1/deliveries/{deliveryId}/replay")
    public ResponseEntity<ReplayReceipt> replay(@PathVariable UUID deliveryId, @AuthenticationPrincipal Jwt principal) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 BR-402 replay");
    }
}
