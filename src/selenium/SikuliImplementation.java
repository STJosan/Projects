package selenium;

import com.sun.jna.platform.unix.X11;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import reusable.actionClass;

import java.util.Iterator;
import java.util.Set;

public class SikuliImplementation {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         SikuliImplementation obj = new SikuliImplementation();
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

         obj = new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception
    {
        Screen scr = new Screen();
        try
        {
            scr.exists("/Users/satwinder/Desktop/Docker_Logo.png");
            System.out.println("Docker Logo is Present ...");
        }
        catch(Exception e)
        {
            System.out.println("Docker Logo is not Present ...");
        }



     }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
