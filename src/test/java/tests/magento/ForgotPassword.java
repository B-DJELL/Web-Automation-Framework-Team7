package tests.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.ForgotPasswordPage;
import pages.magento.HomePage;
import pages.magento.SignInPage;

public class ForgotPassword extends CommonAPI {
    Logger LOG = LogManager.getLogger(SearchBar.class.getName());
    Faker fakeData = new Faker();
    String emailAddress = fakeData.internet().emailAddress();
    String password = fakeData.internet().password();
    String name = fakeData.name().firstName();
    String lastNam=fakeData.name().lastName();

    @Test
    public void forgotPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnSignInButton();
        Thread.sleep(3000);


        SignInPage signInPage = new SignInPage(getDriver());
        Thread.sleep(3000);

        signInPage.forgotPassword();
        Thread.sleep(3000);
        String forgotPassword =getCurrentTitle();
        Assert.assertEquals(forgotPassword,"Forgot Your Password? Magento Commerce - website to practice" +
                " selenium | demo website for automation testing | selenium practice sites");
        LOG.info("log to forgot password");

        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(getDriver());
        forgotPasswordPage.emailForRestoringPass(emailAddress);
        Thread.sleep(3000);
        signInPage.resetMyPasswordBtn();
        Thread.sleep(3000);
        String error= signInPage.getRequiredField();
        Assert.assertEquals(error,"This is a required field.");
        LOG.info("error message shows up");
        Thread.sleep(3000);

    }
    @Test
    public void forgotPasswordPass() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnSignInButton();
        Thread.sleep(3000);


        SignInPage signInPage = new SignInPage(getDriver());
        Thread.sleep(3000);

        signInPage.forgotPassword();
        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(getDriver());
        forgotPasswordPage.emailForRestoringPass(emailAddress);
        Thread.sleep(9000);
        signInPage.resetMyPasswordBtn();






}
}



