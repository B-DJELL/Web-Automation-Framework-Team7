package pages.dempnopcommerce;
import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseMacPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(PurchaseMacPage.class.getName());

    public PurchaseMacPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#termsofservice")
    WebElement termsofServiceButton;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement CheckoutButton;


    @FindBy(xpath = "(//button[normalize-space()='Add to cart'])[1]")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    WebElement addMinimumToCartBotton;

//  reusable steps


    public void clickOnAddToCartButton(){
        clickOn(addToCartButton);
        LOG.info("click add to cart button success");
    }

    public void AddMinimumtoCart(){
        clickOn(addMinimumToCartBotton);
        LOG.info("click add to cart button successfully");
    }

    public void clickOnIagreeButton(){
        clickOn(termsofServiceButton);
        LOG.info("click on I Agree with Terms button success");
    }

    public void clickOnCheckoutButton(){
        clickOn(CheckoutButton);
        LOG.info("click on checkout button success");
    }




}
