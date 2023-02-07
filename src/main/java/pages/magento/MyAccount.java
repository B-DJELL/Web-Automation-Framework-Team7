package pages.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public MyAccount(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")
    WebElement myOrders;

    @FindBy(css = "div[class='panel header'] button[type='button']")
    WebElement arrow;


    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
    WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/a/span")
    WebElement addressBook;

    @FindBy(xpath = "//*[@id=\"company\"]")
    WebElement companyField;

    @FindBy(xpath = "//*[@id=\"telephone\"]")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"street_1\"]")
    WebElement mailingAddress;
//
    @FindBy(xpath = "//*[@id=\"street_2\"]")
    WebElement address2;
//
    @FindBy(xpath = "Thread.sleep(5000);")
    WebElement city;
//
    @FindBy(xpath = "//*[@id=\"region_id\"]")
    WebElement state;

    @FindBy(xpath = "//*[@id=\"region_id\"]/option[44]")
    WebElement newYork;

    @FindBy(xpath = "//*[@id=\"zip\"]")
    WebElement zip;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement save;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement successMsg;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/button")
    WebElement addNewAddress;

    @FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[7]")
    WebElement accountInfo;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement message2;

    @FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[4]")
    WebElement wishList;

    @FindBy(xpath = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[3]")
    WebElement addAllToCart;

    @FindBy(xpath = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[2]")
    WebElement shareWishList;

    @FindBy(xpath = "//*[@id=\"email_address\"]")
    WebElement emailsField;

    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement messageField;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement shareWish;




//REUSABLE STEPS
    public void orders(){
        clickOn(myOrders);
        LOG.info("click on my orders success");
    }
    public void arrow(){
        clickOn(arrow);
        LOG.info("click on arrow success");
    }

    public void ClickOnMyAccount(){
        clickOn(myAccount);
        LOG.info("click on my account success");
    }
    public void manageAddress(){
        clickOn(addressBook);
        LOG.info("click on manage address success");
    }
    public void company(){
        clickOn(companyField);
        type(companyField,"PNT");
        LOG.info("click on manage address success");
    }
    public void phoneNum(){
        clickOn(phoneNumber);
        type(phoneNumber,"+1(646)7368461");
        LOG.info("phone number success");
    }
    public void address() {
        clickOn(mailingAddress);
        type(mailingAddress, "2019 85TH ST");
        clickOn(address2);
        type(address2, "GFL");
        LOG.info("phone number success");
    }
    public void setCity() {
        clickOn(city);
        type(city,"brooklyn");
        LOG.info("city success");

    }
    public void province_state(){
        clickOn(state);
        clickOn(newYork);
        LOG.info("state success");
    }
    public void zipCode(){
        clickOn(zip);
        type(zip,"11215");
        LOG.info("zip success");
    }
    public void saveBtn(){
        clickOn(save);
        LOG.info("click on save button success");
    }
    public void addNewAddressBtn(){
        clickOn(addNewAddress);
        LOG.info("click on add new address button success");
    }
    public void accountInformation(){
        clickOn(accountInfo);
        LOG.info("click on account info button success");
    }
    public void saveButton(){
        clickOn(saveBtn);
        LOG.info("click on save button success");
    }
    public void myWishList(){
        clickOn(wishList);
        LOG.info("click on my wish list  success");
    }
    public void clickAddAllToCart(){
        clickOn(addAllToCart);
        LOG.info("click on add all to cart  success");
    }
    public void clickOnShareWishList(){
        clickOn(shareWishList);
        LOG.info("click on share wish list  success");
    }
    public void emailsField(){
        clickOn(emailsField);
        String emails="ismail@gmail.com,bader@gmail.com,abc@hotmail.fr";
        type(emailsField,emails);
        LOG.info("click on share wish list  success");
    }
    public void messageWish(){
        clickOn(messageField);
        String message="i suggest this item";
        type(messageField,message);
        LOG.info("typing message  success");
    }
    public void shareWishByEmail(){
        clickOn(shareWish);
        LOG.info("click on share wish list  success");
    }
    public String message() {
        return getTextFromElement(successMsg);
    }
    public String message2() {
        return getTextFromElement(message2);
    }

}
