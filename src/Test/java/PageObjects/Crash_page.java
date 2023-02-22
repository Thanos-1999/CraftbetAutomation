package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Crash_page extends BasePage {

    @FindBy(css = ".wrapper-content")
    private WebElement wrapper_content;

    @FindBy(css = ".chartjs-render-monitor")
    private WebElement Crash_monitor;

    @FindBy(css = ".earth.active")
    private WebElement Earth_visibile;

    @FindBy(css = ".current-bet>input")
    private WebElement Bet_input;

    @FindBy(css = ".play-now-button")
    private WebElement Place_bet_btn;

    @FindBy(css = ".hash-codes-button")
    private WebElement hash_codes_btn;

    @FindBy(css = ".hash-codes-table")
    private WebElement hash_codes_table;

    @FindBy(css = ".bet-msg")
    private WebElement Bet_message;

    @FindBy(xpath = "//button[text()='CashOut']")
    private WebElement Cashout_btn;

    @FindBy(css = ".coef.active")
    private WebElement Coef;

    @FindBy(css = ".my-bets-button")
    private WebElement My_bets_btn;

    @FindBy(css = ".my-bets-table")
    private WebElement My_bets_Table;

    @FindBy(css = ".switch-btn")
    private WebElement Auto_Cashout_switch;

    @FindBy(css = ".crashColor")
    private WebElement CrashColor_text;

    @FindBy(css = ".deactivate.play-now-button > span:nth-of-type(2)")
    private WebElement Cashed_out_txt;

    @FindBy(css = ".current-bet.active>input")
    private WebElement Auto_Cashout_sendkeys;

    @FindBy(css = ".balance-sum")
    @CacheLookup
    private WebElement Account_balance;


    public Crash_page() {

        PageFactory.initElements(BasePage.driver, this);
    }

    WebDriverWait Crashwait = new WebDriverWait(driver, Duration.ofSeconds(60));

    BasePage basePage = new BasePage(driver);

    public boolean Verify_Crash_is_Displayed() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(wrapper_content));
        return wrapper_content.isDisplayed();
    }


    public boolean Last_Result_Top_Crashes() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        return Crash_monitor.isDisplayed();
    }


    public void Crash_Bet(String betamount) throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        basePage.sendKeysIfElementVisible(Bet_input, betamount);
        basePage.waitAction(3000);
        basePage.javaScriptClick(Place_bet_btn);
    }

    public boolean Hash_Codes() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        basePage.javaScriptClick(hash_codes_btn);
        return hash_codes_table.isDisplayed();
    }

    public String Bet_message() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        return basePage.getText(Bet_message);
    }

    public boolean is_Cashout_Displayed() {
        return Cashout_btn.isDisplayed();
    }


    public void click_Cashout() {
        basePage.javaScriptClick(Cashout_btn);
    }

    public void Coef_to_be_visible() {
        basePage.waitElementToBeVisible(Coef);
    }


    public String Cashout_text() {
        return basePage.getText(Cashout_btn);
    }

    public String Coef_text() {
        return basePage.getText(Coef);
    }


    public String Cashout_functional() {
        basePage.javaScriptClick(Cashout_btn);
        return basePage.getText(Bet_message);
    }

    public boolean My_Bets() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        basePage.javaScriptClick(My_bets_btn);
        basePage.waitAction(2000);
        return My_bets_Table.isDisplayed();
    }

    public void Auto_Cashout() throws InterruptedException {
        Crashwait.until(ExpectedConditions.visibilityOf(Earth_visibile));
        basePage.waitAction(2000);
        basePage.clickOnElementIfClickable(Auto_Cashout_switch);
    }

    public void Auto_Cashout_Sendkeys() {
        basePage.waitAction(2000);
        basePage.sendKeysIfElementVisible(Auto_Cashout_sendkeys, "1.09");
    }

    public String CashedOut_txt() {
        return basePage.getText(Cashed_out_txt);
    }

    public String Account_balance() {

        basePage.waitElementToBeVisible(Account_balance);
        return basePage.getText(Account_balance);

    }

}
