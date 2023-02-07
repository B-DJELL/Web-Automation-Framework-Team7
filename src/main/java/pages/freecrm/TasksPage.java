package pages.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends CommonAPI {
    public TasksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(MainPage.class.getName());

}
