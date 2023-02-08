package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.io.*;
import java.util.Properties;

public class CreateNewDealTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;
    CreateNewDealPage createNewDealPage;

    String expectedCreateDealPageTitle="Cogmento CRM";
    String ErrorMessage = "Something went wrong,Create a deal from the contacts page after clicking on contacts failed";
    String ErrorMessage2= "Create a Deal from Main Menu (after hovering over the menu logo) failed";
//    //Read from Excel sheet
//    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
//    ReadFromExcel read = new ReadFromExcel(path, "Yaser");
//    String email = read.getDataFromCell(1, 1);
//    String password = read.getDataFromCell(2, 1);

    //Read from Data Base:
    Properties prop = new Properties();
    InputStream ism;
    {
        try {
            ism = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Create a deal from the deals page after clicking on deals button:
    @Test
    public void addDealFromDealsPage() {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        dealsPage=new DealsPage(driver);
        createNewDealPage=new CreateNewDealPage(driver);
        try {
            prop.load(ism);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String email = ConnectDB.getTableColumnData("select * from cred","v").get(0);
        String password = ConnectDB.getTableColumnData("select * from cred","v").get(1);

        String title=createNewDealPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.clickOnDealsLink(driver);
        dealsPage.clickOnCreateDealButton();
        driver.navigate().refresh();
        driver.navigate().refresh();
        createNewDealPage.createNewDeal(title);
        createNewDealPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateDealPageTitle, ErrorMessage);
    }

    //Create a Deal from Main Menu (after hovering over the menu logo) :
    @Test
    public void addDealFromMenu() {
        mainPage=new MainPage(driver);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        dealsPage=new DealsPage(driver);
        createNewDealPage=new CreateNewDealPage(driver);

        try {
            prop.load(ism);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String email = ConnectDB.getTableColumnData("select * from cred","v").get(0);
        String password = ConnectDB.getTableColumnData("select * from cred","v").get(1);

        String title=createNewDealPage.randomeString();

//        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.addDealAfterHover(driver);
        driver.navigate().refresh();
        driver.navigate().refresh();
        createNewDealPage.createNewDeal(title);
        createNewDealPage.clickOnSaveBtn();

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateDealPageTitle, ErrorMessage2);
    }

}
