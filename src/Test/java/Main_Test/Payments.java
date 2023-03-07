package Main_Test;

import PageObjects.Payments_Page;
import PageObjects.Login_Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Payments extends BaseClass {

    @BeforeMethod
    public void LoginSystem() throws InterruptedException {

        try {
            Login_Pages login = new Login_Pages();
            //Login System
            login.LoginSystem();
            //Select Eng Language
            login.Choose_Eng_Language();
        } catch (Exception err) {
            System.out.println("Unable to Login");
            Assert.fail();
        }
    }


    @Test()
    public void Verify_Deposit_section_is_Displayed() throws InterruptedException {
        test = extent.createTest("Deposit page availability").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Payments_Page payments = new Payments_Page();
        String actTitle = payments.Deposit_Page_aviability();
        String expTitle = "Select payment system";
        test.info("Expected Payment System Text" + "---->" + expTitle);
        Assert.assertEquals(actTitle, expTitle);
        test.info("Page checked");
    }


    @Test()
    public void Verify_Withdraw_section_is_Displayed() throws InterruptedException {
        test = extent.createTest("Withdraw page availability").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Payments_Page payments = new Payments_Page();
        Assert.assertTrue(payments.is_Withdraw_section_displayed());
        test.info("Withdraw section checked");
    }


    @Test()
    public void PaymentSystems() throws InterruptedException {
        test = extent.createTest("Payment Systems").assignCategory("Functional Main_Test.Test").assignDevice("Windows");
        Payments_Page payments = new Payments_Page();
        payments.Payment_Systems();
        String expectedTitle = "17";
        String actTitle = String.valueOf(payments.Payments.size());
        Assert.assertEquals(actTitle, expectedTitle);
        test.info("Payments size ---> " + actTitle);
    }

}
