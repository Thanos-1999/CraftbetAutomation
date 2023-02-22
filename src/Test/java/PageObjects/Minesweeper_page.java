package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static PageObjects.BasePage.driver;

public class Minesweeper_page {

    @FindBy(css = ".minesweeper_tab")
    @CacheLookup
    private WebElement minesweeper_tab;

    @FindBy(xpath = "//button[text()='Custom']")
    @CacheLookup
    private WebElement Custom_btn;

    @FindBy(css = ".options_buttons button:nth-of-type(1)")
    @CacheLookup
    private WebElement Default_btn;

    @FindBy(css = ".checkmark")
    @CacheLookup
    private WebElement checkmark;

    @FindBy(css = ".columns_count_number>input")
    @CacheLookup
    private WebElement columns;

    @FindBy(css = ".rows_count_number>input")
    @CacheLookup
    private WebElement Rows;

    @FindBy(css = ".mines_count_number>input")
    @CacheLookup
    private WebElement Mines;

    @FindBy(css = ".web-date")
    @CacheLookup
    private WebElement web_date;

    @FindBy(css = ".icon-calendar_icon")
    @CacheLookup
    private WebElement icon_calendar_icon;

    @FindBy(css = ".history")
    @CacheLookup
    private WebElement history;

    @FindBy(css = ".btn_ticket_history")
    @CacheLookup
    private WebElement ticket_history;

    @FindBy(css = ".bordered_popup.win_popup > p:nth-of-type(2)")
    @CacheLookup
    private WebElement Win_popup_text;

    @FindBy(css = ".bordered_popup.lost_popup > p:nth-of-type(2)")
    @CacheLookup
    private WebElement Lost_popup_text;

    @FindBy(css = ".balance-sum")
    @CacheLookup
    private WebElement Account_balance;

    @FindAll({
            @FindBy(css = ".balance_count_number>input"),
            @FindBy(css = ".ticket_price_number>input")
    })
    private WebElement TicketPrice;

    @FindBy(css = ".btn_play")
    @CacheLookup
    private WebElement Play_btn;

    @FindBy(css = ".unit_default>.default.active")
    @CacheLookup
    private List<WebElement> Game_Columns;

    @FindBy(xpath = "//button[text()='Top Results']")
    @CacheLookup
    private WebElement Top_Results_section;

    @FindBy(css = ".top_results")
    @CacheLookup
    private WebElement Top_Results;

    @FindBy(css = ".win")
    @CacheLookup
    private WebElement Top_Results_win;

    @FindBy(css = ".btn_cash_out")
    @CacheLookup
    private WebElement Cashout_btn;

    @FindBy(css = ".icon-help-icon1")
    @CacheLookup
    private WebElement Minesweeper_Help;

    public Minesweeper_page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);

    WebDriverWait Minesweeper_wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public boolean Verify_Minesweeper_is_Displayed() {
        Minesweeper_wait.until(ExpectedConditions.visibilityOf(minesweeper_tab));
        return minesweeper_tab.isDisplayed();
    }

    public void Custom_section() throws InterruptedException {
        basePage.waitAction(4000);
        basePage.javaScriptClick(Custom_btn);
    }

    public void Default_section() throws InterruptedException {
        basePage.waitAction(4000);
        basePage.javaScriptClick(Default_btn);
    }


    public void checkmark() throws InterruptedException {
        basePage.javaScriptClick(checkmark);
    }

    public void columns(int num) throws InterruptedException {
        basePage.sendKeysIfElementVisible(columns, String.valueOf(num));
    }

    public void Rows(int num) throws InterruptedException {
        basePage.sendKeysIfElementVisible(Rows, String.valueOf(num));
    }

    public void Mines(int num) throws InterruptedException {
        basePage.sendKeysIfElementVisible(Mines, String.valueOf(num));
    }

    public void TicketPrice(String num) throws InterruptedException {
        Thread.sleep(6000);
        basePage.javaScriptClick(TicketPrice);
        basePage.sendKeysIfElementVisible(TicketPrice, String.valueOf(num));
    }

    public void Play_btn() throws InterruptedException {
        basePage.javaScriptClick(Play_btn);
    }

    public void Ticket_history() throws InterruptedException {
        basePage.javaScriptClick(ticket_history);
    }


    public boolean web_date() throws InterruptedException {
        return web_date.isDisplayed();
    }

    public boolean calendar_icon() throws InterruptedException {
        return icon_calendar_icon.isDisplayed();
    }

    public boolean history() throws InterruptedException {
        return history.isDisplayed();
    }


    public void Random_column_click() throws InterruptedException {
        Random r = new Random();

        try {
            for (int k = 0; k < 12; k++) {
                int randomValue = r.nextInt(Game_Columns.size());
                Thread.sleep(2000);
                basePage.clickOnElementIfClickable(Game_Columns.get(randomValue));
            }
        } catch (Exception rj) {
            System.out.println("Unable to click");
        }
    }


    public String Win_popup() throws InterruptedException {
        return basePage.getText(Win_popup_text);
    }


    public String Lost_popup() throws InterruptedException {
        return basePage.getText(Lost_popup_text);
    }

    public String Account_balance() {
        basePage.waitElementToBeVisible(Account_balance);
        return basePage.getText(Account_balance);
    }

    public boolean Top_Result_section() {
        basePage.waitElementToBeVisible(Account_balance);
        basePage.javaScriptClick(Top_Results_section);
        return Top_Results.isDisplayed();
    }

    public void Game_Help() {
        basePage.waitElementToBeVisible(Account_balance);
        basePage.javaScriptClick(Minesweeper_Help);
    }

    public boolean is_Cashout_btn_displayed() {
        try {
            boolean btnPresence = Cashout_btn.isDisplayed();
            if (btnPresence == true) {
                basePage.javaScriptClick(Cashout_btn);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
        return false;
    }
}