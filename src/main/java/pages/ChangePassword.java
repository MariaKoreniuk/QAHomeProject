package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassword extends ParentPage {
    @FindBy(xpath = ".//a[@title='Change password']")
    protected WebElement changePass;
    @FindBy(xpath = ".//section/div/div/div[4]/input")
    protected WebElement newPass;
    @FindBy(xpath = ".//section/div/div[1]/div[5]/input")
    protected WebElement confPass;

    @FindBy(xpath =".//button[text()='Save']")
    protected WebElement savePass;


    public ChangePassword(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public void clickOnbuttonChangePass() {

        actionsWithOurElements.clickOnElement(changePass);
    }

    public void NewPassword(String pass1) {
        actionsWithOurElements.enterTextIntoInput(newPass, pass1);
    }

    public void ConfirmPassword(String pass2) {
        actionsWithOurElements.enterTextIntoInput(confPass, pass2);
    }

    public void SavePassword(){
        actionsWithOurElements.clickOnElement(savePass);
    }
}