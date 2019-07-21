package myProfile;


import org.junit.Test;
import parentTest.ParentTest;

public class MyProfileTest extends ParentTest {
    final String lastname="Koreniuk";

    @Test

   public void  EditMyProfile() {
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnMyProfile();
        editMyProfile.checkCurrentUrl();
        editMyProfile.clickOnbuttonEdid();

        editMyProfile.getFirstName();
        editMyProfile.enterNewFirstName();

        editMyProfile.enterLastName(lastname);
        editMyProfile.clickOnbuttonSave();

        editMyProfile.clickOnbuttonEdid();
        editMyProfile.getNewFirstName();


       checkExpectedResult("New firstname was not saved", true, editMyProfile.checkFirstName());

    }

}
