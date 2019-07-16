package pages;
import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;


abstract public class ParentPage {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    ActionsWithOurElements actionsWithOurElements;

    public static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    final String BASE_URL = "https://account.kyivstar.ua/cas/login?service=http%3A%2F%2Fb2b.kyivstar.ua%3A80%2Ftbmb%2Fdisclaimer%2Fshow.do";
    String expectedUrl;

    public ParentPage(WebDriver webDriver) {
    }

    public ParentPage (WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)),this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = BASE_URL + partUrl;
}

    public void checkCurrentUrl() {

        try {
            logger.info("expectedUrl:");
            logger.info(expectedUrl);
            logger.info("getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(expectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }

}
