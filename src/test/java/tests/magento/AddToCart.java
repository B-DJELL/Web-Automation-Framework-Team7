package tests.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.PurchasePage;
import pages.magento.SearchPage;

public class AddToCart extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());

        @Test //testing add to cart button after landing to the item page
        public void addToCart1() throws InterruptedException {
            HomePage homePage = new HomePage(getDriver());
            homePage.hoverOverFloatingMenu(driver);
            homePage.clickOnWatches();

            String title=getCurrentTitle();
            Assert.assertEquals(title,"Watches - Gear Magento Commerce - website to practice selenium" +
                    " | demo website for automation testing | selenium practice sites");
            LOG.info("land to watches page");

            SearchPage searchPage = new SearchPage(getDriver());
            searchPage.selectedWatch();
            searchPage.addPinkWatch();

        }
        @Test // testing add to cart by hover over on the item and click add to cart

        public void addToCart2() throws InterruptedException {
            HomePage homePage = new HomePage(getDriver());
            PurchasePage purchasePage=new PurchasePage(getDriver());

            homePage.hoverOverFloatingMenu(driver);
            homePage.clickOnWatches();

            purchasePage.hoverOverItem(driver);
            Thread.sleep(1000);
            purchasePage.addItemToCart();
    }

    }

