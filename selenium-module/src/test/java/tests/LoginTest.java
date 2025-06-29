package tests;

import driver.BrowserFactory;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GmailPage;
import pages.LoginPage;
import util.DataLoader;

public class LoginTest {

  private LoginPage loginPage;
  private WebDriver driver;
  private WebDriverWait wait;
  private Properties properties;
  private GmailPage gmailPage;
  private String addressee;

  @BeforeClass
  public void setUp() throws Exception {
    properties = new Properties();
    properties.load(new FileReader("src/test/resources/testdata.properties"));

    System.setProperty("browser", "chrome");
    driver = BrowserFactory.getDriver();
    wait = new WebDriverWait(driver,
        Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout"))));

    loginPage = new LoginPage(driver, wait, properties);

  }

  @AfterClass
  public static void quit() {
    BrowserFactory.quitDriver();
  }

  @Test(priority = 1)
  public void testLoginPassingValidCredentials() {
    loginPage.login();
    gmailPage = new GmailPage(driver, wait, properties);
    assertTrue(gmailPage.isComposeNewEmailButtonVisible(),
        "Login process was not successful");
  }

  @Test(priority = 2)
  public void testAbleToSaveADraft() {
    addressee = String.format("%s@gmail.com", DataLoader.loadProperty("email"));
    gmailPage.composeEmail(addressee);
    gmailPage.clickCloseButton();
    gmailPage.clickDraftsLink();
    assertTrue(gmailPage.isDraftFolderNotEmpty(),
        "Expected at least one draft in the Drafts folder, but it was empty.");
  }

  @Test(priority = 3)
  public void testDraftMessageHasExpectedContent() {
    String random = DataLoader.loadProperty("randomText");
    gmailPage.clickFirstDraftMessage();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(gmailPage.getToFieldValue(), addressee,
        "Initial addressee in 'To' field does not match the draft message.");

    softAssert.assertEquals(gmailPage.getSubjectText(), random,
        "Draft message subject does not match expected value");

    softAssert.assertEquals(gmailPage.getMessageBody(), random,
        "Draft message body does not match expected value");

    softAssert.assertAll();

  }

  @Test(priority = 4)
  public void testNoDraftMessagesAreLeft() {
    gmailPage.clickSendButton();
    assertTrue(gmailPage.isNoDraftsMessageVisible(),
        "Expected 'You don't have any saved drafts.' message to be visible.");
  }

  @Test(priority = 5)
  public void testSentMessageIsInSentFolder() {
    gmailPage.clickSentLink();
    assertEquals(gmailPage.getFirstEmailSubject(), DataLoader.loadProperty("randomText"),
        "Email subject does not match");
  }
}
