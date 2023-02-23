package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class Casino_Page extends BasePage {
    @FindBy(css = ".flex_between.search_field > .search-icon")
    @CacheLookup
    private WebElement Searchicon;

    @FindBy(css = ".ng-pristine")
    @CacheLookup
    private WebElement SearchSendkeysfield;

    @FindBy(css = ".has-game-name .title")
    @CacheLookup
    private WebElement Casino_Game_Text;

    @FindBy(css = ".icon-star-info2")
    @CacheLookup
    private WebElement Casino_Game_Star;

    @FindBy(partialLinkText = "Favorites")
    @CacheLookup
    private WebElement Top_button;

    @FindBy(css = ".game-img-wrapper")
    @CacheLookup
    private WebElement hovered_game;

    @FindBy(partialLinkText = "Real")
    @CacheLookup
    private WebElement Real_button;

    public Casino_Page() throws AWTException {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);

    public void Search_Work(String txt) throws InterruptedException {

        basePage.waitAction(4000);

        try {
            basePage.clickOnElementIfVisible(SearchSendkeysfield);
            basePage.sendKeysIfElementVisible(SearchSendkeysfield, txt);
            basePage.javaScriptClick(Searchicon);
        } catch (Exception e) {
            System.out.println("Casino Search is not working");
        }
        basePage.waitAction(4000);

    }

    public String Casino_Searched_text() {
        basePage.waitAction(3000);
        return basePage.getText(Casino_Game_Text);
    }

    public void Click_Game_Star() {
        try {
            basePage.waitAction(3000);
            basePage.javaScriptClick(Casino_Game_Star);
        } catch (Exception E) {
            System.out.println("Unable to click Game star");
        }
    }


    public void Click_Top_btn() {
        try {
            basePage.javaScriptClick(Top_button);
            basePage.waitAction(4000);
        } catch (Exception E) {
            System.out.println("Unable to click Top button");
        }
    }

    public void Hover_Casino_Game_click_Play() {
        basePage.waitAction(5000);
        basePage.actionMoveToElement(hovered_game);
        basePage.waitAction(5000);
        basePage.javaScriptClick(Real_button);
        basePage.waitAction(10000);
    }
}









