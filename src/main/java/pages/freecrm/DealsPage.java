package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage  extends CommonAPI {
    public DealsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(MainPage.class.getName());

    @FindBy(xpath = "//span[@class='selectable ']")
    WebElement dealsLabel;

    @FindBy(xpath = "//button[normalize-space()='Create']")
    WebElement createDealButton;

    public boolean verifyDealsLabel(){
        return dealsLabel.isDisplayed();
    }

    public void clickOnCreateDealButton(){
        clickOn(createDealButton);
        log.info("Click on Create Contacts Button Success");
    }




}
