package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import reusable.actionClass;

public class HerokuApp {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         HerokuApp obj = new HerokuApp();
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
         driver.get("https://the-internet.herokuapp.com/"); // To Launch The Google Application

         System.out.println(" User Successfully launched Docker Web Application .....");

         obj =new actionClass(driver);


     }

     // Will do some test case validation here ....

     public void doSomeTestScenarioValidation() throws Exception {

             /*
             // Navigate to Dropdown page
             obj.ClickAndWait(By.xpath("//a[text()='Dropdown']"));
             //Select Option 2 as a dropdown...
             Select selectObj = new Select(driver.findElement(By.id("dropdown")));
             selectObj.selectByVisibleText("Option 2");
             Thread.sleep(1000);
             selectObj.selectByIndex(1);
             Thread.sleep(1000);

             //We need to navigate back to the Home page ...
             driver.navigate().back();

             //Validate checkbox 1

             obj.ClickAndWait(By.xpath("//a[text()='Checkboxes']"));

             // Validate only one checkbox is checked ...
             boolean ckbk1_Status = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
             if (!ckbk1_Status) {
                 System.out.println("Checkbox is not  checked");
                 obj.ClickAndWait(By.xpath("//form[@id='checkboxes']/input[1]"));
                 Thread.sleep(2000);
                 boolean ckbk1_StatusOn = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
                 if (!ckbk1_StatusOn) {
                     System.out.println("Now Checkbox 1 is checked");
                 } else {
                     System.out.println("Now Checkbox 1 is not checked even after clicking on it ...");
                 }
             }

             // Validate checkbox 2

             boolean ckbk2_Status = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
             if (ckbk2_Status) {
                 System.out.println("Checkbox 2 is already  checked");
                 obj.ClickAndWait(By.xpath("//form[@id='checkboxes']/input[2]"));

                 boolean ckbk2_StatusOn = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
                 if (!ckbk2_StatusOn) {
                     System.out.println("Now Checkbox 2 is checked");
                 } else {
                     System.out.println("Now Checkbox 2 is not checked even after clicking on it ...");
                 }
             }*/

             //Validate Web alert using Selenium ...

             //First Navigate to JavaScript Alerts Page ...
        /*     obj.ClickAndWait(By.xpath("//a[text()='JavaScript Alerts']"));
             // Now Click on
             obj.ClickAndWait(By.xpath("//button[text()='Click for JS Alert']"));
             String alertText = null;
             alertText = driver.switchTo().alert().getText();
             System.out.println("#####"+alertText+"#####");
             driver.switchTo().alert().accept();

             //Now Click On
             obj.ClickAndWait(By.xpath("//button[text()='Click for JS Confirm']"));
             alertText = driver.switchTo().alert().getText();
             System.out.println("#####"+alertText+"#####");
             driver.switchTo().alert().dismiss();

             obj.checkForElementPresent(By.xpath("//p[contains(.,'You clicked: Cancel')]"));

             System.out.println("User Clicked on Cancel button on the pop ups... ");

             // Now Click On JS Prompt

             obj.ClickAndWait(By.xpath("//button[text()='Click for JS Prompt']"));
             alertText = driver.switchTo().alert().getText();
             System.out.println("#####\"+alertText+\"#####");
             driver.switchTo().alert().sendKeys("Selenium");
             driver.switchTo().alert().accept();
             obj.checkForElementPresent(By.xpath("//p[contains(.,'You entered: Selenium')]"));

             System.out.println("User Typed Selenium in pop up Successfully ..... "); */

              // How to handle iFrame in selenium .....
         //First Navigate to JavaScript Alerts Page ...
            obj.ClickAndWait(By.xpath("//a[text()='Frames']"));
            // Now click on iFrame ...
         obj.ClickAndWait(By.xpath("//a[text()='iFrame']"));

         //Switch to iFrame ....
         driver.switchTo().frame("mce_0_ifr");
         try{
             driver.findElement(By.xpath("//p[contains(.,'Your content goes here.')]")).isDisplayed();
             System.out.println("#### iFrame Pass ####");
         }
         catch (Exception e) {e.printStackTrace();
             System.out.println("Para : Your content goes here, is not present...");
         }
         driver.switchTo().defaultContent();
         driver.navigate().back();
         System.out.println("We are in Frames Home page ...");



     }

    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
