package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Pages extends BasePage {

    @FindBy(css = ".button-style2-type-btn")
    @CacheLookup
    private WebElement SignIN;

    @FindBy(css = "[name='username']")
    @CacheLookup
    private WebElement Email_field_1;

    @FindBy(css = ".recovery_input")
    @CacheLookup
    private WebElement Psw_Email_field_2;

    @FindBy(xpath = "//input[@formcontrolname='Password']")
    @CacheLookup
    private WebElement Password;

    @FindBy(css = ".login_btn")
    @CacheLookup
    private WebElement signin;

    @FindBy(css = ".dropdown-style1-type-Dpd")
    @CacheLookup
    public WebElement Language_dropdown;

    @FindBy(xpath = "//span[normalize-space()='English']")
    @CacheLookup
    public WebElement Eng_Language;

    @FindBy(xpath = "//a[normalize-space()='Casino']")
    @CacheLookup
    private WebElement Casino;

    @FindBy(css = ".error_message")
    @CacheLookup
    private WebElement Invalid_Error_Message;

    @FindBy(css = ".user_id")
    @CacheLookup
    private WebElement User_id;

    @FindBy(css = ".forgot_password")
    @CacheLookup
    private WebElement Password_recovery;

    @FindBy(css = ".forgot-error_message")
    @CacheLookup
    private WebElement Wrong_recovery_input;

    @FindBy(css = ".recovery-btn")
    @CacheLookup
    private WebElement Recovery_Link_btn;

    @FindBy(partialLinkText = "Sports")
    @CacheLookup
    private WebElement SPORT;

    @FindBy(id = "main-game-iframe")
    @CacheLookup
    private WebElement Main_Iframe;

    @FindBy(partialLinkText = "Virtual Sport")
    @CacheLookup
    private WebElement Virtual_Sport;

    @FindBy(partialLinkText = "Virtual Games")
    @CacheLookup
    private WebElement Virtual_Games;

    @FindBy(xpath = "//div[text()=' Keno ']")
    @CacheLookup
    private WebElement Keno;

    @FindBy(xpath = "//div[text()=' Minesweeper ']")
    @CacheLookup
    private WebElement Minesweeper;

    @FindBy(xpath = "//div[text()=' High Low ']")
    @CacheLookup
    private WebElement High_Low;

    @FindBy(xpath = "//div[text()=' Spin & Win ']")
    @CacheLookup
    private WebElement Spin_Win;

    @FindBy(xpath = "//div[text()=' Crash ']")
    @CacheLookup
    private WebElement Crash;

    @FindBy(partialLinkText = "Real")
    @CacheLookup
    private WebElement Real_btn;

    @FindBy(partialLinkText = "Live Casino")
    @CacheLookup
    private WebElement LiveCasino;

    @FindBy(css = ".TEST_HeaderPanel2Menu_MoreMenu")
    @CacheLookup
    private WebElement Header_More;


    @FindBy(css = ".form_field")
    @CacheLookup
    private WebElement Psw_recovery_form_field;


    public Login_Pages() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);


    String username = "h.hambardzumyan@iqsoft.am";
    String password = "Test12345";


    public void LoginSystem() throws InterruptedException {
        basePage.clickOnElementIfVisible(SignIN);
        basePage.sendKeysIfElementVisible(Email_field_1, username);
        basePage.sendKeysIfElementVisible(Password, password);
        basePage.clickOnElementIfClickable(signin);
        basePage.waitElementToBeVisible(User_id);
        basePage.waitAction(3000);

    }

    public WebElement Password_recovery_verify() {
        return Psw_recovery_form_field;
    }


    public void Choose_Eng_Language() {

        //For Login Main_Test.Main_Test.Test
        basePage.waitElementTobeClickable(Language_dropdown);
        basePage.javaScriptClick(Language_dropdown);
        basePage.javaScriptClick(Eng_Language);
    }

    public void Virtual_Sport() throws InterruptedException {
        Thread.sleep(3000);
        basePage.waitElementTobeClickable(Virtual_Sport);
        basePage.javaScriptClick(Virtual_Sport);
    }

    public void Casino() throws InterruptedException {

        Thread.sleep(3000);
        basePage.waitElementTobeClickable(Casino);
        basePage.javaScriptClick(Casino);
    }

    public void Hover_Live_Casino() throws InterruptedException {
        basePage.waitAction(4000);
        basePage.waitElementToBeVisible(LiveCasino);
        basePage.actionMoveToElement(LiveCasino);
        basePage.waitAction(3000);
    }


    public void Sport() throws InterruptedException {
        basePage.waitElementToBeVisible(SPORT);
        basePage.clickOnElementIfClickable(SPORT);
        basePage.waitFrameToBeAvailable(Main_Iframe);
    }


    public void Choose_ENG_Click_SignIn() {
        basePage.waitElementTobeClickable(Language_dropdown);
        basePage.javaScriptClick(Language_dropdown);
        basePage.javaScriptClick(Eng_Language);
        basePage.clickOnElementIfClickable(SignIN);
    }

    public void Keno() {
//        try {
//            basePage.waitAction(3000);
//            if (Header_More.isDisplayed()) {
//                basePage.actionMoveToElement(Header_More);
//                basePage.waitAction(3000);
//            }
//        } catch (Exception or) {
//            System.out.println("More btn is not displayed");
//        }

        basePage.javaScriptClick(Virtual_Games);
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(Keno);
        basePage.waitAction(2000);
        basePage.actionMoveToElement(Keno);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Real_btn);
        basePage.waitFrameToBeAvailable(Main_Iframe);
    }

    public void High_Low() {

//        try {
//            basePage.waitAction(3000);
//            if (Header_More.isDisplayed()) {
//                basePage.actionMoveToElement(Header_More);
//            }
//        } catch (Exception or) {
//            System.out.println("More btn is not displayed");
//        }

        basePage.javaScriptClick(Virtual_Games);
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(High_Low);
        basePage.waitAction(2000);
        basePage.actionMoveToElement(High_Low);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Real_btn);
        basePage.waitFrameToBeAvailable(Main_Iframe);
    }

    public void Spin_Win() {

//        try {
//            basePage.waitAction(3000);
//            if (Header_More.isDisplayed()) {
//                basePage.actionMoveToElement(Header_More);
//            }
//        } catch (Exception or) {
//            System.out.println("More btn is not displayed");
//        }

        basePage.javaScriptClick(Virtual_Games);
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(Spin_Win);
        basePage.waitAction(2000);
        basePage.actionMoveToElement(Spin_Win);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Real_btn);
        basePage.waitFrameToBeAvailable(Main_Iframe);
    }


    public void Minesweeper() throws InterruptedException {

//        try {
//            basePage.waitAction(3000);
//            if (Header_More.isDisplayed()) {
//                basePage.actionMoveToElement(Header_More);
//            }
//        } catch (Exception or) {
//            System.out.println("More btn is not displayed");
//        }

        basePage.javaScriptClick(Virtual_Games);
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(Minesweeper);
        basePage.waitAction(2000);
        basePage.actionMoveToElement(Minesweeper);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Real_btn);
        basePage.waitFrameToBeAvailable(Main_Iframe);

    }

    public void Crash() {

//        try {
//            basePage.waitAction(3000);
//            if (Header_More.isDisplayed()) {
//                basePage.actionMoveToElement(Header_More);
//            }
//        } catch (Exception or) {
//            System.out.println("More btn is not displayed");
//        }

        basePage.javaScriptClick(Virtual_Games);
        basePage.waitAction(2000);
        basePage.scrollToSpecificElementOnCenter(Crash);
        basePage.waitAction(2000);
        basePage.actionMoveToElement(Crash);
        basePage.waitAction(2000);
        basePage.javaScriptClick(Real_btn);
        basePage.waitFrameToBeAvailable(Main_Iframe);

    }

    public void typeUsername(String username) {
        try {
            basePage.sendKeysIfElementVisible(Email_field_1, username);
        } catch (Exception e) {
            basePage.sendKeysIfElementVisible(Psw_Email_field_2, username);
        }
    }

    public void typePassword(String password) {
        basePage.sendKeysIfElementVisible(Password, password);
    }

    public void clickSignIn() {

        basePage.clickOnElementIfClickable(signin);
    }


    public String invalid_Login_Password_error_message() {
        return basePage.getText(Invalid_Error_Message);
    }



    public boolean Verify_UserID_is_Displayed() {
        basePage.waitElementToBeVisible(User_id);
        return User_id.isDisplayed();
    }


    public void Open_Recovery_Page() {
        basePage.javaScriptClick(Password_recovery);
    }

    public String Wrong_recovery_input_text() {
        return basePage.getText(Wrong_recovery_input);
    }

    public void Send_Me_Recovery_Link_btn() {
        basePage.javaScriptClick(Recovery_Link_btn);
    }

}
