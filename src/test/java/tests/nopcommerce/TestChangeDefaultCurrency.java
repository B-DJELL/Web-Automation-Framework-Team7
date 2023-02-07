package tests.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePage;

import java.time.Duration;

public class TestChangeDefaultCurrency extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestChangeDefaultCurrency.class.getName());

    @Test

    public void selectItemUsingEuroCurrency() throws InterruptedException {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage currency = new HomePage(getDriver());
        currency.selectCurrency("Euro");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        LOG.info("Currency Was Changed From USD To EURO Successfully");
        currency.hoverOverFloatingMenu(driver);
        currency.clickOnclothingButton();
        currency.clickOnLevisLinkButton();
        currency.TypeQts();
        String ActualPrice= currency.getactuelPrice();
        Assert.assertEquals(ActualPrice, "€37.41");
        LOG.info("Item price in Euro validation success");


    }


}
