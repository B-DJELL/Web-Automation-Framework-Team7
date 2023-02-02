package tests.freecrm;

import base.CommonAPI;
import pages.freecrm.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(LoginPageTest.class.getName());

    String email= "Lhoucoutinho@gmail.com";
    String password= "Houhouhou8";

    @Test
    public void ValidEmailAddress() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle= "Cogmento CRM";
        homePage.typeEmailAddress(email);
        LOG.info("");
        homePage.typePassword(password);
        LOG.info("");
        homePage.clickOnLogin();
        LOG.info("");
        Thread.sleep(300);


        Assert.assertEquals(getCurrentTitle(),"Cogmento CRM");



    }


    String email2 = "kasgdkagd@gmail.com";
    String password2 = "houdasjjdhlas";

    @Test
    public void InvalidLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.typeEmailAddress(email2);
        LOG.info("");
        homePage.typePassword(password2);
        LOG.info("");
        homePage.clickOnLogin();
        LOG.info("");
        Assert.assertEquals(homePage.getErrorLogin(), "Something went wrong...");

    }


}
