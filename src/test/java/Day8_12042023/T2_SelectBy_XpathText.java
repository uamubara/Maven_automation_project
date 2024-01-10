package Day8_12042023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class T2_SelectBy_XpathText {

    public static void main(String[] args) throws InterruptedException {

        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //declare the chrome options
        ChromeOptions options = new ChromeOptions();

        //add some options for chromeoptions
        options.addArguments("start-maximized");

        //open in incognito mode
        options.addArguments("incognito");


        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calulator site
        driver.navigate().to("https://www.mortgagecalculator.org/");

        //wait a few second
        Thread.sleep(2000);

        //clear and enter the homevalue
        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeVal.clear();
        homeVal.sendKeys("450000");

        Thread.sleep(2000);

        //clear and enter the homevalue
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("9000");

        Thread.sleep(2000);

        //clear and enter the homevalue
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();

        driver.findElement(By.xpath("//*[text()='Jan']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='Dec']")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
