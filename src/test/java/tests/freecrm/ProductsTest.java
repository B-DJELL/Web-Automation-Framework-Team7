package tests.freecrm;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freecrm.*;
import utility.ReadFromExcel;

import java.io.File;

public class ProductsTest extends CommonAPI {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    NewProductPage newProductPage;

    String expectedCreateContactPageTitle="Cogmento CRM";


    //Read from Excel sheet
    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "Yaser");

    String email = read.getDataFromCell(1, 1);
    String password = read.getDataFromCell(2, 1);

    @Test(enabled = false)
    public void NewProductTest() throws InterruptedException {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage=new ProductsPage(driver);
        newProductPage=new NewProductPage(driver);


        String RandomName=newProductPage.randomeString();

        //        mainPage.clickOnLogin();
        loginPage.logIn(email,password);
        homePage.clickOnSettingsIcon();
        homePage.clickOnProductsButton();
        productsPage.clickOnNewProductButton();
//        driver.navigate().refresh();
//        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        newProductPage.CreateNewProduct(RandomName);

        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedCreateContactPageTitle, "Error");
    }
}
