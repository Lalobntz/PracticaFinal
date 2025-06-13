package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigManager; 

import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class UserService {
  private static final String BASE_PATH = "/api/users";

  public UserService() {
    RestAssured.baseURI = ConfigManager.getBaseUrl();
    System.out.println("Base URI: "+ RestAssured.baseURI);
    System.out.println("Valor desde config: " + ConfigManager.getBaseUrl());
  }

  public Response createUser(Map<String, String> userData) {
    System.out.println("Datos enviados en el POST:");
    System.out.println(userData);
    return given()
            .header("Content-Type", ConfigManager.getContentType())
            .header("x-api-key", ConfigManager.getKey())
            .log().all()
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
            .header("x-api-key", ConfigManager.getKey())
            .log().all()
            .delete(BASE_PATH + "/" + userId);
  }
}
