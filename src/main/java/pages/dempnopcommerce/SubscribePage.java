package pages.dempnopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscribePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SubscribePage.class.getName());

    public SubscribePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "(//div[@id='newsletter-result-block'])[1]")
    WebElement resultsNewsLetter;


    public String getsubscribeToNewsLetterMessage() {return getTextFromElement(resultsNewsLetter);}



    }






