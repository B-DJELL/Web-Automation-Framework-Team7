package tests.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.*;

public class Checkout extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());
    Faker fakeData = new Faker();
    String emailAddress = fakeData.internet().emailAddress();
    String password = fakeData.internet().password();
    String name = fakeData.name().firstName();
    String lastNam=fakeData.name().lastName();
@Test
    public void checkoutitems() throws InterruptedException {

    HomePage homePage = new HomePage(getDriver());
    PurchasePage purchasePage=new PurchasePage(getDriver());
    CheckoutPage checkoutPage=new CheckoutPage(getDriver());
    SignInPage signInPage=new SignInPage(getDriver());

    homePage.hoverOverFloatingMenu(driver);
    homePage.clickOnWatches();

    purchasePage.hoverOverItem(driver);
    Thread.sleep(1000);
    purchasePage.addItemToCart();
    homePage.clickOnCartLink();

    checkoutPage.clickOnCheckoutButton();

    checkoutPage.emailAddress();
    checkoutPage.enterPassword();
    checkoutPage.logIn();
    checkoutPage.shippingMethod();
    checkoutPage.clickNext();
    checkoutPage.clickPlaceOrder();

    String message ="Thank you for your purchase!";
    Assert.assertEquals(message,"Thank you for your purchase!");
    LOG.info("message shows up");
    checkoutPage.clickContinueShopping();

}
    @Test
    public void checkout() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        PurchasePage purchasePage=new PurchasePage(getDriver());
        CheckoutPage checkoutPage=new CheckoutPage(getDriver());
        SignInPage signInPage=new SignInPage(getDriver());

        homePage.hoverOverFloatingMenu(driver);
        homePage.clickOnWatches();

        purchasePage.hoverOverItem(driver);
        purchasePage.addItemToCart();
        homePage.clickOnCartLink();

        checkoutPage.clickOnCheckoutButton();
        checkoutPage.emailAddress();
        checkoutPage.enterPassword();
        checkoutPage.logIn();
        checkoutPage.shippingMethod();
        checkoutPage.clickNext();
        checkoutPage.clickPlaceOrder();

        String message ="Thank you for your purchase!";
        Assert.assertEquals(message,"Thank you for your purchase!");
        LOG.info("message shows up");
    }
}
