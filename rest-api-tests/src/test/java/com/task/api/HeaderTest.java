package com.task.api;

import com.task.api.util.DataLoader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class HeaderTest {

  private static final String BASE_URL = DataLoader.get("base.url");

  @Test
  public void testContentTypeHeaderExistsAndIsCorrect() {
    given()
        .when()
        .get(BASE_URL)
        .then()
        .header("Content-Type", equalTo("application/json; charset=utf-8"));
  }
}
