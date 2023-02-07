package pages.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(SearchPage.class.getName());

    public SearchPage(WebDriver driver) {
        Actions builder = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[8]/div/a/span/span/img")
    WebElement HoodiePicture;

    @FindBy(css = "button[title='Search']")
    WebElement searchButton;
//
//    @FindBy(xpath = "")
//    WebElement y;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/a/span/span/img")
    WebElement selectedWatch;

    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]")
    WebElement addPinkWatch;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
    WebElement resultErrorMessage;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[1]/div[1]/strong[2]")
    WebElement viewList;

    @FindBy(xpath = "//div[@class='columns']//div[3]//div[3]//div[1]//select[1]")
    WebElement showPerPage;

    @FindBy(xpath = "//*[@id=\"sorter\"]")
    WebElement relevanceBtn;

    @FindBy(xpath = "//*[@id=\"sorter\"]/option[2]")
    WebElement price;

    @FindBy(xpath = "//div[@class='column main']//div[1]//div[2]//div[1]//select[1]//option[3]")
    WebElement numberOfItem;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li[3]")
    WebElement nextPage;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li[5]/a")
    WebElement arrowNextPage;

    @FindBy(xpath = "")
    WebElement x;
    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/a/span/span/img")
    WebElement clickOnBuyWatch;
    //HOVER OVER
    @FindBy(xpath = "/html/body")
    WebElement hoverOverWatch;


    //REUSABLE STEPS
    public void clickOnHoodiePicture() throws InterruptedException {
        clickOn(HoodiePicture);
        LOG.info("click on hoodie picture success");
    }

    public void hoverOverGear(WebDriver driver) throws InterruptedException {
        hoverOverGear(driver);
//        hoverOver(driver,hoverOverWatch);
    }

    public void selectedWatch() {
        clickOn(selectedWatch);
        LOG.info("click on selected watch  success");
    }

    public void addPinkWatch() {
        clickOn(addPinkWatch);
        LOG.info("click on selected watch  success");
    }

    public void searchBtn() {
        clickOn(searchButton);
        LOG.info("click on search Button  success");
    }

    public void changeViewList() {
        clickOn(viewList);

        LOG.info("click on list Button  success");
    }

    public void showPages() {
        clickOn(showPerPage);
        LOG.info("click on show per page Button  success");
    }

    public void relevance() {
        clickOn(relevanceBtn);
        LOG.info("click on relevance Button  success");
    }

    public void relevancePrice(WebDriver driver) {
        clickOn(price);
        LOG.info("click on price  success");
    }

    public void numOfItemsOnPage() {
        clickOn(numberOfItem);
        LOG.info("click on number of pages to show success");
    }

    public void nextSearchPage() {
        clickOn(nextPage);
        LOG.info("click on number of next page success");
    }

    public void arrowNextSearchPage() {
        clickOn(arrowNextPage);
        LOG.info("click on number of next page success");
    }
    public void setBuyWatch() {
        clickOn(clickOnBuyWatch);
        LOG.info("click on watch success");
    }

    public String resultErrorMessage() {
        return getTextFromElement(resultErrorMessage);
    }
}