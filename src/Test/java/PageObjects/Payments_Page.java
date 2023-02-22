package PageObjects;

import org.openqa.selenium.  WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static PageObjects.BasePage.driver;

public class Payments_Page {

    @FindBy(css = ".button-style3")
    @CacheLookup
    private WebElement Deposit_btn;

    @FindBy(css = ".payment-list-column .payment_header")
    @CacheLookup
    private WebElement Select_Payment_System;

    @FindBy(css = ".user-right-panel_top [href='\\/user\\/1\\/withdraw']")
    @CacheLookup
    private WebElement Withdraw_section;

    @FindBy(css = ".payment_list_item_img")
    @CacheLookup
    public List<WebElement> Payments;

    @FindBy(css = ".payment-list-column")
    @CacheLookup
    private WebElement Payments_List_Witdhraw;


    public Payments_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);

    public String Deposit_Page_aviability() {
        try {
            basePage.waitAction(3000);
            basePage.clickOnElementIfClickable(Deposit_btn);
            return basePage.getText(Select_Payment_System);
        } catch (Exception e) {
            return "Deposit page is not working";
        }
    }

    public void Payment_Systems() {
        basePage.waitAction(3000);
        basePage.clickOnElementIfClickable(Deposit_btn);
    }


    public boolean is_Withdraw_section_displayed() {
        try {
            basePage.waitAction(3000);
            basePage.clickOnElementIfClickable(Deposit_btn);
            basePage.javaScriptClick(Withdraw_section);
            Thread.sleep(2000);
            Payments_List_Witdhraw.isDisplayed();
            return true;
        } catch (Exception e) {
            System.out.println("Withdraw page is not working");
            return false;
        }
    }
}

