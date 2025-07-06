package com.task.api;

import com.task.api.util.DataLoader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class BodyTest {

  private static final String BASE_URL = DataLoader.get("base.url");

  @Test
  public void testResponseBodyContains10Users() {
    given()
        .when()
        .get(BASE_URL)
        .then()
        .assertThat()
        .body("", hasSize(10));
  }
}
