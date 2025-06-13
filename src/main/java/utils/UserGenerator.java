import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UserGenerator {
  private static final Faker faker = new Faker();

  public static Map<String, Object> generateUser() {
    Map<String, Object> userData = new HashMap<>();
    userData.put("name", faker.name().fullName());
    userData.put("job", faker.job().title());
    return userData;
  }
}