# Starter File Map

These are intentionally unfinished building blocks, not a complete solution. Add missing DTOs, entity mappings, repository queries, configuration and tests as specified. No business endpoint is provided complete.

| File | Purpose |
| --- | --- |
| src/main/java/com/learning/parcelrelay/ParcelRelayApplication.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/parcelrelay/advanced/CarrierClient.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/advanced/DeliveryWorker.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/advanced/InboxHandler.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/advanced/OutboxPublisher.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/advanced/WebhookVerifier.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/api/ApiExceptionHandler.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/api/ParcelRelayController.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/config/SecurityConfig.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/parcelrelay/config/TimeConfig.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/parcelrelay/domain/DeliveryAttempt.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/domain/InboxReceipt.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/domain/OutboxEvent.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/domain/Shipment.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/domain/ShipmentStatus.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/exception/ConflictException.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/parcelrelay/exception/NotFoundException.java | Boot/Clock/exception infrastructure or security placeholder |
| src/main/java/com/learning/parcelrelay/persistence/ShipmentEntity.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/repository/ParcelRelayRepository.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/repository/PostgresParcelRelayRepository.java | Unfinished learner code; see rule IDs in Javadoc |
| src/main/java/com/learning/parcelrelay/service/ParcelRelayService.java | Unfinished learner code; see rule IDs in Javadoc |
| src/test/java/com/learning/parcelrelay/acceptance/D4AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/D5AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/D6AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/D7AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/M1DomainTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/M2AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/acceptance/M3AcceptanceTest.java | Behavioral examples / test exercise |
| src/test/java/com/learning/parcelrelay/structure/StarterStructureTest.java | Behavioral examples / test exercise |

Constructors use declared fields in README order. Implement validation and assignment before services. Repository ports describe the first core use cases; extend them as necessary. Advanced component methods are starting boundaries, not prescribed complete architecture. Keep provided behavioral constructor/method signatures while adding overloads or collaborators.

## Typed transport exercises

- `src/main/java/com/learning/parcelrelay/api/BusinessApiController.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
- `src/main/java/com/learning/parcelrelay/api/Requests.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
- `src/main/java/com/learning/parcelrelay/api/Responses.java`: typed D4 transport skeleton; validate and map according to API_REQUIREMENTS.md.
