package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyForVendorPage extends CommonAPI {

    Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    public ApplyForVendorPage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(css = "a[href='/vendor/apply']")
    WebElement vendorAccountButton;

    @FindBy(xpath = "//input[@id='Name']")
    WebElement vendorNameField;

    @FindBy(xpath = "(//textarea[@id='Description'])[1]")
    WebElement DescreptionField;

    @FindBy(css = "#apply-vendor")
    WebElement SubmitButton;

    @FindBy(xpath = "(//div[@class='result'])[1]")
    WebElement ApplicationMessage;





    public void clickOnVendorACCButton(){
        clickOn(vendorAccountButton);
        log.info("Click on Apply For a Vendor Button Success");
    }



    public void typeVendorName(){
        type(vendorNameField, "GANGILO");
        log.info("Vendor Name Tyoed  Successfully");
    }


    public void typeVendorDescreption(){
        type(DescreptionField, "GANGILO Trois Ilots Khebat Lma ");
        log.info("Descreption entred  Successfully");
    }
    public void clickOnSubmitButton(){
        clickOn(SubmitButton);
        log.info("Click on submit Button Success");
    }

    public String RequestSubmitted(){return getTextFromElement(ApplicationMessage);}

}
