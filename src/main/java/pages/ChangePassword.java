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

    @FindBy(xpath =".//section/div/div/div[4]/div[2]/i")
    protected WebElement showPass;

    String password = "";
    String passSufix="12";



    public ChangePassword(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public void clickOnbuttonChangePass() {

        actionsWithOurElements.clickOnElement(changePass);
    }
    public void SetOldPassword() {
        actionsWithOurElements.enterTextIntoInput(newPass, password);
    }

    public void NewPassword() {
        actionsWithOurElements.enterTextIntoInput(newPass, password+passSufix);
    }

    public String getPassword(){
        return password;

    }
    public void setPassword(String pass){
         password=pass;

    }
    public String getNewPassword(){
        return password+ passSufix;

    }

    public void ConfirmPassword() {
        actionsWithOurElements.enterTextIntoInput(confPass, password+ passSufix);
    }
    public void ConfirmOldPassword() {
        actionsWithOurElements.enterTextIntoInput(confPass, password);
    }
    public void SavePassword(){
        actionsWithOurElements.clickOnElement(savePass);
    }


    public void clickShowPass(){
        actionsWithOurElements.clickOnElement(showPass);

    }
}