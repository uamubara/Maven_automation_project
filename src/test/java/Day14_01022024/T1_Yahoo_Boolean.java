package Day14_01022024;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Yahoo_Boolean extends TestParent {

    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Methods.clickMethod(driver, "//*[text() = 'Sign in']", "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertTrue(isStaySignedInChecked);
    }//end of tc 01

    @Test
    public void tc002_verifySignInOptionIsUnchecked() throws InterruptedException {
        //click on the checkbox to uncheck it
        Reusable_Methods.clickMethod(driver, "//*[@class= 'stay-signed-in checkbox-container']", "checkbox");

        Thread.sleep(2000);
        //should store false value since checkbox is not checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertFalse(isStaySignedInChecked);
    }//end of tc002

}//end of class

