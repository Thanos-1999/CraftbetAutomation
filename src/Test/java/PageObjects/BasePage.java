package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;


public class BasePage {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    Select select;
    JavascriptExecutor js;
    public int i = 1;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        js = (JavascriptExecutor) driver;
    }

    public BasePage() {
    }

    /* this method will be return BasePage_s driver */
    public static WebDriver getDriver() {
        return driver;
    }

    /* this method will be used for validate webElements visibility */
    public void waitElementToBeVisible(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitFrameToBeAvailable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /* this method will be used for validate webElements click ability */
    public void waitElementTobeClickable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* this method will be used for clicking on element which is visible */
    public void clickOnElementIfVisible(WebElement element) {
        this.waitElementToBeVisible(element);
        element.click();
    }

    /* this method will be used for clicking on element which is Clickable */
    public void clickOnElementIfClickable(WebElement element) {
        this.waitElementTobeClickable(element);
        element.click();
    }

    /* this method will be used for sending keys on element which is visible */
    public void sendKeysIfElementVisible(WebElement element, String keys) {
        this.waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    /* this method will get attribute from element */
    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    /* this method will get attribute from element */
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /* this method will get text from element */
    public String getText(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public Select createSelectElement(WebElement element) {
        Select s = new Select(element);
        return s;
    }

    /* this method will be used for selecting element from dropdown using visible text */
    public void selectFromDropDownByVisibleText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public String getSelectedItemText(Select element) {
        String text = element.getFirstSelectedOption().getText();
        return text;
    }

    /* this method will be used for scrolling down to particular element */
    public void javaScriptScrollDownToParticularElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /* this method will be used for scrolling down to particular position */
    public void javaScriptScrollDownToParticularPosition(String position) {
        js.executeScript("window.scrollBy(0," + position + ")", "");
    }

    /* this method will be used for scrolling to bottom of the page */
    public void javaScriptScrollToBottom() {
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page down */
    public void scrollPageDown() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page up */
    public void scrollPageUp() {
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void scrollToSpecificElementOnCenter(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }


    /* this method will zoom the page */
    public void zoomPageByJS(String zoomProcsent) {
        js.executeScript("document.body.style.zoom='" + zoomProcsent + "%'"); //zoom by 100%
    }

    /* this method will be used for clicking on WebElement */
    public void javaScriptClick(WebElement element) {
        waitElementTobeClickable(element);
        js.executeScript("arguments[0].click();", element);
    }

    /* this method will be used for sending text to text box */
    public void javaScriptSendKeys(String text) {
        js.executeScript("document.getElementById('q').value='" + text + "'");
    }

    /* this method will refresh browser */
    public void javaScriptRefreshBrowser() {
        js.executeScript("history.go(0)");
    }

    /* this method will draw border for element */
    public void javaScriptDrawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
    }

    /* this method will return title of the page */
    public String javaScriptGetTitle() {
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    /* this method will generate the alert window */
    public void javaScriptGenerateAlert(String massage) {
        js.executeScript("alert('" + massage + "')");
    }

    public void waitAction(int waitTime) {
        actions.pause(waitTime).perform();
    }

    public void actionMoveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void actionMoveToElementClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    public void actionDoubleClick(WebElement element) {
        waitElementToBeVisible(element);
        actions.doubleClick(element).perform();
    }

    public void actionDownArrowXTime(int x) {
        for (int i = 0; i < x; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    //region <Take Screenshot>
    /* this method will be take Screenshot whale page*/
    public File captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + i + tname + ".png");
        FileUtils.copyFile(source, target);
        return target;
    }

    /* this method will be take Screenshot whale page and draw Border any element we mentioned*/
    public void captureScreenDrawBorder(WebDriver driver, WebElement element, String tname) throws IOException {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    /* this method will be take Screenshot mentioned element */
    public void captureFromScreenSpecificElement(WebDriver driver, WebElement element, String tname) throws IOException {

        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Compare_Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


    //region <Window Handling>
    public void handleWindowsWithArrayList(int index) {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(index));
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        //switch to parent window
        driver.switchTo().window(newTb.get(0));
    }

    public void switchToTab(String name) {
        driver.switchTo().window(name);
    }

    public void switchToNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void SwitchtoActiveTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    //region <Local storage>
    public org.openqa.selenium.html5.LocalStorage getLocalStorage() {
        WebStorage webStorage = (WebStorage) driver;
        return webStorage.getLocalStorage();
    }

    public String getItem(String key) {
        return getLocalStorage().getItem(key);
    }

    public void setItem(String key, String value) {
        getLocalStorage().setItem(key, value);
    }

    //endregion


    /* this method will be return True if Response cod is 0-300 */
    public boolean checkConnectionUrlResponseCod(String url) {
        boolean responseCodOK;

        if (url == null || url.isEmpty()) {
            System.out.println("  Empty link");
            responseCodOK = false;
        }
        try {
            URL link = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            connection.connect();
            int cod = connection.getResponseCode();

            if (cod >= 100 && cod < 200) {
                System.out.println(url + " Info Message  " + cod);
                responseCodOK = true;
            } else if (cod >= 200 && cod < 300) {
                System.out.println(url + " Response cod is OK  " + cod);
                responseCodOK = true;
            } else if (cod >= 300 && cod < 400) {
                System.out.println(url + " Server Redirection  " + cod);
                responseCodOK = false;
            } else if (cod >= 400 && cod < 500) {
                System.out.println(url + " Client error  " + cod);
                responseCodOK = false;
            } else if (cod >= 500) {
                System.out.println(url + " Server error  " + cod);
                responseCodOK = false;
            } else {
                System.out.println(" Something went wrong  ");
                responseCodOK = false;
            }

        } catch (Exception e) {
            responseCodOK = false;
            System.out.println("We have Exception  --> " + e);
        }
        return responseCodOK;
    }

}

