package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Casino_Logic extends BasePage {

    @FindBy(css = ".search-providers")
    @CacheLookup
    private WebElement ProviderSearch;

    @FindBy(xpath = "//ul[@class='provider-list default_scroll']//li")
    @CacheLookup
    private WebElement Provider_Searched_Name_Click;

    @FindBy(xpath = "//div[@class='search-providers']//input")
    @CacheLookup
    private WebElement Provider_SendKeys;

    @FindBy(css = ".game-img-wrapper")
    @CacheLookup
    private List<WebElement> ProviderGamesALL;

    @FindBy(css = ".selected-provider-label")
    @CacheLookup
    private String Provider_Name;

    @FindBy(css = ".more-button>span")
    @CacheLookup
    private WebElement See_More_btn;

    @FindBy(tagName = "img")
    @CacheLookup
    private List<WebElement> links;

    @FindBy(css = ".title")
    @CacheLookup
    private List<WebElement> Casino_Game_Names;

    public Casino_Logic() throws InterruptedException {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);
    int waitTime = 3000;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    public void Search_and_Open_Casino_Provider(String ProviderName) {
        try {
            basePage.javaScriptScrollDownToParticularElement(ProviderSearch);
            basePage.waitAction(waitTime);
            basePage.sendKeysIfElementVisible(Provider_SendKeys, ProviderName);
            basePage.javaScriptClick(Provider_Searched_Name_Click);
        } catch (Exception e) {
            System.out.println(ProviderName + "  is not active");
        }
    }

    // Open All Provider Games
    public void OpenAllGames() throws InterruptedException {

        try {
            for (int z = 0; z < 50; z++) {
                basePage.scrollToSpecificElementOnCenter(See_More_btn);
                basePage.waitAction(1000);
                while (See_More_btn.isDisplayed()) {
                    basePage.javaScriptClick(See_More_btn);
                }
            }
        } catch (Exception e) {
        }
    }

    public String GamesCount_BrokenImages() throws InterruptedException, IOException, AWTException, IOException {

        OpenAllGames();

        int brokenImagesCount = 0;
        for (int i = 0; i < links.size(); i++) {
            String linkURL = links.get(i).getAttribute("src");
            URL url = new URL(linkURL);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            http.setConnectTimeout(10000);
            http.setReadTimeout(20000);

            int statusCode = http.getResponseCode();

            if (statusCode >= 400) {
                brokenImagesCount = brokenImagesCount + 1;
                System.out.println(linkURL + " and its Status codes is: " + statusCode);
            }
        }
        String Provider_Name = driver.findElement(By.cssSelector(".selected-provider-label")).getText();
        return Provider_Name + "  Total number of games are: " + ProviderGamesALL.size() + " || " + "Total number of broken images are: " + brokenImagesCount;
    }

    int waittime = 4000;

    public void CasinoLogic() throws InterruptedException, IOException, AWTException {

        OpenAllGames();


        for (int l = 0; l < ProviderGamesALL.size(); l++) {

            try {
                basePage.waitAction(waitTime);
                basePage.scrollPageDown();
                basePage.waitAction(waitTime);
                WebElement more_btn = driver.findElement(By.cssSelector(".more-button>span"));
                basePage.javaScriptClick(more_btn);
                if (!more_btn.isDisplayed()) {
                    break;
                }
                basePage.waitAction(waitTime);

            } catch (Exception or) {
            }


            String Provider_Name = driver.findElement(By.cssSelector(".selected-provider-label")).getText();
            List<WebElement> ProviderGames = driver.findElements(By.cssSelector(".game-img-wrapper"));
            basePage.scrollToSpecificElementOnCenter(ProviderGames.get(l));
            basePage.waitAction(waitTime);
            basePage.actionMoveToElement(ProviderGames.get(l));
            basePage.waitAction(waitTime);
            String EachGameName = driver.findElements(By.cssSelector(".show-hovered-game-names>.title")).get(l).getText();
            List<WebElement> Game_btn_real = driver.findElements(By.cssSelector(".game-btn_real"));
            Game_btn_real.get(l).click();
            basePage.waitAction(10000);


            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("C:\\Users\\Hayk Hambardzumyan\\Desktop\\CRAFTBET_CASINO\\" + Provider_Name + "\\" + EachGameName + ".jpg"));
            } catch (IllegalArgumentException | SecurityException e) {

                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("C:\\Users\\Hayk Hambardzumyan\\Desktop\\CRAFTBET_CASINO\\" + Provider_Name + "\\" + l + ".jpg"));
            } catch (Exception tyu) {
                System.out.println("Unable to save image");
            }

            try {
                driver.navigate().back();

            } catch (Exception o) {
                System.out.println("Unable to navigate back");

            }
        }
    }


    public void Provider_Games_List() throws InterruptedException {
        OpenAllGames();
        for (WebElement casino_game_name : Casino_Game_Names) {
            System.out.println(casino_game_name.getText());
        }
    }
}