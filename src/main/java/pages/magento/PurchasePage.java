package pages.magento;

import base.CommonAPI;
import com.beust.ah.A;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchasePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchPage.class.getName());

    public PurchasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-168\"]")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-53\"]")
    WebElement color;

    @FindBy(xpath = "//*[@id=\"qty\"]")
    WebElement quantity;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]")
    WebElement addToCart2;

    @FindBy(xpath = "//span[text()='View and Edit Cart']")
    WebElement viewAndEditCart;
    //*[@id="minicart-content-wrapper"]/div[2]/div[5]/div/a/span

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img")
    WebElement hoverOverItem;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button/span")
    WebElement clickOnAddToCart;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")
    WebElement yogaPant;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement successMsg;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]")
    WebElement wish;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[2]/span")
    WebElement compare;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement signInMsg;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement AddToCart;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement addWatchToCart;
    @FindBy(xpath = "//*[@id=\"tab-label-reviews-title\"]")
    WebElement review;
    @FindBy(css = "#Rating_4_label")
    WebElement  stars;
    @FindBy(xpath = "//*[@id=\"nickname_field\"]")
    WebElement nickName;
    @FindBy(xpath = "//*[@id=\"summary_field\"]")
    WebElement SummaryField;

    @FindBy(xpath = "//*[@id=\"review_field\"]")
    WebElement reviewField;
    @FindBy(xpath = "//*[@id=\"review-form\"]/div/div/button")
    WebElement submitReviewBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement submitionMsg;







//REUSABLE STEPS
    public void clickOnSize() throws InterruptedException {
        clickOn(size);
        LOG.info("click on S size  success");
    }

    public void ChooseColor() throws InterruptedException {
        clickOn(color);
        LOG.info("choosing color  success");

    }
//    public void quantity(){
//        PageFactory.initElements(driver,this);
//    }

//    String typeOnQuantity;
    public void typeOnQuantity(){
        quantity.clear();
        quantity.sendKeys("2");
        LOG.info("choosing quantity  success");
    }

//    public void addToCart(){
//        PageFactory.initElements(driver,this);
//    }
    public void addItemToCart(){
        addToCart.click();
        LOG.info("adding to cart  success");
    }

    public void addItemToCart2(){
        addToCart2.click();
        LOG.info("adding to cart  success");
    }

    public void ViewAndEditCart(){
        viewAndEditCart.click();
        LOG.info("click on view and edit  success");
    }

    public void hoverOverItem(WebDriver driver1){
        hoverOver(driver1,hoverOverItem);
        clickOn(clickOnAddToCart);

        LOG.info("hover over on item  success");
    }
    public void reviewItem(){
        clickOn(review);

        LOG.info("click on review  success");
    }
    public void rating(){
        clickOn(stars);

        LOG.info("4 stars  success");
    }
    public void reviewerName(){
        clickOn(nickName);
        sendKeysTxt(nickName,"ismail");

        LOG.info("click on field and type  success");
    }
    public void yogaClothes(){
        clickOn(yogaPant);


        LOG.info("click on yoga kit");
    }

    public void reviewerSumm(){
        clickOn(SummaryField);
        SummaryField.sendKeys("great item");
        LOG.info("Summary success");
    }
    public void review(){
        clickOn(reviewField);
        reviewField.sendKeys("The fit is great!" +
                " They are super comfortable and flattering. These are my favorite beyond yoga workout pants/leggings." +
                " I hope that they make them in other colors soon like dark brown, dark grey, and dark blue. :) " +
                "(I’m not into the bright colors) Please keep me posted.");
        LOG.info("review success");
    }
    public void submitReview(){
        clickOn(submitReviewBtn);
        LOG.info("click on submit button success");
    }
    public void clickOnWish(){
        wish.click();
    }
    public void clickOnCompare(){
        compare.click();
    }
    public String title(){return getTextFromElement(successMsg);

    }
    public String message(){return getTextFromElement(signInMsg);

    }
    public String addToCart(){return getTextFromElement(addToCart);

    }

    public String addWatchToCart(){return getTextFromElement(addWatchToCart);

    }
    public String submitionMessage(){return getTextFromElement(submitionMsg);

    }


}
