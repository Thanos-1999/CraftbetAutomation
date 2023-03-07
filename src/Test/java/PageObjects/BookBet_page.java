package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BookBet_page extends BasePage {

    @FindBy(css = ".market-types-box>.match-selections>.selection-coefficient")
    @CacheLookup
    private List<WebElement> Cofficients;


    @FindBy(xpath = "//ul[@class='provider-list default_scroll']//li")
    @CacheLookup
    private WebElement Provider_Searched_Name_Click;


    @FindBy(xpath = "//div[@class='search-providers']//input")
    @CacheLookup
    private WebElement Provider_SendKeys;

    @FindBy(css = ".book-bet-button")
    @CacheLookup
    private WebElement book_bet_button;

    @FindBy(id = "print-section")
    @CacheLookup
    private WebElement Book_Bet_content;

    @FindBy(css = ".booking-code")
    @CacheLookup
    private WebElement booking_code;

    @FindBy(css = ".date")
    @CacheLookup
    private WebElement date;


    @FindBy(css = ".content-table>.ng-star-inserted")
    @CacheLookup
    private List<WebElement> matches_size;

    public BookBet_page() {
        PageFactory.initElements(BasePage.driver, this);
    }
    BasePage basePage = new BasePage(driver);
    int waitTime = 3000;

    public void Make_random_bet() throws InterruptedException {
        try {
            for (int r = 0; r < 1; r++) {
                int maxProducts = Cofficients.size();
                Random random = new Random();
                int randomProduct = random.nextInt(maxProducts);
                basePage.javaScriptClick(Cofficients.get(randomProduct));
            }
        } catch (Exception E) {
            System.out.println("Unable to make express bet");
        }
    }

    public boolean BookBet_btn_is_displayed() {
        basePage.scrollToSpecificElementOnCenter(book_bet_button);
        basePage.waitAction(3000);
        return book_bet_button.isDisplayed();
    }

    public boolean Open_BookBet_Tab() {
        basePage.javaScriptClick(book_bet_button);
        basePage.waitAction(2000);
        return Book_Bet_content.isDisplayed();
    }



    public boolean is_booking_code_displayed() {
        return booking_code.isDisplayed();
    }


    public boolean is_date_displayed() {
        return date.isDisplayed();
    }

}