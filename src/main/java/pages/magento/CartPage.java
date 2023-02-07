package pages.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchPage.class.getName());

    public CartPage (WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong")
    WebElement emptyCart;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")
    WebElement remove;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[2]/a")
    WebElement continueShopping;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[1]")
    WebElement moveToWish;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement wishMessage;
    @FindBy(xpath = "//*[@id=\"block-discount\"]/div[1]")
    WebElement discountCode;
    @FindBy(xpath = "//*[@id=\"coupon_code\"]")
    WebElement dicountField;
    @FindBy(xpath = "//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button/span")
    WebElement applyDiscountBtn;
    @FindBy(xpath = "")
    WebElement f;













//REUSABLE STEPS
    public void removeItem(){
        clickOn(remove);
        LOG.info("item removed");
    }
    public void continueShop(){
        clickOn(continueShopping);
        LOG.info("click on continue shopping lik success");
    }
    public void moveToWishList(){
        clickOn(moveToWish);
        LOG.info("move to wish list success");
    }
    public void applyDiscountCode(){
        clickOn(discountCode);
        LOG.info("applying discount arrow success ");
    }
    public void discountField(){
        dicountField.sendKeys("067196");
        LOG.info("typing discount code success");
    }
    public void discountBtn(){
        applyDiscountBtn.click();
        LOG.info("click on discount button success");
    }
public String emptyCartMsg(){ return getTextFromElement(emptyCart);}

    public String wishListMsg(){ return getTextFromElement(wishMessage);}
}
