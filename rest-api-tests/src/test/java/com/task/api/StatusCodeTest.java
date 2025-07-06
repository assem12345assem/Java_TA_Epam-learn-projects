package com.task.api;

import static io.restassured.RestAssured.given;

import com.task.api.util.DataLoader;
import org.junit.jupiter.api.Test;

public class StatusCodeTest {
  private static final String BASE_URL = DataLoader.get("base.url");

  @Test
  public void testStatusCode200() {
    given()
        .when()
        .get(BASE_URL)
        .then()
        .statusCode(200);
  }
}