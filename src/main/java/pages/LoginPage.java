package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @FindBy(xpath=".//input[@class='form-control OVDENX-i-a']")
    private TextInput inputNumber;
    @FindBy(xpath = ".//input[@type='password']")
    private TextInput inputPass;
    @FindBy(xpath = ".//button[@class='btn btn-default']")
    private WebElement buttonDali;
    @FindBy (xpath = ".//button[@class='btn btn-default']")
    private WebElement buttonVhod;


    public void openPage() {

        try {
            webDriver.get("https://account.kyivstar.ua/cas/login?service=http%3A%2F%2Fnew.kyivstar.ua%2Fecare%2F%3Fstate%3Dlogout");
            logger.info("LoginPage was opened");

        } catch (Exception e) {

            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

        public void enterTextIntoInputLogin (String number) {
        actionsWithOurElements.enterTextIntoInput(inputNumber,number);

    }
        public void enterTextInToInputPass(String pass) {
            actionsWithOurElements.enterTextIntoInput(inputPass, pass);
        }



    public void clickOnButtonDali(){
        try{
            WebElement buttonVhod=webDriver.findElement(By.xpath(".//button[@class='btn btn-default']"));
            buttonDali.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnButtonVhod(){
        try{
            WebElement buttonVhod=webDriver.findElement(By.xpath(".//button[@class='btn btn-default']"));
            buttonVhod.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element");
        }
    }

    public void loginWithCred(String number, String pass) {
      //  openPage();
        //checkCurrentUrl();
       // enterTextIntoInputNumber(inputNumber);
     //   enterTextInToInputPass(pass);
                //clickOnButtonVhod();
    }

   public void validLogin() {
     loginWithCred("380685053287","qwerty1992");
    }
}


