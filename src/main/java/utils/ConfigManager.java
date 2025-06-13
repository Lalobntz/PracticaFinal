package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
  private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
  private static final Properties properties = new Properties();

  static {
    try {
      FileInputStream input = new FileInputStream(CONFIG_FILE_PATH);
      properties.load(input);
    } catch (IOException e) {
      throw new RuntimeException("Error al cargar el archivo de configuración: " + CONFIG_FILE_PATH, e);
    }
  }

  public static String getProperty(String key) {
    return System.getProperty(key, properties.getProperty(key));
  }

  public static String getBaseUrl() {
    return getProperty("base.url");
  }

  public static String getContentType() {
    return getProperty("content.type");
  }

  public static String getKey() {
    return getProperty("x-api-key");
  }
}