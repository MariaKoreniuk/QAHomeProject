package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.regex.Pattern;

public class LoginPage extends ParentPage {

    final String NewBASE_URL = "https://account.kyivstar.ua";

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/cas/login?service=http%3A%2F%2Fb2b.kyivstar.ua%3A80%2Ftbmb%2Fdisclaimer%2Fshow.do");
        String partUrl="/cas/login?service=http%3A%2F%2Fb2b.kyivstar.ua%3A80%2Ftbmb%2Fdisclaimer%2Fshow.do";
        expectedUrl = NewBASE_URL + partUrl;
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
            webDriver.get("https://account.kyivstar.ua/cas/login?service=http%3A%2F%2Fb2b.kyivstar.ua%3A80%2Ftbmb%2Fdisclaimer%2Fshow.do");
            logger.info("LoginPage was opened");

        } catch (Exception e) {

            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

        public void enterTextIntoInputLogin (String number) {
        actionsWithOurElements.enterTextIntoInput(inputNumber,number);

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

    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextIntoInput(inputPass, pass);
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
       openPage();
       checkCurrentUrl();
       enterTextIntoInputLogin(number);
       clickOnButtonDali();
       enterTextInToInputPass(pass);
                clickOnButtonVhod();
    }

   public void validLogin() { loginWithCred("380685053287","qwerty1992");
    }
}


