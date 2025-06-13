package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigManager; 

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserService {
  private static final String BASE_PATH = "/api/users";

  public UserService() {
    RestAssured.baseURI = ConfigManager.getBaseUrl();
  }

  public Response createUser(Map<String, Object> userData) {
    return given()
            .header("Content-Type", ConfigManager.getContentType())
            .body(userData)
            .post(BASE_PATH);
  }

  public Response getUserPage(int userId) {
    return given()
            .header("Content-Type", ConfigManager.getContentType())
            .get(BASE_PATH + "/" + userId);      
  }

  public Response deleteUser(int userId) {
    return given()
            .header("Content-Type", ConfigManager.getContentType())
            .delete(BASE_PATH + "/" + userId);
  }
}
