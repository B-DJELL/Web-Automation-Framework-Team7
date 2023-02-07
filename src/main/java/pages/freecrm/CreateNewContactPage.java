package pages.freecrm;

import base.CommonAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewContactPage extends CommonAPI {
    public CreateNewContactPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath ="//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath ="//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath ="//button[@class='ui linkedin button']")
    WebElement saveBtn;

    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    public void createNewContact(String ftName, String ltName){
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        log.info("Filling new contact information success");
    }

    public void clickOnSaveBtn(){
        clickOn(saveBtn);
    }

}
