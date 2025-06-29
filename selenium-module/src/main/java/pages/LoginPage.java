package pages;

import bo.User;
import bo.UserFactory;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DataLoader;

public class LoginPage extends BasePage{
  @FindBy(id ="identifierId")
  private WebElement emailInput;

  @FindBy(name = "password")
  private WebElement passwordInput;

  @FindBy(id = "identifierNext")
  private WebElement nextButtonEmail;

  @FindBy(id = "passwordNext")
  private WebElement nextButtonPassword;

  public LoginPage(WebDriver driver, WebDriverWait wait, Properties properties) {
    super(driver, wait, properties);
    PageFactory.initElements(driver, this);

    String link = DataLoader.loadProperty("LINK");
    driver.get(link);
    driver.manage().window().maximize();
  }

  public void login() {
    User user = UserFactory.validUser();
    emailInput.sendKeys(user.getUsername());
    nextButtonEmail.click();
    getWait().until(ExpectedConditions.visibilityOf(passwordInput));

    passwordInput.sendKeys(user.getPassword());
    nextButtonPassword.click();
  }
}
