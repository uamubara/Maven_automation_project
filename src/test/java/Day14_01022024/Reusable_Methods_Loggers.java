package Day14_01022024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Reusable_Methods_Loggers {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            //attach screenshot if click method fails
            getScreenShot(driver, elementName, logger);
        }//end of try catch
    }//end of click method

    public static void isConditionTrue(boolean bool, ExtentTest logger) {
        if (bool) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method

    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Successfully submitted on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to submit on " + elementName);
            //attach screenshot if submit method fails
            getScreenShot(driver, elementName, logger);
        }//end of try catch
    }//end of submit method

    public static void sendKeys(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully entered text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to enter text on " + elementName);
            //attach screenshot if send keys method fails
            getScreenShot(driver, elementName, logger);
        }// end of try catch
    }//end of send keys method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method


}//end of class


