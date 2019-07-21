package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = "//div[4]/div[2]/div[4]/div/div[1]/div[1]/img")
    private WebElement avatars;
    @FindBy(xpath = "//div[4]/div[2]/div[8]/div/ul/li[3]/a")
    private WebElement compatiblePlans;

    @FindBy(xpath = ".//img[@src='/ecare/_ui/desktop/theme-kyivstar/images/profile-default-picture.png']")
    private WebElement myProfile;

    @FindBy(xpath =".//div[@class='info-block__wrapper info-block__equalize-height info-block__equalize-height-by-width']/div[2]/div[2]/a")
    protected  WebElement servicePlan;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplayed(avatars);
    }



    public void clickOnCompatiblePlans() {
        actionsWithOurElements.clickOnElement(compatiblePlans);
    }


    public void clickOnMyProfile() {
        actionsWithOurElements.clickOnElement(myProfile);
    }

    public boolean checkServicePlan(){

        try {
            String tariffPlan = actionsWithOurElements.getTextFromlink(servicePlan);
            if(tariffPlan.isEmpty()){
                return false;
            }
            System.out.println("tariffPlan:"+tariffPlan);
            return true;

        }catch (Exception e) {

            logger.error("The name of service plan is missing");
            return false;
        }
}}


