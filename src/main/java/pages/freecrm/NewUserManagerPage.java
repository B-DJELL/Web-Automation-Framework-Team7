package pages.freecrm;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserManagerPage extends CommonAPI {
    public NewUserManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(NewUserManagerPage.class.getName());

    @FindBy(xpath ="//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy (xpath = "//input[@name='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//h3[normalize-space()='Groups']")
    WebElement groupsButton;

    @FindBy(xpath ="//button[normalize-space()='Use the default group setup']")
    WebElement defaultSetupButton;

    @FindBy(xpath = "//h3[normalize-space()='Permissions']")
    WebElement PermissionButton;

    @FindBy(xpath = "//p[contains(text(),'Permissions marked with an * are implied by being ')]")
    WebElement PermissionTextMessage;

    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }


    public void createNewUser(String ftName,String ltName,String RandomEmail,String Password){
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        log.info("Name typing succees");
        emailAddress.sendKeys(RandomEmail);
        password.sendKeys(Password);
        confirmPassword.sendKeys(Password);
        saveButton.click();

        log.info("Filling new contact information success");
    }

    public void clickOnGroupsButton(){
        clickOn(groupsButton);
    }

    public void clickOnDefaultSetupButton(){
        clickOn(defaultSetupButton);
    }

    public void clickOnPermissionButton(){
        clickOn(PermissionButton);
    }

    public String getTextFromPermissionPage(){
        return PermissionTextMessage.getText();
    }
}
