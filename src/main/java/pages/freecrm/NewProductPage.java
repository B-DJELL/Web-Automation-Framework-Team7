package pages.freecrm;

import base.CommonAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage extends CommonAPI {
    public NewProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//input[@name='name']")
    WebElement Name;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveButton;

    public void CreateNewProduct(String RandomName){
        Name.sendKeys(RandomName);
        SaveButton.click();
    }

    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

}
