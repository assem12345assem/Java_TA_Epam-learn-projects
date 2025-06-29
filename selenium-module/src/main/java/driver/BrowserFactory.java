package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

  private static WebDriver instance;

  private BrowserFactory() {
  }

  public static WebDriver getDriver() {
    if (instance == null) {
      switch (System.getProperty("browser")) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          instance = new ChromeDriver();
          break;
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          instance = new FirefoxDriver();
          break;
        case "safari":
          WebDriverManager.edgedriver().setup();
          instance = new SafariDriver();
          break;
        default:
          WebDriverManager.chromedriver().setup();
          instance = new ChromeDriver();
      }
    }
    instance.manage().window().maximize();
    return instance;
  }

  public static void quitDriver() {
    if (instance != null) {
      instance.quit();
      instance = null;
    }
  }
}
