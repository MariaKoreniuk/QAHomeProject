package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class Tariffplan extends ParentPage{

    final String BASE_URL = "https://new.kyivstar.ua";
    String expectedUrl;

    @FindBy(xpath = ".//button[@data-modal-url='/ecare/activate-plan/4G_UnlimMAX_2018_MMPP_DEFAULT']")
    private WebElement buttonActivate;
   @FindBy (xpath = ".//button[@class='info-block__action-link'and text()='Cancel']")
    private WebElement buttonCancel;


    // @FindBy(xpath = ".//button[@class='info-block__action-link'and text()='Cancel']")
    public Tariffplan (WebDriver webDriver) {
        super(webDriver, "/ecare/compatiblePlans");
    }

    public void checkCurrentUrl() {

        try {
            String myexpectedUrl = BASE_URL + "/ecare/compatiblePlans";
            logger.info("Tariffplan expectedUrl:");
            logger.info(myexpectedUrl);
            logger.info("Tariffplan getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(myexpectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }
    public void clickOnButtonActivate() {
        actionsWithOurElements.clickOnElement(buttonActivate);
    }

  public  void clickOnButtonCancel(){

      actionsWithOurElements.clickOnElement(buttonCancel);
  }

}
