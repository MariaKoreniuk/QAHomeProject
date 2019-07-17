package loginTEST;

import org.junit.Test;
import parentTest.ParentTest;


public class LoginTestWithPageObject extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();

        loginPage.enterTextIntoInputLogin("380685053287");
        loginPage.clickOnButtonDali();
        loginPage.enterTextInToInputPass("qwerty1992");
        loginPage.clickOnButtonVhod();

       checkExpectedResult("Avatar is not present", true, homePage.isAvatarPresent());

    }

}



