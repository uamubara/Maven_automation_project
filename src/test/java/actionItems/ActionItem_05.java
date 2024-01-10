package actionItems;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static Day10_12112023.Reusable_Methods.*;

public class ActionItem_05 {
    public static void main(String[] args){

        // Get the list of zip codes
        ArrayList<String> zipCodes = zipCodeList();
        // Call Method to setup Chrome Driver and Chrome Options
        setUpDriver();
        //instantiate the driver
         WebDriver driver = Reusable_Methods.setUpDriver();

        for(int i=0; i< zipCodes.size(); i++){

            //Call Method that will navigate to weightwatchers.com
            navigateToPage(driver,"https://www.weightwatchers.com/us/find-a-workshop");
            // Call method to click on Workshop link
            clickMethod(driver,"//*[contains(@class,'-3ht2E')]", "FindWorkShop");
            //Call Method to find search field, clear search field and enter zip codes in to search field
            sendKeysMethod(driver, "//*[@id='location-search']",zipCodeList(),i,"Search_Field");
            //Call method to click on Arrow Button
            clickMethod(driver, "//*[contains(@id,'-cta')]", "ArrowBtn");

            Reusable_Methods.clickStudioLink(driver, i);

            captureText(driver,"//*[contains(@class,'-1jro')]", "StudioName");

            captureText(driver,"//*[contains(@class,'2PZwW')]", "Address");



        }

        driver.quit();

    }


}
