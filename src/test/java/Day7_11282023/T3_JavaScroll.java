package Day7_11282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class T3_JavaScroll {

    public static void main(String[] args) throws InterruptedException {

        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //open in incognito mode
        options.addArguments("incognito");

        //run in headless mode (runs in the background)
//        options.addArguments("headless");

        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo
        driver.navigate().to("https://www.mlcalc.com/");

        //Declare Java script Executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0,1500)");

        //wait 2 seconds
        Thread.sleep(2000);

        jse.executeScript("scroll(0,-400)");

        //wait 2 seconds
        Thread.sleep(2000);

        WebElement calcButton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));

        jse.executeScript("arguments[0].scrollIntoView(true);", calcButton);

        //wait 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();

    }

}
