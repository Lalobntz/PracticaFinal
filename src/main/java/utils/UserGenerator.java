package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UserGenerator {
  private static final Faker faker = new Faker();

  public static Map<String, String> generateUser() {
    Map<String, String> userData = new HashMap<>();
    userData.put("name", faker.name().fullName());
    userData.put("job", faker.job().title());

    System.out.println("Usuario generado: " + ConfigManager.getBaseUrl());
    System.out.println("  Name: " + userData.get("name"));
      System.out.println("  Job: " + userData.get("job"));
    return userData;
  }
}