package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmDeletionPage extends CommonAPI {
    public ConfirmDeletionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(ConfirmDeletionPage.class.getName());

    @FindBy(xpath ="//button[normalize-space()='Delete']")
    WebElement DeleteButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement CancelDeletionButton;

    public void clickOnDeleteButton(){
        clickOn(DeleteButton);
    }

    //This button is not working in the website:
    public void clickOnCancelDeletionButton(){
        clickOn(CancelDeletionButton);
    }

}
