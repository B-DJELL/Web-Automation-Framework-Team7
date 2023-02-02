package pages.dempnopcommerce;

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
    WebElement USDOption;
    @FindBy(xpath = "//option[contains(text(),'Euro')]")
    WebElement EuroOption;

    @FindBy(css = ".ico-logout")
    WebElement LogoutButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement ContactUsButton;

    @FindBy(css = "#newsletter-subscribe-button")
    WebElement Subscribe;

    @FindBy(css = "#newsletter-email")
    WebElement emailField;







    public void clickOnRegister() {
        clickOn(Register);
        log.info("click on register link success");
    }

    public void clkOnLnkLogin() {
        clickOn(Login);
        log.info("click on log in link success");
    }

    public void clkOnLnkWishlist() {
        clickOn(Wishlist);
        log.info("click on whishlist link success");
    }

    public String getWishlistQuantity() {
        log.info("Whishlist quantity success");
        return getTextFromElement(wishlistQuantity);
    }

    public void clickOnShoppingCart() {
        clickOn(ShoppingCart);
        log.info("click on shopping cart success");
    }

    public String getShoppingCartQuantity() {
        log.info("Shopping cart quantity success");
        return getTextFromElement(shoppingCartQuantity);
    }



    public void clickSearchButton() {
        clickOn(SearchButton);
        log.info("click on search success");
    }

//    public Boolean logoNopCommerceIsDisplayed() {
//        log.info("logo verified");
//        return elementIsDisplayed(NopCommerceLogo);
//  }

    public void clickOnNopCommerceLogo() {
        clickOn(NopCommerceLogo);
        log.info("click on nopcommerce logo success");
    }

    public void selectCurrency(String option) {
        selectOptionFromDropdown(CurrencyDropDown, option);
        log.info("select currency success");
    }
    public void clickOnLnkLogout(){
        clickOn(LogoutButton);
        log.info("click on logout success");
    }
    public void searchItem(String item){
        typeAndEnter(SearchField, item);
        log.info("item name type and enter success");
    }

    public void ScrollDown(){

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


   // public boolean UsDollarIsSelected (){
       // return elementIsSelected(USDOption);
   // }
    //public boolean EuroIsSelected (){
       // return elementIsSelected(EuroOption);
    //}






}
