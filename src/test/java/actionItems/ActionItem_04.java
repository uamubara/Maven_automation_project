package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_04 {
    public static void main(String[] args) throws InterruptedException {

        //Create an ArrayList to store three different zip Code
        ArrayList<String> zipCode = new ArrayList<>();
        //Populate ArrayList
        zipCode.add("10001");
        zipCode.add("77004");
        zipCode.add("90001");

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


        //For loop to iterate through test steps multiple times
        for (int i = 0; i < zipCode.size(); i++) {

            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");

            //wait 2 seconds
            Thread.sleep(2000);

            //click on the "Find a Workshop" link (Top right side of page)
            driver.findElement(By.xpath("//*[contains(@class,'-3ht2E')]")).click();

            //wait 2 seconds
            Thread.sleep(2000);

            //store the search field location ID into webelement variable
            WebElement search = driver.findElement(By.xpath("//*[@id='location-search']"));
            //clear the search field
            search.clear();
            //type zip code in to search field
            search.sendKeys(zipCode.get(i));
            //wait 3 seconds
            Thread.sleep(3000);
            //click on arrow button
            driver.findElement(By.xpath("//*[contains(@id,'-cta')]")).click();
            //wait 3 seconds
            Thread.sleep(3000);

            //Define WebElements ArrayList
            ArrayList<WebElement> linkContainer = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'-3SE46')]")));

            //Conditional Statements to click on studio links. Condition based on for-loop iteration number (i=0),(i=1),(i=2)
            if (i == 0) {
                //click on second link
                linkContainer.get(1).click();

            } else if (i == 1) {
                //click on third link
                linkContainer.get(2).click();

            } else if (i == 2) {
                //click on first link
                linkContainer.get(0).click();
            }

            //Wait three seconds
            Thread.sleep(3000);

            //Capturing studio name for better context and to verify Studio & address match
            WebElement studio = driver.findElement(By.xpath("//*[contains(@class,'-1jro')]"));

            //capture the address on a variable
            WebElement address = driver.findElement(By.xpath("//*[contains(@class,'2PZwW')]"));

            //Print Studio Name
            System.out.println(studio.getText());
            //Print out Address
            System.out.println(address.getText());
            //Print blank line for better visibility on output
            System.out.println(" ");

            //Declare Java script Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //Declare Web Element tbl to capture "Studio WorkShop Schedule"
            WebElement tbl = driver.findElement(By.xpath("//*[@id = 'studioWorkshopSchedule']"));

            //Scroll into Web Element "Studio WorkShop Schedule
            jse.executeScript("arguments[0].scrollIntoView(true);", tbl);

            //wait three seconds
            Thread.sleep(3000);

            //Print schedule
            System.out.println(tbl.getText());
            //Print empty line for format and better visibility of output
            System.out.println(" ");


        }

        //wait 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();
    }
}
