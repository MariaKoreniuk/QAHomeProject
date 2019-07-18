package myProfile;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;

public class MyProfileTest extends ParentTest {
    final  String firstName="Maria";
    final String lastname="Koreniuk";

    @Test

   public void  EditMyProfile() {
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnMyProfile();
        editMyProfile.checkCurrentUrl();
        editMyProfile.clickOnbuttonEdid();
        editMyProfile.enterFirstName(firstName);
        editMyProfile.enterLastName(lastname);
        editMyProfile.clickOnbuttonSave();



    }

}
