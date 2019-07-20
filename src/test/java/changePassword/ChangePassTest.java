package changePassword;

import org.junit.Test;
import parentTest.ParentTest;

public class ChangePassTest extends ParentTest {
    final  String pass1="qwerty193392";
    final String pass2="qwerty193392";



    @Test
    public void ChangePass(){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnMyProfile();
        editMyProfile.checkCurrentUrl();
        changePassword.clickOnbuttonChangePass();
        changePassword.NewPassword(pass1);
        changePassword.ConfirmPassword(pass2);
        changePassword.SavePassword();

    }

}
