package tests.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    homePage.hoverOverFloatingMenu(driver);
    homePage.clickOnWatches();

    purchasePage.hoverOverItem(driver);
    Thread.sleep(3000);
    purchasePage.addItemToCart();
    homePage.clickOnCartLink();
    CheckoutPage checkoutPage=new CheckoutPage(getDriver());
    checkoutPage.clickOnCheckoutButton();
    SignInPage signInPage=new SignInPage(getDriver());
    Thread.sleep(2000);
    checkoutPage.emailAddress();
    Thread.sleep(2000);
    checkoutPage.enterPassword();
    Thread.sleep(2000);
//    checkoutPage.logIn();
    Thread.sleep(2000);
    checkoutPage.customerFirstName();
    Thread.sleep(6000);
    checkoutPage.customerLastName();
    checkoutPage.company();
    Thread.sleep(5000);
    checkoutPage.mailingAddress();
    Thread.sleep(5000);
}
    @Test
    public void checkout() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        PurchasePage purchasePage=new PurchasePage(getDriver());

        homePage.hoverOverFloatingMenu(driver);
        homePage.clickOnWatches();

        purchasePage.hoverOverItem(driver);
        Thread.sleep(3000);
        purchasePage.addItemToCart();
        homePage.clickOnCartLink();
        CheckoutPage checkoutPage=new CheckoutPage(getDriver());
        checkoutPage.clickOnCheckoutButton();
        SignInPage signInPage=new SignInPage(getDriver());
        Thread.sleep(4000);
        checkoutPage.emailAddress();
        Thread.sleep(4000);
        checkoutPage.enterPassword();
        Thread.sleep(9000);
        checkoutPage.customerFirstName();
        Thread.sleep(9000);
        checkoutPage.customerLastName();
    }
}
