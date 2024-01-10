package Day14_010224;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods_Loggers {

    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
           // logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
           // logger.log(LogStatus.FAIL,"unable to click on " + elementName);
        }
    }//end of click method

    public static void isConditionTrue(boolean bool, ExtentTest logger){
        if(bool) {
            //logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        }else {
            //logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method
}

