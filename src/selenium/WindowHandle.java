package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         WindowHandle obj = new WindowHandle();
         obj.launchApplication();
         obj.doSomeTestScenarioValidation();
         obj.closeApplication();
     }


     // This method will launch docker Application ...

     public void launchApplication()
     {


         System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver"); // To set Chrome Driver path in System properties

         driver = new ChromeDriver(); // This will launch your Chrome Browser
         driver.manage().window().maximize(); // This will Maximize the Browser
         driver.get("https://www.docker.com/"); // To Launch The Google Application

         System.out.println(" User Successfully launched Docker Application .....");

         obj =new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception {

        // First Click On Twitter Logo From Footer Section ...
        String ParentWindow = driver.getWindowHandle();
        // Now I am clicking on Twitter logo
        WebElement ele = driver.findElement(By.xpath("//div[@id='footer']//ul[@class='social-wrap']//a[contains(@href,'twitter')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
        Thread.sleep(5000);
        ele.click();
        Thread.sleep(5000);

        // Return number of Windows open by WebDriver and will return set of String...

        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();

        while(itr.hasNext())
        {
            String childWindow = itr.next();
            if(!ParentWindow.equals(childWindow))
            {
                driver.switchTo().window(childWindow);
               System.out.println(driver.getTitle());
               System.out.println(driver.getCurrentUrl());
               driver.close();
            }
        }
        driver.switchTo().window(ParentWindow);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

     }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
