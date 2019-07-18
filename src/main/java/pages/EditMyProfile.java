package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class EditMyProfile extends ParentPage{
    @FindBy(xpath = ".//a[@href='/ecare/profileSettings/edit']")
    protected WebElement buttonEdit;

    @FindBy(xpath = ".//input[@name='firstName']")
    protected WebElement creatName;

    @FindBy(xpath = ".//input[@name='lastName']")
    protected WebElement creatLastName;

    @FindBy(xpath = ".//button[@name='submit' and @value='Save changes']")
    protected WebElement saveChanges;

    public EditMyProfile (WebDriver webDriver) {
        super(webDriver, "/");
    }


    public void checkCurrentUrl() {

        try {
            String myexpectedUrl = BASE_URL + "/ecare/profileSettings";
            logger.info("ProfileSettings expectedUrl:");
            logger.info(myexpectedUrl);
            logger.info("ProfileSettings getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(myexpectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }

    public void clickOnbuttonEdid(){

        actionsWithOurElements.clickOnElement(buttonEdit);
    }


public void enterFirstName(String firstName){
       actionsWithOurElements.enterTextIntoInput(creatName,firstName);


    }
    public void enterLastName(String lastName){
        actionsWithOurElements.enterTextIntoInput(creatLastName,lastName);
    }
    public void clickOnbuttonSave(){
        actionsWithOurElements.clickOnElement(saveChanges);
    }
}
