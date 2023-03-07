package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Spin_Win_Page extends BasePage {

    @FindBy(css = ".progress-container")
    @CacheLookup
    private WebElement progress_container;

    @FindBy(css = ".bet-time")
    @CacheLookup
    private WebElement bet_time;

    @FindBy(css = ".straightUp")
    @CacheLookup
    private List<WebElement> Game_number;

    @FindBy(css = ".wheelRun")
    @CacheLookup
    private WebElement wheelRun;

    @FindBy(css = ".bets-body")
    @CacheLookup
    private WebElement Current_bet;
    @FindBy(css = ".board")
    @CacheLookup
    private WebElement Bet_Board;

    @FindBy(css = ".shape")
    @CacheLookup
    private WebElement Bet_Shape;

    @FindBy(css = ".rebet.btn.disable")
    @CacheLookup
    private WebElement rebet_btn;

    @FindBy(css = ".double.btn.disable")
    @CacheLookup
    private WebElement double_btn;

    @FindBy(css = ".coins-box")
    @CacheLookup
    private WebElement coins_btn;

    @FindBy(css = ".undo.btn.disable")
    @CacheLookup
    private WebElement undo_btn;

    @FindBy(css = ".clear.btn.disable")
    @CacheLookup
    private WebElement clear_btn;

    @FindBy(css = ".current-bets")
    @CacheLookup
    private WebElement Current_Bets;

    @FindBy(css = ".statistics-wrapper")
    @CacheLookup
    private WebElement statistics_wrapper;

    @FindBy(css = ".balance-sum")
    @CacheLookup
    private WebElement Account_balance;

    @FindBy(css = ".header-items>.user")
    @CacheLookup
    private WebElement User_ID;

    @FindBy(css = ".header-items>.balance")
    @CacheLookup
    private WebElement Balance;

    @FindBy(css = ".header-items>.jackpot")
    @CacheLookup
    private WebElement jackpot;

    @FindBy(css = ".odds")
    @CacheLookup
    private WebElement odds;

    @FindBy(css = ".container .heder")
    @CacheLookup
    private WebElement odds_text;

    @FindBy(css = ".dark")
    @CacheLookup
    private WebElement dark_mode;

    @FindBy(css = ".light")
    @CacheLookup
    private WebElement light_mode;

    @FindBy(css = ".overlay")
    @CacheLookup
    private WebElement overlay;

    @FindBy(css = ".help")
    @CacheLookup
    private WebElement help;


    @FindBy(css = ".success-maessage")
    @CacheLookup
    private WebElement success_message;

    @FindBy(css = ".progress-container > span")
    @CacheLookup
    private WebElement Result_and_Bet_time;


    public Spin_Win_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);
    Random r = new Random();
    WebDriverWait Spin_Win_wait = new WebDriverWait(driver, Duration.ofSeconds(70));

    public boolean is_Spin_Win_isDisplayed() {

        Spin_Win_wait.until(ExpectedConditions.visibilityOf(progress_container));
        return progress_container.isDisplayed();
    }

    public void Choose_random_5_number() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));

        try {
            Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
            for (int l = 0; l < 5; l++) {
                int randomValue = r.nextInt(Game_number.size());
                basePage.waitAction(500);
                basePage.javaScriptClick(Game_number.get(randomValue));
            }
        } catch (Exception e) {

        }
    }

    public boolean Verify_Wheelrun_is_displayed() {
        basePage.waitAction(3000);
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(wheelRun));
        basePage.waitAction(3000);
        return wheelRun.isDisplayed();
    }

    public boolean is_Bet_Board_displayed() {
        return Bet_Board.isDisplayed();
    }

    public boolean is_Bet_Shape_displayed() {
        return Bet_Shape.isDisplayed();
    }

    public boolean is_Statistics_displayed() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return statistics_wrapper.isDisplayed();
    }

    public boolean is_bet_displayed() {
        basePage.javaScriptClick(Current_Bets);
        basePage.waitAction(3000);
        return Current_bet.isDisplayed();
    }

    public boolean REBET() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return rebet_btn.isDisplayed();
    }

    public boolean DOUBLE() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return double_btn.isDisplayed();
    }

    public boolean COINS() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return coins_btn.isDisplayed();
    }

    public boolean UNDO() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return undo_btn.isDisplayed();
    }

    public boolean CLEAR() {
        Spin_Win_wait.until(ExpectedConditions.visibilityOf(bet_time));
        return clear_btn.isDisplayed();
    }

    public String Account_balance() {
        basePage.waitElementToBeVisible(Account_balance);
        return basePage.getText(Account_balance);

    }

    public String User_ID() {
        return basePage.getText(User_ID);
    }

    public boolean Balance() {
        try {
            basePage.waitAction(2000);
            return Balance.isDisplayed();
        } catch (Exception e) {
            System.out.println("Balance is not displayed");
        }
        return false;
    }

    public boolean Jackpot() {
        return jackpot.isDisplayed();
    }

    public String odds_section() {
        basePage.javaScriptClick(odds);
        basePage.waitAction(4000);
        return basePage.getText(odds_text);
    }


    public boolean is_light_dark_modes_works() {
        basePage.javaScriptClick(dark_mode);
        basePage.waitAction(3000);
        return light_mode.isDisplayed();
    }

    public void Open_Help_section() {
        basePage.waitAction(3000);
        basePage.javaScriptClick(help);
        basePage.waitAction(3000);
    }


    public void Wait_Result_time_to_display() {

        try {
            basePage.getText(Result_and_Bet_time).equalsIgnoreCase("Result Time 0:50");
        } catch (Exception R) {
            System.out.println("Result Time is not displayed");
        }
    }


    public void Wait_Success_message_to_display() {
        basePage.waitElementToBeVisible(success_message);
        basePage.waitAction(3000);
    }

    public String Success_message_txt() {

        return basePage.getText(success_message);

    }


    public void Open_Current_Bets() {
        basePage.waitAction(3000);
        basePage.javaScriptClick(Current_Bets);
    }
}

