package pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  private WebDriver driver;
  private WebDriverWait wait;
  private Properties properties;

  public BasePage(WebDriver driver, WebDriverWait wait, Properties properties) {
    this.driver = driver;
    this.wait = wait;
    this.properties = properties;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriverWait getWait() {
    return wait;
  }

  public Properties getProperties() {
    return properties;
  }
}
