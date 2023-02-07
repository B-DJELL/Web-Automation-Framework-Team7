package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(WishListPage.class.getName());

    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//a[@title='Show products in category Shoes'][normalize-space()='Shoes'])[1]")
    WebElement ShoesImage;

    @FindBy(xpath = "(//input[@id='attribute-option-14'])[1]")
    WebElement Color;

    @FindBy(xpath = "(//button[@title='Add to wishlist'][normalize-space()='Add to wishlist'])[3]")
    WebElement   NikeSBZoom;

    @FindBy(xpath ="//a[normalize-space()='wishlist']")
    WebElement  wishlist;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement webSiteLogo;


// reusable steps


    public void clickOnShoesImage (){
        clickOn(ShoesImage);
        LOG.info("click on Shoes Image  success");
    }
    public void chooseColor() {
        clickOn(Color);

    LOG.info("select color Box  success");}


    public void AddItemToWishList (){
        clickOn(NikeSBZoom);
        LOG.info("click on add to Wish list Button  success");

    }
    public void checkWishList (){
        clickOn(wishlist);
        LOG.info("item added to Wish list ");
    }
    public void ReturnToHomePage (){
        clickOn(webSiteLogo);
        LOG.info("Return To Home Page Success ");
    }
}
