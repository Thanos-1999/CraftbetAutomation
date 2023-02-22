package PageObjects;

import org.openqa.selenium. WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VirtualSport_Page extends BasePage {

    @FindBy(css = ".grouped-products-content_item")
    @CacheLookup
    private WebElement Virtual_Sports_Kiron;

    @FindBy(id = "LobbyDisplay-1")
    @CacheLookup
    private WebElement Main_Lobby;

    @FindBy(css = ".game-btn")
    @CacheLookup
    private WebElement Game_btn;

    @FindBy(id = "lobby-2")
    @CacheLookup
    private WebElement SPORT;

    @FindBy(id = "lobby-3")
    @CacheLookup
    private WebElement GAMES;


    public VirtualSport_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);

    public boolean is_VirtualSport_Section_Displayed() throws InterruptedException {
        basePage.actionMoveToElement(Virtual_Sports_Kiron);
        basePage.javaScriptClick(Game_btn);
        driver.switchTo().frame(0);
        basePage.waitElementToBeVisible(Main_Lobby);
        return Main_Lobby.isDisplayed();
    }


    public boolean is_Sport_present() {
        return SPORT.isDisplayed();
    }

    public boolean is_Games_present() {
        return GAMES.isDisplayed();
    }


}



