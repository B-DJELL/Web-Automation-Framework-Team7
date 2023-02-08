package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmForAnyBusinessPage extends CommonAPI {

    public CrmForAnyBusinessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(CrmForAnyBusinessPage.class.getName());

    @FindBy(xpath = "//h1[normalize-space()='CRM Cloud']")
    WebElement CrmCloudLogo;

    public String CrmCloudLogoMessage(){
        return CrmCloudLogo.getText();
    }
}
