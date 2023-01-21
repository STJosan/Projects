package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

import java.util.ArrayList;

public class TabHandle {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         TabHandle obj = new TabHandle();
         obj.launchApplication();
         obj.doSomeTestScenarioValidation();
         obj.closeApplication();
     }


     // This method will launch Google Application ...

     public void launchApplication()
     {


         System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver"); // To set Chrome Driver path in System properties

         driver = new ChromeDriver(); // This will launch your Chrome Browser
         driver.manage().window().maximize(); // This will Maximize the Browser
         driver.get("https://www.google.com/"); // To Launch The Google Application

         System.out.println(" User Successfully launched Google Search Application .....");

         obj =new actionClass(driver);


     }

     // Will do some test case validation here ....

     public void doSomeTestScenarioValidation() throws Exception {
         // First I will Launch Google

         // Then Open a new Tab--> Open Twitter

         // Capture Twitter Page Title

         // Close Twitter TAB

         // Come to Google Window and Type Twitter Title ....
         ((JavascriptExecutor)driver).executeScript("window.open()");
         Thread.sleep(3000);

         // We need to Capture How many Tabs we have ...
         ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(Tabs.get(1));

         driver.navigate().to("https://twitter.com/");
         String TwitterTitle = driver.getTitle();
         driver.close();
         driver.switchTo().window(Tabs.get(0));

         // Move Back to Google Tab ...
         driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(TwitterTitle);
         System.out.println("Twitter is typed in google search bar..");
         Thread.sleep(1000);






     }

    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
