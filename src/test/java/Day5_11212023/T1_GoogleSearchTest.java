package Day5_11212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleSearchTest {

    public static void main(String[] args) throws InterruptedException {

        //Setup the Chromedriver with Webdrivermanager
        WebDriverManager.chromedriver().setup();

        //Define the Webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to Google web Page
        driver.navigate().to("https://www.google.com");

        //Maximize the window
        driver.manage().window().maximize();

        //Search for cars (using relative xpath
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");

        //hit submit button on Google Search
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //slow down by 2 seconds
        Thread.sleep(3000);

        //store search results in a string variable
        String searchResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //print out search results to console
        System.out.println("Search Results is: " + searchResults);

        //Split search result using split command
        String[] searchResultsArray = searchResults.split(" ");


        //split search results to console
        System.out.println("Search Result is: " + searchResultsArray[1]);


        //Quit Browser
        driver.quit();


    }
}
