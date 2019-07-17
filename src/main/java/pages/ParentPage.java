package pages;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
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

    final String BASE_URL = "https://new.kyivstar.ua";
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
            System.out.println("expectedUrl:");
            System.out.println(expectedUrl);
            System.out.println("getCurrentUrl:");
            System.out.println(webDriver.getCurrentUrl());
            Assert.assertEquals("Url:!"+webDriver.getCurrentUrl()+"! is not expectedUrl:!"+expectedUrl+"!", expectedUrl, webDriver.getCurrentUrl());
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }

}
