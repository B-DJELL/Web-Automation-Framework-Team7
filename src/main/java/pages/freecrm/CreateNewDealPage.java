package pages.freecrm;

import base.CommonAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDealPage extends CommonAPI {
    public CreateNewDealPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(CreateNewDealPage.class.getName());

    @FindBy(xpath = "//input[@name='title']")
    WebElement titleField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;

    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    public void createNewDeal(String title){
        titleField.sendKeys(title);
        log.info("Filling new deal information success");
    }

    public void clickOnSaveBtn(){
        clickOn(saveBtn);
    }

}
