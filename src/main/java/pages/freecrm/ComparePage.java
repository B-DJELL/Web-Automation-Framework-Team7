package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage extends CommonAPI {
    public ComparePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//h1[normalize-space()='Free CRM Comparison']")
    WebElement CompareLogoMessage;

    public String getCompareLogoMessage(){
        return CompareLogoMessage.getText();
    }
}
