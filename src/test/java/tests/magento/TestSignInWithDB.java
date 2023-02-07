package tests.magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.SignInPage;
import utility.ConnectDB;

public class TestSignInWithDB extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());



    @Test
    public void signInWithExcel() throws InterruptedException {
        HomePage homePage= new HomePage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());


        String title = getCurrentTitle();
        Assert.assertEquals(title,"Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing" +
                " | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites " +
                "Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("land to home page success");

        homePage.clickOnSignInButton();
        Thread.sleep(5000);


}
}
