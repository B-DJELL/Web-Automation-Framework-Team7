package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends CommonAPI {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(HomePage.class.getName());




    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement Register;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement Login;

    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement SearchField;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement SearchButton;

    @FindBy(xpath = "//span[@class='wishlist-label']")
    WebElement Wishlist;

    @FindBy(xpath = "(//a[normalize-space()='Apparel'])[1]")
    WebElement Apparel;

    @FindBy(xpath = "//div[@class='header-logo']/a/img")
    WebElement NopCommerceLogo;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement ShoppingCart;

    @FindBy(css = "span.wishlist-qty")
    WebElement wishlistQuantity;


    @FindBy(xpath= "//button[normalize-space()='Go to cart']")
    WebElement shoppingCartQuantity;


    @FindBy(css = "#customerCurrency")
    WebElement CurrencyDropDown;

    @FindBy(xpath = "//option[contains(text(),'US Dollar')]")
    WebElement USD;
    @FindBy(xpath = "//option[contains(text(),'Euro')]")
    WebElement Euro;

    @FindBy(css = ".ico-logout")
    WebElement LogoutButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement ContactUsButton;

    @FindBy(css = "#newsletter-subscribe-button")
    WebElement Subscribe;

    @FindBy(css = "#newsletter-email")
    WebElement emailField;

    @FindBy(xpath = "(//a[normalize-space()='Clothing'])[1]")
    WebElement ClothingButton;

    @FindBy(xpath = "//div[@class='picture']//img[@title=\"Show details for Levi's 511 Jeans\"]")
    WebElement LevisJeans;
    @FindBy(css = "#product_enteredQuantity_30")
    WebElement  QuantityBox;
    @FindBy(css = "#price-value-30")
    WebElement unitprice;










    public void clickOnRegister() {
        clickOn(Register);
        log.info("click on register link success");
    }


    public void clickOnShoppingCart() {
        clickOn(ShoppingCart);
        log.info("click on shopping cart success");
    }


    public void clickOnNopCommerceLogo() {
        clickOn(NopCommerceLogo);
        log.info("click on nopcommerce logo success");
    }

    public void selectCurrency(String Euro) {
        selectOptionFromDropdown(CurrencyDropDown, Euro);
        log.info("select currency success");
    }

    public void searchItem(String item){
        typeAndEnter(SearchField, item);
        log.info("item name type and enter success");
    }
    public void TypeQts(){
        type(QuantityBox, String.valueOf(6));
        log.info("Quantity entred successfully");
    }



    public void clickOnContactUsButton(){
        clickOn(ContactUsButton);
        log.info("click on ContactUs success");
    }

    public void clickOnApparel() {
        clickOn(Apparel);
        log.info("click on Apparel button success");
    }

    public void selectOptionFromMenuDropdown(String option){
        selectOptionFromDropdown(CurrencyDropDown, option);
        log.info(option+" option selected from the dropdown");
    }
    public void hoverOverFloatingMenu(WebDriver driver){
        hoverOver(driver, Apparel);
        log.info("hover over menu success");

    }
    public void clickOnSubscribeButton() {
        clickOn(Subscribe);
        log.info("click on Subscribe button success");
    }
    public void EnterYourEmail(String TypeEmail){
        type(emailField, TypeEmail);
        log.info("Email entred successfully");
    }
    public void clickOnclothingButton() {
        clickOn(ClothingButton);
        log.info("click on Clothing button success");
    }
    public void clickOnLevisLinkButton() {
        clickOn(LevisJeans);
        log.info("click on Levis Jeans Link success");
    }

    public String getactuelPrice(){
        return getTextFromElement(unitprice);
    }








}
