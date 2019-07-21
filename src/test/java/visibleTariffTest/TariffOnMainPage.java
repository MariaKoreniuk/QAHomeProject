package visibleTariffTest;

import org.junit.Test;
import parentTest.ParentTest;

public class TariffOnMainPage extends ParentTest {

    @Test

    public void CheckTariff(){

        loginPage.openPage();

        loginPage.enterTextIntoInputLogin("380685053287");
        loginPage.clickOnButtonDali();
        loginPage.enterTextInToInputPass("qwerty19921212");
        loginPage.clickOnButtonVhod();

checkExpectedResult("The name of service plan is missing",true,homePage.checkServicePlan());
    }



}
