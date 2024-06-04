package sk.ibm.demo.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import sk.ibm.demo.exception.TrainException;

// TODO make it a quarkus test
class TrainStationServiceTest {

  // TODO make it available for the test
  TrainStationService svc;

  // TODO this is a test method
  void getTrainTest() {
    // when
    assertDoesNotThrow(() -> svc.getNextTrain(6.3));
    assertThrows(TrainException.class, () -> svc.getNextTrain(6.2));

  }

}
