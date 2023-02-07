package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchPage extends CommonAPI {

    public SearchPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(SearchPage.class.getName());


    @FindBy(xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computers;
    @FindBy(xpath = "(//a[normalize-space()='Desktops'])[1]")
    WebElement Desktops;
    @FindBy(xpath = "//img[@title='Show details for Build your own computer']")
    WebElement buildyourOwnComp;
    @FindBy(xpath = "(//select[@id='product_attribute_2'])[1]")
    WebElement RamDropDown;
    @FindBy(xpath = " //*[@id=\"product_attribute_2\"]/option[4]")
    WebElement eightGb;
    @FindBy(css = "#product_attribute_3_7")
    WebElement  HardDrive;
    @FindBy(css = "#product_attribute_4_9")
    WebElement OsPremium;
    @FindBy(xpath = "//div[@class='no-result']")
    WebElement NoItemMessage;



    public void hoverOverFloatingMenu(WebDriver driver){
        hoverOver(driver, computers);
        log.info("hover over computers menu success");

    }
    public void cLickOnDesktops(){
        clickOn(Desktops);
        log.info("Click on Desktops success");
    }
    public void cLickOnBuildYourOwn(){
        clickOn(buildyourOwnComp);
        log.info("Click on Build your Own computer success");
    }
    public void selectOptionFromMenuDropdown(String eightGb){
        selectOptionFromDropdown(RamDropDown, "eightGb");
        log.info(eightGb+" option selected from the dropdown");
    }
    public void cLickOnHDD(){
        clickOn(HardDrive);
        log.info("Click on 400GB HDD success");
    }
    public void cLickOnOs(){
        clickOn(OsPremium);
        log.info("Click on Vista Premium success");
    }
    public String ItemnoFoundError(){return getTextFromElement(NoItemMessage);}




}
