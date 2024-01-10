package Day6_11272023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_GoogleSearchForLoop {

    public static void main(String[] args) throws InterruptedException {

        //Declare Array list of 3 Values
        ArrayList<String> carBrands = new ArrayList<>();
        // Populate Array with 3 String Values
        carBrands.add("BMW");
        carBrands.add("Mercedes");
        carBrands.add("Toyota");


        //Setup the Chromedriver with Webdrivermanager
        WebDriverManager.chromedriver().setup();

        //Define the Webdriver
        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //For loop to Iterate through test steps. Set number of iterations to the size of ArrayList.
        for (int i = 0; i < carBrands.size(); i++) {

            //navigate to Bing web Page
            driver.navigate().to("https://www.Google.com");


            //Search for carBrands using Arraylist values (using relative xpath)
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(carBrands.get(i));

            //hit submit button on Bing Search. Note: I used search bar x path to submit my input.
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //slow down by 3 seconds
            Thread.sleep(3000);

            //store search results in a string variable
            String searchResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            //Split search result using split command
            String[] searchResultsArray = searchResults.split(" ");

            //split search results and print only the search number for each value to console
            System.out.println("Search number for " + carBrands.get(i) + " is " + searchResultsArray[1]);


        }

        //Quit Browser
        driver.quit();
    }

}
