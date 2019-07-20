package tariffTest;

import org.junit.Test;
import parentTest.ParentTest;

public class Tarifftest extends ParentTest {

    @Test

 public void AddNewTariff() {
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnCompatiblePlans();
        tariffplan.checkCurrentUrl();
        tariffplan.clickOnButtonActivate();
        tariffplan.clickOnButtonCancel();
        checkExpectedResult("The cancel  button isn't working", true, tariffplan.checkCancelResult());
        System.out.println("Test completed successfully");
    }
}
