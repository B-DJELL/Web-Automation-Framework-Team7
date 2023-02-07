package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveCommentNewsPage extends CommonAPI {

    public LeaveCommentNewsPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    Logger log = LogManager.getLogger(LeaveCommentNewsPage.class.getName());

    @FindBy(xpath = "//a[normalize-space()='News']")
    WebElement NewsButton;
    @FindBy(xpath = "//a[normalize-space()='nopCommerce new release!']")
    WebElement NopNewReleaseLink;
    @FindBy(css = "#AddNewComment_CommentTitle")
    WebElement TitleField;
    @FindBy(css = " #AddNewComment_CommentText")
    WebElement CommentField;
    @FindBy(css = " button[name='add-comment']")
    WebElement NewCommentButton;
    @FindBy(xpath = "//div[@class='result']")
    WebElement CommentResult;



    public void cLickOnNewsButton(){
        clickOn(NewsButton);
        log.info("Click on News Button Success");
    }
    public void cLickOnNewReleaseLink(){
        clickOn(NopNewReleaseLink);
        log.info("Click on New release link  Success");
    }
    public void typeCommentTitle(){
        type(TitleField,"Demo website Needs Improvement");
        log.info("Title Typed Successfully");
    }
    public void typeComment(){
        type(CommentField,"Demo website Needs Improvement, each time the user need to register and login ");
        log.info("Title Typed Successfully");
    }
    public void cLickOnNewCommentButton(){
        clickOn(NewCommentButton);
        log.info("Click on New comment  Button Success");
    }


    public String CommentAdded(){return getTextFromElement(CommentResult);}


}
