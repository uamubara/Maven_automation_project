package actionItems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.testng.annotations.Test;

//Public class extends TestParent Class
public class ActionItem_06 extends TestParent {

    @Test
    public void testCase1(){
        //navigate to fideliscare.org web page
        driver.navigate().to("https://www.fideliscare.org");
        //click on search element top right
        Reusable_Methods.clickMethod(driver,"//*[contains(@class,'dropdown search')]","SearchField");
        //type: get dental coverage in search field
        Reusable_Methods.sendKeys(driver,"//*[contains(@class,'search-input')]","get dental coverage","userInput");
        //submit text input in search field, click search
        Reusable_Methods.clickMethod(driver,"//*[contains(@class,'btn-search')]", "click_Search_btn");
        //store the search result into a string variable
        String result = Reusable_Methods.captureText(driver, "//*[@id='resInfo-0']", "SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the search number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
        //click on get dental coverage link from search result list
        Reusable_Methods.clickMethod(driver,"//*[text()='Get Dental Coverage']","Get_Coverage_Lnk");
    }

    @Test(dependsOnMethods = "testCase1")
    public void testCase2(){
        //switch to new tab
        Reusable_Methods.switchTabs(driver,1,"tab");
        //input first name in field
        Reusable_Methods.sendKeys(driver,"//*[@id='firstName']","Usman","firstName");
        //input last name in field
        Reusable_Methods.sendKeys(driver,"//*[@id='lastName']","Mubarak","lastName");
        //input zip code in field
        Reusable_Methods.sendKeys(driver,"//*[@id='zipCode']","77598","zipCode");
        //select county by text from dropdown menu
        Reusable_Methods.selectByText(driver,"//*[@id='county']", "//*[text()='New York']", "Dropdown");
        //input phone number in field
        Reusable_Methods.sendKeys(driver,"//*[@id='phoneNumber']","444-777-0420","phoneNumber");
        //input email in field
        Reusable_Methods.sendKeys(driver,"//*[@id='email']","jashawn.theoden@falkcia.com","email");
        // click on contact me box
        Reusable_Methods.clickMethod(driver,"//*[@for='contactMe']", "contactMe_Box");
        //click on Contact Me button and submit input from all fields
        Reusable_Methods.clickMethod(driver,"//button[contains(text(), 'Contact Me')]", "contactMe_btn");
        //Capture Alert message
        String msg= Reusable_Methods.captureText(driver,"//*[@role='alert']","Alert_msg");
        //print Alert message
        System.out.println(msg);
        //close tab
        Reusable_Methods.closeTab(driver,"closeTab");
    }

    @Test(dependsOnMethods = "testCase2")
    public void testCase3() {
        //Switch to home tab
        Reusable_Methods.switchTabs(driver, 0, "Home_Tab");
        //click on login button
        Reusable_Methods.clickMethod(driver, "//*[contains(text(), 'Login')]", "Login_Btn");
        //select from dropdown menu Members only Portal Link
        Reusable_Methods.selectByText(driver, "//a[@target='_blank']", "//h4[@class='link-external']", "MemberPortal_Link");
        //switch to members only tab
        Reusable_Methods.switchTabs(driver, 1, "MembersPortal_tab");

        //Capture Helpful Hints text Body
         String helpfulHint_Body = Reusable_Methods.captureText(driver, "(//div[@class='body-copy sm'])[1]", "Helpful_Msg_Body");
        //Print text [1] from helpful hint text Body
         System.out.println(helpfulHint_Body);
        //space for better visibility on text output
         System.out.println(" ");
        //Capture Helpful Hints bulleted Unordered List UL
         String helpfulHint_Body2 = Reusable_Methods.captureText(driver, "(//div[@class='body-copy sm'])[2]", "Helpful_Msg_Body2");
        //print text from helpful hint Unordered List UL
         System.out.println(helpfulHint_Body2);
        //Capture Helpful Hints text Body 3
        String helpfulHint_Body3 = Reusable_Methods.captureText(driver, "(//div[@class='body-copy sm'])[3]", "Helpful_Msg_Body3");
        //Print text [3] from helpful hint text Body
        System.out.println(helpfulHint_Body3);

        //close tab
         Reusable_Methods.closeTab(driver,"close_tabTC3");
        }

        //Note: All Method calls are from Reusable_Methods Class
}
