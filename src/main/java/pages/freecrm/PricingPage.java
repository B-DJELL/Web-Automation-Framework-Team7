package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends CommonAPI {
    public PricingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(PricingPage.class.getName());

    @FindBy(xpath = "//h1[normalize-space()='CRM Software Pricing']")
    WebElement PricingLogoMessage;

    public String getPricingLogoMessage(){
        return PricingLogoMessage.getText();
    }
}
