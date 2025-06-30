package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DataLoader;

public class GmailPage extends BasePage {

  @FindBy(xpath = "//*[@role='button' and (.)='Compose']")
  private WebElement composeEmailButton;

  @FindBy(name = "to")
  private WebElement toField;

  @FindBy(name = "subjectbox")
  private WebElement emailSubjectInput;

  @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
  private WebElement emailBody;

  @FindBy(xpath = "//*[@role='button' and text()='Send']")
  private WebElement sendButton;

  @FindBy(xpath = "//img[@alt='Close' and @aria-label='Save & close']")
  private WebElement closeButton;

  @FindBy(xpath = "//a[normalize-space()='Drafts']")
  private WebElement draftsLink;

  @FindBy(xpath = "//table[contains(@class,'F cf zt')]/tbody/tr[contains(@class, 'zA')]")
  private List<WebElement> draftEmailRows;

  @FindBy(xpath = "//table[contains(@class,'F cf zt')]/tbody/tr[contains(@class, 'zA')][1]")
  private WebElement firstDraftRow;

  @FindBy(xpath = "//td[contains(text(), \"You don't have any saved drafts.\")]")
  private WebElement noDraftsMessage;

  @FindBy(xpath = "//a[contains(@href, '#sent') and text()='Sent']")
  private WebElement sentLink;

  @FindBy(xpath = "//tr[contains(@class,'zA')][1]//span[@class='bog']/span")
  private WebElement emailSubjectText;


  public GmailPage(WebDriver driver, WebDriverWait wait, Properties properties) {
    super(driver, wait, properties);
  }

  public void composeEmail(String addressee) {
    clickComposeNewEmail();
    fillToField(addressee);
    fillEmailSubject();
    fillEmailBody();
  }

  public void clickCloseButton() {
    getWait().until(ExpectedConditions.elementToBeClickable(closeButton));
    closeButton.click();
  }

  public void clickDraftsLink() {
    getWait().until(ExpectedConditions.elementToBeClickable(draftsLink));
    draftsLink.click();
  }

  private void clickComposeNewEmail() {
    getWait().until(ExpectedConditions.visibilityOf(composeEmailButton));
    composeEmailButton.click();
  }

  public boolean isComposeNewEmailButtonVisible() {
    try {
      WebDriverWait longWait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
      longWait.until(ExpectedConditions.visibilityOf(composeEmailButton));
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isDraftFolderNotEmpty() {
    try {
      getWait().withTimeout(Duration.ofSeconds(60))
          .until(ExpectedConditions.visibilityOfAllElements(draftEmailRows));
      return !draftEmailRows.isEmpty();
    } catch (TimeoutException e) {
      return false;
    }
  }

  public void clickFirstDraftMessage() {
    try {
      getWait().until(ExpectedConditions.visibilityOf(firstDraftRow));
      firstDraftRow.click();
    } catch (TimeoutException e) {
      throw new IllegalStateException("No draft message found to click.");
    }
  }

  public String getToFieldValue() {
    getWait().until(ExpectedConditions.visibilityOf(toField));
    return toField.getText();
  }

  public String getSubjectText() {
    return emailSubjectInput.getText();
  }

  public String getMessageBody() {
    return emailBody.getText();
  }

  private void fillToField(String addressee) {
    getWait().until(ExpectedConditions.visibilityOf(toField));
    toField.clear();
    toField.sendKeys(addressee);
  }

  private void fillEmailSubject() {
    getWait().until(ExpectedConditions.visibilityOf(emailSubjectInput));
    emailSubjectInput.clear();
    emailSubjectInput.sendKeys(DataLoader.loadProperty("randomText"));
  }

  private void fillEmailBody() {
    getWait().until(ExpectedConditions.visibilityOf(emailBody));
    emailBody.clear();
    emailBody.sendKeys(DataLoader.loadProperty("randomText"));
  }

  public void clickSendButton() {
    sendButton.click();
  }

  public boolean isNoDraftsMessageVisible() {
    try {
      return noDraftsMessage.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void clickSentLink() {
    sentLink.click();
  }

  public String getFirstEmailSubject() {
    getWait().until(ExpectedConditions.visibilityOf(emailSubjectText));
    return emailSubjectText.getText().trim();
  }
}
