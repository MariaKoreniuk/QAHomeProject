package changePassword;

import org.junit.Test;
import parentTest.ParentTest;

public class ChangePassTest extends ParentTest {


    @Test
    public void ChangePass(){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnMyProfile();
        editMyProfile.checkCurrentUrl();
        changePassword.clickOnbuttonChangePass();
        changePassword.clickShowPass();
        changePassword.setPassword(loginPage.getPasword());
        changePassword.NewPassword();
        changePassword.ConfirmPassword();

        changePassword.SavePassword();
        loginPage.logout();
        checkExpectedResult("New password was not saved", true, loginPage.loginWithPassword(changePassword.getNewPassword()));
        homePage.clickOnMyProfile();
        editMyProfile.checkCurrentUrl();
        changePassword.clickOnbuttonChangePass();
        changePassword.clickShowPass();
        changePassword.SetOldPassword();
        changePassword.ConfirmOldPassword();

        changePassword.SavePassword();
        loginPage.logout();
        checkExpectedResult("Old password was not restored ", true, loginPage.loginWithPassword(loginPage.getPasword()));

    }

}
