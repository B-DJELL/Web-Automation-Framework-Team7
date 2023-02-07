package tests.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePage;
import pages.nopcommerce.SearchPage;

public class TestSearch extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestSearch.class.getName());


    @Test

    public void SearchandCustomizeanItem ()  {
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        SearchPage search = new SearchPage(getDriver());
        search.hoverOverFloatingMenu(driver);
        search.cLickOnDesktops();
        search.cLickOnBuildYourOwn();
        search.cLickOnHDD();
        search.cLickOnOs();
        LOG.info("Customazed search validation success");

    }

    @Test
    public void SearchForUnavailableItem(){
        String actualHomePageTitle = getCurrentTitle();
        String expectedHomePageTitle = "nopCommerce demo store";
        LOG.info("actual home page title" + actualHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        LOG.info("land to nopcommerce home page success");
        HomePage home = new HomePage(getDriver());
        String item = "Mercedes AMG S63";
        home.searchItem(item);
        SearchPage noFound=new SearchPage(getDriver());
        String NoproductFound= noFound.ItemnoFoundError();
        Assert.assertEquals(NoproductFound, "No products were found that matched your criteria.");
        LOG.info("No products were found that matched your criteria validation success");

    }

}
