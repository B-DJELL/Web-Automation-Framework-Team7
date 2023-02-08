package pages.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class CheckoutPage extends CommonAPI {
        Logger LOG = LogManager.getLogger(SearchPage.class.getName());

        public CheckoutPage(WebDriver driver) {
            PageFactory.initElements(driver, this);


        }

        @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
        WebElement checkoutBtn;

        @FindBy(xpath = "//*[@id=\"HGC2L4N\"]")
        WebElement companyField;

        @FindBy(xpath = "//*[@id=\"NM6J43X\"]")
        WebElement address;

        @FindBy(xpath = "//*[@id=\"QHPAMKY\"]")
        WebElement address2;

        @FindBy(xpath = "//*[@id=\"customer-email\"]")
        WebElement customerEmail;

        @FindBy(xpath = "//*[@id=\"customer-password\"]")
        WebElement password;

        @FindBy(xpath = "//input[@id='FKT0CNT']")
        WebElement firstName;

        @FindBy(xpath = "//*[@id=\"D8RGS3Q\"]")
        WebElement lastName;

        @FindBy(xpath = "//*[@id=\"QFF63P2\"]")
        WebElement customerCity;

        @FindBy(xpath = "//*[@id=\"JPD5Y6I\"]")
        WebElement customerState;

        @FindBy(xpath = "//*[@id=\"JPD5Y6I\"]/option[44]")
        WebElement newYork;

        @FindBy(xpath = "//*[@id=\"CDD582N\"]")
        WebElement zipCode;

        @FindBy(xpath = "//*[@id=\"customer-email-fieldset\"]/fieldset/div[2]/div[1]/button")
        WebElement loginB;

        @FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
        WebElement radioBtn;

        @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
        WebElement nextBtn;

        @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")
        WebElement placeOrder;

        @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a/span")
        WebElement continueShop;



        // REUSABLE STEPS

        public void clickOnCheckoutButton() {
            clickOn(checkoutBtn);
            LOG.info("click on cart link success");
        }
        public void company() {
            clickOn(companyField);
            sendKeysTxt(companyField,"PNT");
            LOG.info("click on cart link success");
        }
        public void mailingAddress() {
            clickOn(address);
            sendKeysTxt(address,"2019 85TH ST BROOKLYN");
            clickOn(address2);
            sendKeysTxt(address2,"APT 1, NEW YORK, 11214");
            LOG.info("click on cart link success");
        }
        public void emailAddress() {
            clickOn(customerEmail);
            type(customerEmail,"leghzali@gmail.com");
            LOG.info("email success");
        }
        public void enterPassword() {
            clickOn(password);
            type(password,"@ISMAIL@leghzali@");
            LOG.info("password success");
        }
        public void customerFirstName() {
            clickOn(firstName);
            type(firstName,"ismail");
            LOG.info("first name success");
        }
        public void customerLastName() {
            clickOn(lastName);
            type(lastName,"leghzali");
            LOG.info("last name success");
        }
        public void city() {
            clickOn(customerCity);
                type(customerCity,"brooklyn");
            LOG.info("city success");
        }
        public void state() {
            clickOn(customerState);
            hoverOver(driver,newYork);
            clickOn(newYork);
            LOG.info("state success");
        }
        public void zip() {
            clickOn(zipCode);
            type(zipCode,"11214");
            LOG.info("zip code success");
        }
        public void logIn() {
            clickOn(loginB);
            LOG.info("log success");
        }
        public void shippingMethod() {
            clickOn(radioBtn);
            LOG.info("click radio button success");
        }
        public void clickNext() {
            clickOn(nextBtn);
            LOG.info("click next button success");
        }
        public void clickPlaceOrder() {
            clickOn(placeOrder);
            LOG.info("click replace order button success");
        }
        public void clickContinueShopping() {
            clickOn(continueShop);
            LOG.info("click continue shopping button success");
        }

    }


