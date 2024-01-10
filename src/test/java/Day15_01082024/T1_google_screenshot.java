package Day15_01082024;

import Day13_12192023.TestParent;
import Day14_01022024.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

public class T1_google_screenshot extends TestParent {

    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods_Loggers.sendKeys(driver, "//*[@name= 'q']", "BMW", logger, "SearchField");
        //hit submit on the Google search button
        Reusable_Methods_Loggers.submitMethod(driver, "//*[@name= 'btnKlp']", logger, "Submit");
        Thread.sleep(1000);
    }//end of test case 1

    @Test
    public void tc002_gitCommit() {
        //committing a new test case
    }//end of test case 1

    @Test
    public void tc003_gitSecondCommit() {
        //committing a new test case
    }//end of test case 1

}//end of class

