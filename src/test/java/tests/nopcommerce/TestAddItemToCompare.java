package tests.nopcommerce;

import base.CommonAPI;
import pages.nopcommerce.AddItemToComparePage;
import pages.nopcommerce.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddItemToCompare extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestAddItemToCompare.class.getName());


@Test

    public void AddToCompareList () throws InterruptedException {
    String actualHomePageTitle = getCurrentTitle();
    String expectedHomePageTitle = "nopCommerce demo store";
    LOG.info("actual home page title" + actualHomePageTitle);
    Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
    LOG.info("land to nopcommerce home page success");
    HomePage hover = new HomePage(getDriver());
    hover.hoverOverFloatingMenu(driver);
    AddItemToComparePage accessor= new AddItemToComparePage(getDriver());
    accessor.clickOnAccessories();
    accessor.ChooseListView();
    Thread.sleep(1000);
    accessor.ClickOnAddToCompareButton();
    accessor.ClickOnComparePopUpMsg();
    accessor.ClearCompareProductList();
    AddItemToComparePage added=new AddItemToComparePage(getDriver());
    String Itemcleared = added.getNoItemsToCompareMessage();
    Assert.assertEquals(Itemcleared , "You have no items to compare.");
    LOG.info("items to compare message validation success");
    hover.clickOnNopCommerceLogo();
    String returnHomePageTitle = getCurrentTitle();
    String expectHomePageTitle = "nopCommerce demo store";
    LOG.info("actual home page title" + returnHomePageTitle);
    Assert.assertEquals(actualHomePageTitle, expectHomePageTitle);
    LOG.info("land to nopcommerce home page success");


    }

}
