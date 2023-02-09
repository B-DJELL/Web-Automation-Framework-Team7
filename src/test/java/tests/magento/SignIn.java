package tests.magento;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magento.HomePage;
import pages.magento.SignInPage;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.io.File;

public class SignIn extends CommonAPI {

    Logger LOG = LogManager.getLogger(SearchBar.class.getName());
    Faker fakeData = new Faker();
    String emailAddress = fakeData.internet().emailAddress();
    String password = fakeData.internet().password();

    @Test // sign in with correct credentials

    public void a_signIn() throws InterruptedException {
        HomePage homePage= new HomePage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());


        String title = getCurrentTitle();
        Assert.assertEquals(title,"Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing" +
                " | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites " +
                "Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
            LOG.info("land to home page success");

            homePage.clickOnSignInButton();
            signInPage.typeEmailAddress(emailAddress);
            signInPage.password(password);
            signInPage.SignInButton2();

        String welcomeMessage = "Welcome, ismail leghzali! Change";
        Assert.assertEquals(welcomeMessage,"Welcome, ismail leghzali! Change");
        LOG.info("welcome user");


        }

    @Test // sign in with correct credentials by reading from Data Base

    public void signInWithDB() throws InterruptedException {
        HomePage homePage= new HomePage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());


        String title = getCurrentTitle();
        Assert.assertEquals(title,"Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing" +
                " | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites " +
                "Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("land to home page success");

        homePage.clickOnSignInButton();

        String email = ConnectDB.getTableColumnData("select * from client","CustomerEmail").get(0);
        signInPage.typeEmailAddress(email);
        String password = ConnectDB.getTableColumnData("select * from client","CustomerPassword").get(0);

        signInPage.password(password);
        signInPage.SignInButton2();

        String welcomeMessage = "Welcome, ismail leghzali! Change";
        Assert.assertEquals(welcomeMessage,"Welcome, ismail leghzali! Change");
        LOG.info("welcome user");
    }


    @Test   //Testing wrong credentials
    public void b_wrongCredentials () throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        LOG.info("land to home page success");

        homePage.clickOnSignInButton();

        signInPage.wrongCredEmail();
        signInPage.password(password);
        signInPage.SignInButton2();
        Thread.sleep(1000);

        String errorMessage = signInPage.incorrectCred();
        Assert.assertEquals(errorMessage, "Incorrect CAPTCHA");
        LOG.info("error message shows up");

    }
    @Test  // testing captcha functions
    public void captcha () throws InterruptedException {
        HomePage homePage=new HomePage(getDriver());
        SignInPage signInPage=new SignInPage(getDriver());

        //sign in with a fake email
        homePage.clickOnSignInButton();

        signInPage.fakeEmail();
        signInPage.password(password);
        signInPage.SignInButton2();
        Thread.sleep(3000);

        String errorMessage = signInPage.incorrectCred();
        Assert.assertEquals(errorMessage, "Incorrect CAPTCHA");
        LOG.info("error message shows up");

        //correct credentials after asking for captcha
        signInPage.typeEmailAddress(emailAddress);
        signInPage.password(password);
        signInPage.captchaReload();
        signInPage.SignInButton2();

        String welcomeMessage = "Welcome, ismail leghzali! Change";
        Assert.assertEquals(welcomeMessage,"Welcome, ismail leghzali! Change");
        LOG.info("welcome user");
    }
//    @Test //sign in using excel
//    public void signInWithExcel() throws InterruptedException {
//        HomePage homePage= new HomePage(getDriver());
//        SignInPage signInPage = new SignInPage(getDriver());
//
//
//        String title = getCurrentTitle();
//        Assert.assertEquals(title,"Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing" +
//                " | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites " +
//                "Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
//        LOG.info("land to home page success");
//
//        homePage.clickOnSignInButton();
//
//        String path = System.getProperty("user.dir") + File.separator + "data" + File.separator +"magento" + File.separator + "magento.xlsx";
//        ReadFromExcel readFromExcel = new ReadFromExcel(path,"magentoFile");
//        String Email = readFromExcel.getCellValueForGivenHeaderAndKey("key","email");
//        signInPage.typeEmailAddress(Email);
//        LOG.info("success");
//        String Password = readFromExcel.getCellValueForGivenHeaderAndKey("key","password");
//        signInPage.password(Password);
//        LOG.info("success");
//
//
//    }


}