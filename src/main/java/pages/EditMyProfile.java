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

    @FindBy(xpath = ".//form/div[3]/div/div/div/button")
    protected WebElement saveChanges;


    String firstName="Maria";
    String newfirstName="";
    String firstNameSuffix= "aaa";
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
    public String getFirstName(){
         firstName=actionsWithOurElements.getTextFromElement(creatName);
         return firstName;
    }

    public String getNewFirstName(){
        newfirstName=actionsWithOurElements.getTextFromElement(creatName);

        return newfirstName;
    }
    public void enterFirstName(){
        actionsWithOurElements.enterTextIntoInput(creatName,firstName);
    }
    public void enterNewFirstName(){
       actionsWithOurElements.enterTextIntoInput(creatName,firstName + firstNameSuffix);
    }
    public void enterLastName(String lastName){
        actionsWithOurElements.enterTextIntoInput(creatLastName,lastName);
    }
    public void clickOnbuttonSave(){
        actionsWithOurElements.clickOnElement(saveChanges);
    }

    public boolean checkFirstName(){
        System.out.println("firstName:"+firstName+" newfirstName:"+newfirstName);
       if( newfirstName.equals(firstName + firstNameSuffix)){
           return true;

        }
          return false;

    }
}


