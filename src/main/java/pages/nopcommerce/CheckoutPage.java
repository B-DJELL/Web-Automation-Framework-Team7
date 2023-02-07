package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage(WebDriver driver){PageFactory.initElements(driver, this);}


    @FindBy(css = "#ShipToSameAddress")
    WebElement SameAdressCheckBox;
    @FindBy(css = "#BillingNewAddress_FirstName")
    WebElement BillingFirstName;
    @FindBy(css = "#BillingNewAddress_LastName")
    WebElement BillingLastName;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Email']")
    WebElement Billingemail;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    WebElement BillingCountry;

    @FindBy(css = "#BillingNewAddress_City")
    WebElement BillingCity;
    @FindBy(css = "#BillingNewAddress_Address1")
    WebElement BillingAddress1;
    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    WebElement BillingZipCode;
    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    WebElement BillingPhoneNumber;
    @FindBy(css = "button[onclick='Billing.save()']")
    WebElement BillingContinueButton;
    @FindBy(xpath = "(//input[@id='shippingoption_1'])[1]")
    WebElement shippingOptionCheckBox;
    @FindBy(css = ".button-1.shipping-method-next-step-button")
    WebElement shippingContinueButton;
    @FindBy(css = "#paymentmethod_1")
    WebElement ByCreditCard;
    @FindBy(css = ".button-1.payment-method-next-step-button")
    WebElement PaymentContinueButton;
    @FindBy(css = "#CreditCardType")
    WebElement CreditcardDropDown;
    @FindBy(css = "#CardholderName")
    WebElement CardholderName;
    @FindBy(xpath = "//input[@id='CardNumber']")
    WebElement cardnUmber;
    @FindBy(xpath = "//select[@id='ExpireMonth']")
    WebElement  expMonth;
    @FindBy(xpath = "//select[@id='ExpireYear']")
    WebElement  expYear;
    @FindBy(xpath = "//input[@id='CardCode']")
    WebElement cardcode;
    @FindBy(css = ".button-1.payment-info-next-step-button")
    WebElement  continustepButton;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement ConfirmButton;
    @FindBy(css="div[class='section order-completed'] div[class='title'] strong")
    WebElement OrderSuccess;







    public void cheCkSameAdressCheckBox(){
        clickOn(SameAdressCheckBox);
        LOG.info("Check Ship to the same address success");
    }



    public void typeFirstName(){
        type(BillingFirstName,"mick");
        LOG.info("first name typed successfully");
    }

    public void typeLastName(){
        type(BillingLastName,"jonson");
        LOG.info("last name typed successfully");
    }
    public void typeEmailAddress(String emailAddress){
        type(Billingemail, emailAddress);
        LOG.info("type email address success");
    }
    public void typeCity(String City){
        type(BillingCity, City);
        LOG.info("Billing City  typed successfully");
    }
    public void typeAdress1(String hommeAdress){
        type(BillingAddress1, hommeAdress);
        LOG.info("Home Adress typed successfully");
    }
    public void typeZipCode(String ZipCode){
        type(BillingZipCode,ZipCode);
        LOG.info("Zip Code typed successfully");
    }
    public void typePhoneNUmber(String PhoneNumber){
        type(BillingPhoneNumber,PhoneNumber);
        LOG.info("Phone Number typed successfully");
    }
    public void cLickOnContinueButton(){
        clickOn(BillingContinueButton);
        LOG.info("Click On Continue Button success");
    }
    public void checkNextDayAirButton(){
        clickOn(shippingOptionCheckBox);
        LOG.info("Click Next Day Air Button success");
    }

    public void selectOptionFromMenuDropdown(String Algeria){
        selectOptionFromDropdown(BillingCountry, "Algeria");
        LOG.info(Algeria+" option selected from the dropdown");
    }
    public void cLickOnShippingContinueButton(){
        clickOn(shippingContinueButton);
        LOG.info("Click On Continue Button success");
    }
    public void checkPayByCreditButton(){
        clickOn(ByCreditCard);
        LOG.info("Click on  Pay Bay Credit Card success");
    }

    public void clickPayContinueButton(){
        clickOn(PaymentContinueButton);
        LOG.info("Click on Continue Button success");
    }

    public void selectCardTypeFromMenuDropdown(String Discover){
        selectOptionFromDropdown(CreditcardDropDown, "Discover");
        LOG.info(Discover+" option selected from the dropdown");
    }
    public void typeCardHolderName( String Cardholdername){
        type(CardholderName,Cardholdername);
        LOG.info("Card Holder Name typed successfully");
    }
    public void typeCardNumber( String cardNumber){
        type(cardnUmber,cardNumber);
        LOG.info("Card Number typed successfully");
    }
    public void typeExpMonth( String expirationMonth){
        type(expMonth,"03");
        LOG.info("Expiration Month  typed successfully");
    }
    public void typeExpYear( String expirationYear){
        type(expYear,"2028");
        LOG.info("Expiration year  typed successfully");
    }
    public void typeCardCode( String cardCode){
        type(cardcode,cardCode);
        LOG.info("Card Code typed successfully");
    }
    public void clickonContinueStepButton(){
        clickOn(continustepButton);
        LOG.info("Click on Continue Button success");
    }
    public void cLickOnConFirmButton(){
        clickOn(ConfirmButton);
        LOG.info("Click On Continue Button success");
    }
    public String  OrdersuccessMessage(){return getTextFromElement(OrderSuccess);}

}
