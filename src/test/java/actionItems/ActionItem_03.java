package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem_03 {
    public static void main(String[] args) throws InterruptedException {

        //Declare Array list of 5 Values
        ArrayList<String> sports = new ArrayList<>();
        // Populate Array with 5 String Values
        sports.add("Football");
        sports.add("Basketball");
        sports.add("Baseball");
        sports.add("Soccer");
        sports.add("Boxing");

        //Setup the Chromedriver with Webdrivermanager
        WebDriverManager.chromedriver().setup();

        //Define the Webdriver
        WebDriver driver = new ChromeDriver();

        //For loop to Iterate through test steps. Set number of iterations to the size of ArrayList.
        for (int i = 0; i < sports.size(); i++) {

            //navigate to Bing web Page
            driver.navigate().to("https://www.Bing.com");

            //Maximize the window
            driver.manage().window().maximize();

            //Search for sports using Arraylist values (using relative xpath)
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //hit submit button on Bing Search. Note: I used search bar x path to submit my input.
            driver.findElement(By.xpath("//*[@name='q']")).submit();

            //slow down by 3 seconds
            Thread.sleep(3000);

            //store search results in a string variable
            String searchResults = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //Split search result using split command
            String[] searchResultsArray = searchResults.split(" ");

            //split search results and print only the search number for each value to console
            System.out.println("Search number for " + sports.get(i) + " is " + searchResultsArray[1]);


        }

        //Quit Browser
        driver.quit();
    }
}
