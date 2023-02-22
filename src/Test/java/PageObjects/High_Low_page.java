package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class High_Low_page extends BasePage {

    @FindBy(css = ".wrapper-content")
    private WebElement wrapper_content;

//
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;
//    @FindBy(id = "")
//    WebElement myLocator;

    public High_Low_page() {
        PageFactory.initElements(BasePage.driver, this);

    }
    WebDriverWait High_Low_wait = new WebDriverWait(driver, Duration.ofSeconds(70));

    public boolean Verify_High_Low_is_Displayed() {
        High_Low_wait.until(ExpectedConditions.visibilityOf(wrapper_content));
        return wrapper_content.isDisplayed();
    }

}
