package Day13_12192023;

import Day10_12112023.Reusable_Methods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestParent {

    //declare a global public driver variable
    public static WebDriver driver;
    //declare reports variable
    public static ExtentReports reports;

    //extent logger
    public static ExtentTest logger;



    @BeforeSuite
    public void setUpChromeDriver() {
        driver = Reusable_Methods.setUpDriver();
        //declare report path
       // reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite

    @BeforeMethod
    public void setTestName(Method methodName) {
        //logger = reports.startTest(methodName.getName());
    }//end beforeMethod

    @AfterMethod
    public void endTest() {
        //reports.endTest(logger);

    }//end after method

    @AfterSuite
    public void quitDriver() {
        driver.quit();
        //generate final report
        //reports.flush();
    }//end of after suite
}
