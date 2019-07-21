package libs;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement element, String text) {
        this.webDriver= webDriver;
        wait10= new WebDriverWait(webDriver,10);
        wait15 = new WebDriverWait(webDriver,15);
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into Login");

        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            wait10= new WebDriverWait(webDriver,10);
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public boolean isElementDisplayed(WebElement element) {
        try{
            return element.isDisplayed();
        }
        catch (Exception e){
            return  false;
        }
    }

    public void enterTextIntoInput(TypifiedElement element, String text) {
        this.webDriver= webDriver;
        wait10= new WebDriverWait(webDriver,10);
        wait15 = new WebDriverWait(webDriver,15);
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into Login"+  element.getName());

        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public String getTextFromElement(WebElement element) {
        this.webDriver= webDriver;
        wait10= new WebDriverWait(webDriver,10);
        wait15 = new WebDriverWait(webDriver,15);
        try {
            logger.info("text was retrieved from Element"+ element.getAttribute("value"));
            return element.getAttribute("value");
        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
        return "";
    }


    public String getTextFromlink(WebElement element) {
        this.webDriver= webDriver;
        wait10= new WebDriverWait(webDriver,10);
        wait15 = new WebDriverWait(webDriver,15);
        try {
            logger.info("text was retrieved from Element"+ element.getText());
            return element.getText();
        } catch (Exception e) {

            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
        return "";
    }
}