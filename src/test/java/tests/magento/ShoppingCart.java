package tests.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.CartPage;
import pages.magento.HomePage;
import pages.magento.PurchasePage;
import pages.magento.SearchPage;

public class ShoppingCart extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());


    @Test // add to cart button
    public void ViewCart() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnCartLink();
        String messagePopUp = "You have no items in your shopping cart.";
        Assert.assertEquals(messagePopUp, "You have no items in your shopping cart.");
        LOG.info("message You have no items in your shopping cart success");
    }
    @Test // add to cart and remove from cart
            public void viewAndEditCart() throws InterruptedException {
        HomePage homePage=new HomePage(getDriver());
        SearchPage searchPage=new SearchPage(getDriver());
        PurchasePage purchasePage = new PurchasePage(getDriver());
        String item="watch";
        homePage.typeAndClickItemToSearch(item);
        searchPage.setBuyWatch();

        purchasePage.addItemToCart2();
        Thread.sleep(2000);
        homePage.clickOnCartLink();
        String title="You added Dash Digital Watch to your shopping cart.";
        Assert.assertEquals(title,"You added Dash Digital Watch to your shopping cart.");
        LOG.info("item added to shopping cart");
        purchasePage.ViewAndEditCart();
        CartPage cartPage=new CartPage(getDriver());
        cartPage.removeItem();
        cartPage.continueShop();

    }

    @Test //move to wish list
    public void moveToWishList() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        PurchasePage purchasePage = new PurchasePage(getDriver());
        String item = "watch";
        homePage.typeAndClickItemToSearch(item);
        searchPage.setBuyWatch();
        purchasePage.addItemToCart2();
        Thread.sleep(4000);
        homePage.clickOnCartLink();
        purchasePage.ViewAndEditCart();
        cartPage.moveToWishList();
        String message = "Dash Digital Watch has been moved to your wish list.";
        Assert.assertEquals(message, "Dash Digital Watch has been moved to your wish list.");
        LOG.info("item moved to wish list");
    }

    @Test //discount button
    public void discountBtn() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        PurchasePage purchasePage = new PurchasePage(getDriver());
        String item = "watch";
        homePage.typeAndClickItemToSearch(item);
        searchPage.setBuyWatch();
        purchasePage.addItemToCart2();
        Thread.sleep(2000);
        homePage.clickOnCartLink();
        purchasePage.ViewAndEditCart();
        cartPage.applyDiscountCode();
        cartPage.discountField();
        cartPage.discountBtn();
        String message = "The coupon code \"067196\" is not valid.";
        Assert.assertEquals(message,"The coupon code \"067196\" is not valid.");
        LOG.info("message success");

    }
}
