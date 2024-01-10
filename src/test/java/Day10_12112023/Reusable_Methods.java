package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Methods {

    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click method


    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + ":" + e);
        }
    }//end of submit method


    public static String captureText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String result = element.getText();
            System.out.println(elementName + " text: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Unable to get text for " + elementName + ": " + e);
            return "";
        }
    }


    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return a driver instance
        return driver;
    }//end of setupdriver method

    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click method


    public static ArrayList<String> zipCodeList() {
        //Create an ArrayList to store three different zip Code
        ArrayList<String> zipCode = new ArrayList<>();
        //Populate ArrayList
        zipCode.add("10001");
        zipCode.add("77004");
        zipCode.add("90001");

        return zipCode;
    }

    // Reusable method to navigate to the workshop page
    public static void navigateToPage(WebDriver driver, String url) {
        // Navigate to weightwatchers.com
        driver.navigate().to(url);

    }

    public static void sendKeysMethod(WebDriver driver, String xpath, ArrayList<String> list, int index, String elementName) {
        // Use explicit wait to wait for at least one element to be present
        WebDriverWait wait = new WebDriverWait(driver, 20); // 10 seconds timeout
        try {
            WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            // Clear the search field
            search.clear();
            // Type value into the search field
            search.sendKeys(list.get(index));
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
        }


    }

    public static void sendKeys(WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
        }// end of try catch
    }//end of send keys method

    public static void switchTabs(WebDriver driver, int index, String elementName) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tab 1
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Unable to switch Tab " + elementName + ":" + e);
        }

    }

    public static void closeTab(WebDriver driver, String elementName) {

        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.close();
            //switch back to default tab
            driver.switchTo().window(tabs.get(0));

        } catch (Exception e) {
            System.out.println("Unable to close Tab " + elementName + ":" + e);
        }
    }

    public static void selectByText(WebDriver driver, String xpath1, String xpath2, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 20); // 10 seconds timeout
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
            driver.findElement(By.xpath(xpath1)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
            driver.findElement(By.xpath(xpath2)).click();
        } catch (Exception e) {
            System.out.println("Unable to click element: " + elementName + ":" + e);
        }
    }

    public static void scrollByPixel(WebDriver driver, String scroll_XY, String elementName) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(scroll_XY);
        } catch (Exception e) {
            System.out.println("Unable to Scroll and click element: " + elementName + ":" + e);
        }
    }

    public static void scrollInToElement(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to Scroll and click element: " + elementName + ":" + e);
        }
    }

    public static void clickStudioLink(WebDriver driver, int linkIndex) {
        // Define WebElements ArrayList
        ArrayList<WebElement> linkContainer = new ArrayList<>();

        try {
            // Explicit wait for links to be present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'-3SE46')]")));
            linkContainer = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'-3SE46')]")));

            // Click on the appropriate link based on linkIndex
            if (linkIndex == 0) {
                linkContainer.get(1).click(); // Click the second link
            } else if (linkIndex == 1) {
                linkContainer.get(2).click(); // Click the third link
            } else if (linkIndex == 2) {
                linkContainer.get(0).click(); // Click the first link (default)
            }

            // Explicit wait for studio name element to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'-1jro')]")));

            // Capture studio name and address
            WebElement studio = driver.findElement(By.xpath("//*[contains(@class,'-1jro')]"));
            WebElement address = driver.findElement(By.xpath("//*[contains(@class,'2PZwW')]"));

            // Print studio name and address
            System.out.println("Studio Name: " + studio.getText());
            System.out.println("Address: " + address.getText());
            System.out.println(" "); // Blank line for better visibility

        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Error processing studio link: " + e.getMessage());
            // Handle the exception appropriately, e.g., log details, retry, or fail the test
        }
    }

    public static void printStudioWorkshopSchedule(WebDriver driver, String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Explicit wait for the table element to be present and visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

            // Scroll to the table element
            WebElement tbl = driver.findElement(By.xpath(xPath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tbl);

            // Print the schedule
            System.out.println(tbl.getText());
            System.out.println(" "); // Blank line for better visibility

        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Error printing studio workshop schedule: " + e.getMessage());
            // Handle the exception appropriately, e.g., log details, retry, or fail the test
        }
    }

}
