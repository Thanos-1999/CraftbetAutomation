package Main_Test;

import PageObjects.BasePage;
import Utills.config.Configuration;
import Utills.driver.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static Utills.config.ConfigurationManager.configuration;


public class BaseClass extends DriverFactory {

    public WebDriver driver;
    static ExtentHtmlReporter htmlReporter;

    public ExtentReports extent;

    public ExtentTest test;
    public Configuration configuration;
    Faker faker = new Faker();

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        configuration = configuration();
        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        new BasePage(driver);
    }


    @BeforeTest
    public void extentReportSetup() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Extent Report V4");
        htmlReporter.config().setTheme(Theme.DARK);
        extent.setSystemInfo("Test Name", "Craftbet Test");
        extent.setSystemInfo("User Name", "Hayk");
    }

    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/test-output/" + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Main_Test.Main_Test.Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Main_Test.Main_Test.Test Case Failed", ExtentColor.RED));
            String screenshotPath = getScreenShot(driver, result.getName());
            test.fail("Main_Test.Main_Test.Test Case Failed Screenshot is below " + test.addScreenCaptureFromPath(screenshotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Main_Test.Main_Test.Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Main_Test.Main_Test.Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest()
    public void endReport() {
        extent.flush();
    }
}



