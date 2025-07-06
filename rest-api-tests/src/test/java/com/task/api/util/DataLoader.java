package com.task.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataLoader {
  private static final Properties props = new Properties();

  static {
    try (InputStream input = DataLoader.class
        .getClassLoader()
        .getResourceAsStream("testdata.properties")) {

      if (input == null) {
        throw new RuntimeException("Unable to find testdata.properties");
      }
      props.load(input);

    } catch (IOException ex) {
      throw new RuntimeException("Failed to load testdata.properties", ex);
    }
  }

  public static String get(String key) {
    return props.getProperty(key);
  }
}
