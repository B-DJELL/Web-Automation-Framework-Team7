package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends CommonAPI {
    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//input[@name='company_name']")
    WebElement CompanyNameField;

    @FindBy(xpath = "")
    WebElement SaveButton;

    public void fillUpCompanyNameField(String CompanyName){
        CompanyNameField.sendKeys(CompanyName);
    }

    public void clickOnSaveButton(){
        clickOn(SaveButton);
    }
}
