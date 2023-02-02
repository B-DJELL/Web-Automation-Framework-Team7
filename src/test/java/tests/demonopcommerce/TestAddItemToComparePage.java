package tests.demonopcommerce;

import base.CommonAPI;
import pages.dempnopcommerce.AddItemToComparePage;
import pages.dempnopcommerce.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddItemToComparePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestAddItemToComparePage.class.getName());


@Test

    public void AddToCompareList () throws InterruptedException {
    String actualHomePageTitle = getCurrentTitle();
    String expectedHomePageTitle = "nopCommerce demo store";
    LOG.info("actual home page title" + actualHomePageTitle);
    Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
    LOG.info("land to nopcommerce home page success");
    HomePage hover = new HomePage(getDriver());
    hover.hoverOverFloatingMenu(driver);
    Thread.sleep(2000);
    AddItemToComparePage accessor= new AddItemToComparePage(getDriver());
    accessor.clickOnAccessories();
    Thread.sleep(2000);
    accessor.ChooseListView();
    Thread.sleep(2000);
    accessor.ClickOnAddToCompareButton();
    Thread.sleep(2000);
    accessor.ClickOnComparePopUpMsg();
    Thread.sleep(2000);
    accessor.ClearCompareProductList();
    Thread.sleep(2000);
    AddItemToComparePage added=new AddItemToComparePage(getDriver());
    String Itemcleared = added.getNoItemsToCompareMessage();

    Assert.assertEquals(Itemcleared , "You have no items to compare.");
    LOG.info("items to compare message validation success");
    Thread.sleep(2000);
    hover.clickOnNopCommerceLogo();
    String returnHomePageTitle = getCurrentTitle();
    String expectHomePageTitle = "nopCommerce demo store";
    LOG.info("actual home page title" + returnHomePageTitle);
    Assert.assertEquals(actualHomePageTitle, expectHomePageTitle);
    LOG.info("land to nopcommerce home page success");




    }

}
