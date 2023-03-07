package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class


Registration_Page extends BasePage {

    @FindBy(css = ".global_register-btn")
    @CacheLookup
    private WebElement Registration_btn;

    @FindBy(css = ".form_field>select")
    @CacheLookup
    private WebElement Select_Gender;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    @CacheLookup
    private WebElement Reg_First_Name;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    @CacheLookup
    private WebElement Reg_Last_Name;

    @FindBy(xpath = "//input[@placeholder='00 00 00 00']")

    private WebElement Reg_Mobile;

    @FindBy(xpath = "//div[@class='birthDate_tabs']//select[1]")

    private WebElement Reg_Year;

    @FindBy(xpath = "//div[@class='birthDate_tabs']//select[2]")

    private WebElement Reg_Month;

    @FindBy(xpath = "//div[@class='birthDate_tabs']//select[3]")

    private WebElement Reg_Day;

    @FindBy(css = ".reg-step-navigate-buttons")

    private WebElement Continue;

    @FindBy(xpath = "//input[@placeholder='Register.UserNameplaceholder']")

    private WebElement Reg_Username;

    @FindBy(xpath = "//input[@placeholder='Email']")

    private WebElement Reg_Email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement Reg_Password;

    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    private WebElement Reg_Confirm_Password;

    @FindBy(css = ".craft_btn.next-btn")
    private WebElement Reg_Confirm;

    @FindBy(css = ".register-background [data-id='register-type-Full-Register']")
    private WebElement Full_Register_btn;

    @FindBy(css = ".reg-checkbox")

    private List<WebElement> Reg_Checkboxes;

    @FindBy(css = ".button-style3")
    @CacheLookup
    private WebElement Deposit_btn;

    @FindBy(xpath = "//select[contains(@class,'ng-pristine ng-valid')]")
    private WebElement Reg_dropdown;


    public Registration_Page() {
        PageFactory.initElements(BasePage.driver, this);
    }

    BasePage basePage = new BasePage(driver);

    public void Open_Registration_Page() {

        Login_Pages login_page = new Login_Pages();
        basePage.javaScriptClick(login_page.Language_dropdown);
        basePage.javaScriptClick(login_page.Eng_Language);
        basePage.waitAction(3000);
        try {
            basePage.javaScriptClick(Registration_btn);
        } catch (Exception e) {
            System.out.println("Registration button is not working");
        }
    }

    public void Click_Full_Register() {
        try {
            basePage.waitElementToBeVisible(Full_Register_btn);
            basePage.javaScriptClick(Full_Register_btn);
        } catch (Exception e) {
            System.out.println("Unable to click Full Register button");
        }
    }

    public void Select_Gender() throws InterruptedException {
        Select drpgender = new Select(Select_Gender);
        try {
            drpgender.selectByVisibleText("Male");
        } catch (Exception e) {
            System.out.println("Select Gender is not working");

        }
    }

    public void Registration_First_Name(String Firstname) {

        basePage.sendKeysIfElementVisible(Reg_First_Name, Firstname);
    }

    public void Registration_Last_Name(String LastName) {
        basePage.sendKeysIfElementVisible(Reg_Last_Name, LastName);
    }

    public void Registration_Mobile(String Mobile) {
        basePage.sendKeysIfElementVisible(Reg_Mobile, Mobile);
    }

    public void Year_Registration() {
        Select RegYear = new Select(Reg_Year);
        try {
              RegYear.selectByVisibleText("1999");
            } catch (Exception e) {
             System.out.println("Year Field is not working");
        }
    }

    public void Month_Registration() {
        Select RegYear = new Select(Reg_Month);
        try {
            RegYear.selectByVisibleText("May");
        } catch (Exception e) {
            System.out.println("Month Field is not working");
        }
    }

    public void Day_Registration() {
        Select RegYear = new Select(Reg_Day);
        try {
            RegYear.selectByVisibleText("8");
        } catch (Exception e) {
            System.out.println("Day Field is not working");
        }
    }

    public void Continue() {
        try {
            basePage.clickOnElementIfVisible(Continue);
            basePage.waitAction(3000);
            basePage.clickOnElementIfVisible(Continue);


        } catch (Exception e) {
            System.out.println("Button is not working");
        }
    }

    public void Registration_Username(String Username) throws InterruptedException {
        basePage.waitAction(1000);
        basePage.sendKeysIfElementVisible(Reg_Username, Username);
    }

    public void Registration_Dropdown() throws InterruptedException {
        basePage.waitAction(1000);
        Select se = new Select(Reg_dropdown);
        basePage.waitAction(1000);
        se.selectByVisibleText("USD");
    }

    public void Registration_Email(String Email) throws InterruptedException {
        basePage.waitAction(1000);
        basePage.sendKeysIfElementVisible(Reg_Email, Email);
    }

    public void Registration_Password(String password) throws InterruptedException {
        basePage.waitAction(1000);
        basePage.sendKeysIfElementVisible(Reg_Password, password);
    }

    public void Registration_Confirm_Password(String password_confirm) throws InterruptedException {
        basePage.waitAction(1000);
        basePage.sendKeysIfElementVisible(Reg_Confirm_Password, password_confirm);
    }


    public void Registration_CheckBoxes() {
        for (WebElement cb : Reg_Checkboxes) {
            cb.click();
        }
//        System.out.println("All check boxes have been selected");
    }

    public void Registration_Confirm() {
        basePage.clickOnElementIfClickable(Reg_Confirm);
        basePage.waitAction(3000);
    }


    public String Deposit() {
        return basePage.getText(Deposit_btn);
    }
}

