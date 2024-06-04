package sk.ibm.demo.resource;

import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

// TODO make it a quarkus test
class StationResourceTest {

  // TODO this is a test method
  void getTrainNotEnoughMoneyTest() {
    given().when().get("/train?money=6.2").then().statusCode(200);
  }

  // TODO this is a test method
  void getTrainEnoughMoneyTest() {
    given().when().get("/train?money=6.3").then().statusCode(201);
  }

}
