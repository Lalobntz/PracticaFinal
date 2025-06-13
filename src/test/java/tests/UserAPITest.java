package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import services.UserService;
import utils.ConfigManager;
import utils.UserGenerator;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserAPITest {
  private final UserService userService = new UserService();

  @Test
  public void testCreateUser() {
    Map<String, String> userData = UserGenerator.generateUser();

    Response response = userService.createUser(userData);

    response.then().statusCode(201)
        .body("name", equalTo(userData.get("name")))
        .body("job", equalTo(userData.get("job")));
    System.out.println("Usuario creado:\n" + response.prettyPrint());
    System.out.println("Valor desde config: " + ConfigManager.getBaseUrl());
  }

  @Test
  public void testGetUser() {
    int userId = 2; // Reqres.in tiene datos mock para ID 1 al 12

    Response response = userService.getUserPage(userId);

    response.then().statusCode(200)
        .body("data.id", equalTo(userId));

    System.out.println("Usuario obtenido:\n" + response.prettyPrint());
  }

  @Test
  public void testDeleteUser() {
    int userId = 2; // Aunque Reqres.in no elimina realmente, devuelve 204

    Response response = userService.deleteUser(userId);

    assertEquals(204, response.getStatusCode());
    System.out.println("Usuario eliminado, status:\n" + response.prettyPrint());
    System.out.println("Valor desde config: " + ConfigManager.getBaseUrl());
  }
}