package tests.nopcommerce;

import base.CommonAPI;

import pages.nopcommerce.HomePage;
import pages.nopcommerce.WishListPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWishList extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestWishList.class.getName());


@Test


    public void AdditemToWishlist() throws InterruptedException {
    String actualHomePageTitle = getCurrentTitle();
    String expectedHomePageTitle = "nopCommerce demo store";
    LOG.info("actual home page title" + actualHomePageTitle);
    Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
    LOG.info("land to nopcommerce home page success");
    HomePage ApparelButton = new HomePage(getDriver());
    ApparelButton.clickOnApparel();
    Thread.sleep(2000);
    WishListPage wishList= new WishListPage(getDriver());
    wishList.clickOnShoesImage();
    Thread.sleep(2000);
    wishList.chooseColor();
    Thread.sleep(3000);
    wishList.AddItemToWishList();
    Thread.sleep(3000);
    wishList.checkWishList();
    Thread.sleep(3000);
    LOG.info("Item Added to Wish List Successfully");
    Thread.sleep(3000);
    wishList.ReturnToHomePage();
    LOG.info("land to nopcommerce home page success");
    Thread.sleep(3000);

    }
}



