package com.task.api;

import com.task.api.util.DataLoader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CrudTests {

  private static final String BASE_URL = DataLoader.get("base.url");

  @Test
  public void testCreateUser() {
    String requestBody = """
            {
              "name": "Test User",
              "username": "testuser",
              "email": "test@example.com"
            }
        """;

    given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post(BASE_URL)
        .then()
        .statusCode(201)
        .body("name", equalTo("Test User"));
  }

  @Test
  public void testReadUser() {
    given()
        .when()
        .get(BASE_URL + "/1")
        .then()
        .statusCode(200)
        .body("id", equalTo(1));
  }

  @Test
  public void testUpdateUser() {
    String updatedBody = """
            {
              "name": "Updated User",
              "username": "updateduser",
              "email": "updated@example.com"
            }
        """;

    given()
        .contentType(ContentType.JSON)
        .body(updatedBody)
        .when()
        .put(BASE_URL + "/1")
        .then()
        .statusCode(200)
        .body("name", equalTo("Updated User"));
  }

  @Test
  public void testDeleteUser() {
    given()
        .when()
        .delete(BASE_URL + "/1")
        .then()
        .statusCode(200);
  }
}
