package pages.dempnopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



    public class AddItemToComparePage extends CommonAPI {

        Logger LOG = LogManager.getLogger(AddItemToComparePage.class.getName());

        public AddItemToComparePage(WebDriver driver){PageFactory.initElements(driver, this);}

        @FindBy(xpath = "(//a[normalize-space()='Accessories'])[1]")
        WebElement Accessories;

        @FindBy(xpath = "//select[@id='products-orderby']")
        WebElement SelectFromDropDown;

        @FindBy(xpath = "//a[normalize-space()='List']")
        WebElement ListViewModeButton;
        @FindBy(xpath = "(//button[@title='Add to compare list'][normalize-space()='Add to compare list'])[2]")
        WebElement CompareButton;
        @FindBy(xpath = "//a[normalize-space()='product comparison']")
        WebElement productComparison;

        @FindBy(css=".clear-list")
        WebElement ClearListButton;

        @FindBy(xpath="//div[@class='no-data']")
        WebElement displayedMessage;


        //Reusable Steps

        public void clickOnAccessories(){
            clickOn(Accessories);
            LOG.info("select accessories  successfully");
        }
        public void ChooseListView(){
            clickOn(ListViewModeButton);
            LOG.info("List view Selected successfully");
        }

        public void ClickOnAddToCompareButton(){
            clickOn(CompareButton);
            LOG.info(" Click on Compare Button success");
        }

        public void ClickOnComparePopUpMsg(){
            clickOn(productComparison);
            LOG.info("Click on Product Comparison pop-up success");
        }
        public void ClearCompareProductList(){
            clickOn(ClearListButton);
            LOG.info("Click on Clear List Button success");
        }

        public String getNoItemsToCompareMessage(){
            return getTextFromElement(displayedMessage);
        }

    }


