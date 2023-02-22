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

public class Keno_Page extends BasePage {

    @FindBy(css = ".wrapper-content")
    @CacheLookup
    private WebElement Keno_Game_Wrapper;

    @FindBy(css = ".main-selections-board>li")
    @CacheLookup
    private List<WebElement> Keno_Balls;

    @FindBy(css = ".main-selections-board")
    @CacheLookup
    private WebElement main_selections_board;

    @FindBy(css = ".bet-error")
    @CacheLookup
    private WebElement Bet_error_message;

    @FindBy(css = ".bet-success")
    @CacheLookup
    private WebElement Bet_success_message;

    @FindBy(css = ".bet-amount>input")
    @CacheLookup
    private WebElement Amount_Field;

    @FindBy(css = ".history-container .tabs li:nth-of-type(3)")
    @CacheLookup
    private WebElement Bets_History_btn;

    @FindBy(css = ".history-container .tabs li:nth-of-type(3)")
    @CacheLookup
    private WebElement Bets_History;

    @FindBy(css = ".actions-board > .btn")
    @CacheLookup
    private WebElement Bet_btn;

    @FindBy(css = ".tabs > div:nth-of-type(3)")
    @CacheLookup
    private WebElement ExtraMarkets_btn;

    @FindBy(css = ".extra-selections-board>li>.market-name")
    @CacheLookup
    public List<WebElement> ExtraMarkets_all_markets;

    @FindBy(css = ".drop-down li span:nth-of-type(2)")
    @CacheLookup
    public List<WebElement> Rounds;

    @FindBy(css = ".inner-div")
    @CacheLookup
    private WebElement Rounds_btn;

    @FindBy(css = ".timer > .round-id")
    @CacheLookup
    private WebElement Rounds_sum;

    @FindBy(css = ".jackpot-sum")
    @CacheLookup
    private WebElement jackpot_sum;

    @FindBy(css = ".round > .round-id")
    @CacheLookup
    private WebElement Round_id_sum;

    @FindBy(css = ".user-id")
    @CacheLookup
    private WebElement User_Id_sum;

    @FindBy(css = ".balance-sum")
    @CacheLookup
    private WebElement Balance_Sum;

    @FindBy(css = ".win-stat-header ul li:nth-of-type(1)")
    @CacheLookup
    private WebElement Winnings;

    @FindBy(css = ".win-stat-header ul li:nth-of-type(2)")
    @CacheLookup
    private WebElement Statistics;

    @FindBy(css = ".win-stat-content")
    @CacheLookup
    private WebElement win_content;

    @FindBy(css = ".winnings-info>.row")
    @CacheLookup
    private WebElement Winnings_info;

    @FindBy(css = ".winnings-info>.row")
    @CacheLookup
    private WebElement Current_Bets_Tab;

    @FindBy(css = ".history-container .tabs li:nth-of-type(2)")
    @CacheLookup
    private WebElement Last_20_Draws_Tab;

    @FindBy(css = ".winnings-info>.row")
    @CacheLookup
    private WebElement My_Bets_History_Tab;

    @FindBy(css = "div:nth-of-type(1) > .draw-nums")
    @CacheLookup
    private WebElement draw_nums;

    @FindBy(css = ".balance-sum")
    @CacheLookup
    private WebElement Account_balance;

    @FindBy(css = ".animation")
    @CacheLookup
    private WebElement Game_animation;

    @FindBy(css = ".png.show")
    @CacheLookup
    private WebElement game_balls_animation;

    @FindBy(css = ".current-bet-item")
    @CacheLookup
    private WebElement current_bet_items;

    public Keno_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);
    WebDriverWait KenoWait = new WebDriverWait(driver, Duration.ofSeconds(90));

    Random r = new Random();

    public boolean Verify_Keno_is_Displayed() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        return Keno_Game_Wrapper.isDisplayed();
    }

    public int Balls_Count() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        return Keno_Balls.size();
    }


    public void Choose_10_more_Numbers() {
        try {
            KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
            for (int l = 0; l < 12; l++) {
                basePage.javaScriptClick(Keno_Balls.get(l));
            }
        } catch (Exception e) {
            System.out.println("Random 10+ Balls selected");
        }
    }


    public void Choose_5_Numbers() {
        try {
            KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
            for (int l = 0; l < 5; l++) {
                int randomValue = r.nextInt(Keno_Balls.size());
                basePage.waitAction(500);
                basePage.javaScriptClick(Keno_Balls.get(randomValue));
            }
        } catch (Exception e) {

        }
    }

    public String error_msg() {
        basePage.waitElementToBeVisible(Bet_error_message);
        return basePage.getText(Bet_error_message);
    }

    public String success_msg() {
        basePage.waitElementToBeVisible(Bet_success_message);
        return basePage.getText(Bet_success_message);
    }

    public void Type_Amount(String Amount) {

        basePage.waitAction(2000);
        basePage.sendKeysIfElementVisible(Amount_Field, Amount);
    }

    public void Click_Bet_btn() {
        basePage.javaScriptClick(Bet_btn);
    }

    public void ExtraMarkets_Section() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(ExtraMarkets_btn);
    }

    public void Open_Rounds() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(Rounds_btn);
    }

    public boolean is_Current_Bets_section_displayed() {
        return current_bet_items.isDisplayed();
    }

    public boolean Keno_Time() {
        return Rounds_sum.isDisplayed();
    }

    public boolean Keno_jackpot() {
        return jackpot_sum.isDisplayed();
    }

    public boolean Keno_round() {
        return Round_id_sum.isDisplayed();
    }

    public boolean Keno_UserID() {
        return User_Id_sum.isDisplayed();
    }

    public boolean Keno_Balance() {
        return Balance_Sum.isDisplayed();
    }

    public boolean Winnings_section() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(Winnings);
        return Winnings_info.isDisplayed();

    }

    public boolean Statistics_section() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(Statistics);
        return win_content.isDisplayed();

    }


    public void Current_Bets_Section() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(Current_Bets_Tab);
    }


    public boolean Last_20_Draws() {
        KenoWait.until(ExpectedConditions.visibilityOf(main_selections_board));
        basePage.javaScriptClick(Last_20_Draws_Tab);
        return Last_20_Draws_Tab.isDisplayed() && Last_20_Draws_Tab.isEnabled();

    }

    public void Game_animation_is_visible() throws InterruptedException {

        KenoWait.until(ExpectedConditions.visibilityOf(game_balls_animation));
        basePage.waitAction(4000);
    }


    public void Keno_Game() {
        KenoWait.until(ExpectedConditions.visibilityOf(Game_animation));
    }

    public String Account_balance() {
        basePage.waitElementToBeVisible(Account_balance);
        return basePage.getText(Account_balance);

    }
}



