package Main_Test;

import PageObjects.Registration_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration extends BaseClass {

    String random_First_name = faker.name().firstName();
    String random_Gmail = faker.name().firstName() + faker.name().lastName() + "@Gmail.com";
    String random_Username = faker.name().username();
    String random_Last_name = faker.name().lastName();
    String random_Mobile_Number = String.valueOf(Integer.parseInt(faker.number().digits(9)));

    @Test(description = "Registration page")
    public void Craftbet_Registration() throws InterruptedException, IOException {
        test = extent.createTest("Registration").assignCategory("Functional Test").assignDevice("Windows");
        Registration_Page registration = new Registration_Page();
        registration.Open_Registration_Page();
        test.info("Open Registration page");
        registration.Click_Full_Register();
        test.info("Click Full Register button");
        registration.Select_Gender();
        test.info("Select Gender");
        registration.Registration_First_Name(random_First_name);
        test.info(random_First_name + " : <-- Enter 'random' First Name");
        registration.Registration_Last_Name(random_Last_name);
        test.info(random_Last_name + "  : <-- Enter 'random' Last Name");
        registration.Registration_Mobile(random_Mobile_Number);
        test.info(random_Mobile_Number + "  : <--  Enter random Mobile number");
        registration.Year_Registration();
        test.info("Enter Birth Year");
        registration.Month_Registration();
        test.info("Enter Birth Mouth");
        registration.Day_Registration();
        test.info("Enter Birth Day");
        registration.Continue();
        test.info("Double Click Continue btn");
        registration.Registration_Username(random_Username);
        test.info(random_Username + "  : <-- Enter 'random' Username");
        System.out.println("Login:  " + random_Username);
        registration.Registration_Email(random_Gmail);
        test.info(random_Gmail + "  : <--  Enter 'random' Email");
        registration.Registration_Dropdown();
        test.info("Select Currency: USD");
        registration.Registration_Password("Test12345");
        System.out.println("Password:  Test12345");
        test.info("Test12345 " + "  : <-- Enter Password");
        registration.Registration_Confirm_Password("Test12345");
        test.info("Confirm Password");
        registration.Registration_CheckBoxes();
        test.info("Select Available Checkboxes");
        Thread.sleep(2000);
        registration.Registration_Confirm();
        test.info("Click Register");
        Thread.sleep(2000);

        if (driver.getPageSource().contains("User name exists")) {
            Assert.fail();
            test.fail("User name exists");
        }

        Thread.sleep(4000);

        if (registration.Deposit().equalsIgnoreCase("Deposit")) {
            Assert.assertTrue(true, test.pass("Registration successfully completed").toString());
        } else {
            Assert.fail(test.fail("Registration fail").toString());
        }
    }
}