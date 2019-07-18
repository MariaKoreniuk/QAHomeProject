package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = "/html/body/div[4]/div[2]/div[4]/div/div[1]/div[1]/img")
    private WebElement avatars;
    //   @FindBy(xpath = ".//div[1]/div//ul/li[3]/a[@href='/ecare/compatiblePlans']" )
    @FindBy(xpath = "/html/body/div[4]/div[2]/div[8]/div/ul/li[3]/a")
    private WebElement compatiblePlans;

    @FindBy(xpath = ".//img[@src='/ecare/_ui/desktop/theme-kyivstar/images/profile-default-picture.png']")
    private WebElement myProfile;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplayed(avatars);
    }


    public boolean authorizationPage() {
        try {
            return webDriver.findElement(By.xpath(".//div[@class='login-box-body']")).isDisplayed();
        } catch (Exception e) {

            return false;


        }
    }

    // public void checkIsAvatarDisplayed(){
    //    Assert.assertTrue("Avatar is not present",isAvatarPresent());
//   }

    public void clickOnCompatiblePlans() {
        actionsWithOurElements.clickOnElement(compatiblePlans);
    }


    public void clickOnMyProfile() {
        actionsWithOurElements.clickOnElement(myProfile);
    }

}


