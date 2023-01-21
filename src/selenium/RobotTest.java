package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotTest {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         RobotTest obj = new RobotTest();
         obj.launchApplication();
         obj.doSomeTestScenarioValidation();
         obj.closeApplication();
     }


     // This method will launch Google Application ...

     public void launchApplication() throws Exception
     {

         System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver"); // To set Chrome Driver path in System properties

         driver = new ChromeDriver(); // This will launch your Chrome Browser
         driver.manage().window().maximize(); // This will Maximize the Browser
         driver.get("https://the-internet.herokuapp.com/basic_auth"); // To Launch The Google Application

         System.out.println(" User Successfully launched Docker Web Application .....");

         obj =new actionClass(driver);
         Thread.sleep(2000);


     }

     // Will do some test case validation here ....

     public void doSomeTestScenarioValidation() throws Exception
     {

         Robot RBT = new Robot();


         RBT.keyPress(KeyEvent.VK_TAB);
         RBT.keyRelease(KeyEvent.VK_TAB);

         Thread.sleep(3000);
         

         RBT.keyPress(KeyEvent.VK_U);
         RBT.keyRelease(KeyEvent.VK_U);
         RBT.keyPress(KeyEvent.VK_S);
         RBT.keyRelease(KeyEvent.VK_S);
         RBT.keyPress(KeyEvent.VK_E);
         RBT.keyRelease(KeyEvent.VK_E);
         RBT.keyPress(KeyEvent.VK_R);
         RBT.keyRelease(KeyEvent.VK_R);
         RBT.keyPress(KeyEvent.VK_N);
         RBT.keyRelease(KeyEvent.VK_N);
         RBT.keyPress(KeyEvent.VK_A);
         RBT.keyPress(KeyEvent.VK_M);
         RBT.keyPress(KeyEvent.VK_E);
         Thread.sleep(3000);
         RBT.keyPress(KeyEvent.VK_TAB);
         Thread.sleep(3000);
         RBT.keyPress(KeyEvent.VK_P);
         RBT.keyPress(KeyEvent.VK_A);
         RBT.keyPress(KeyEvent.VK_S);
         RBT.keyPress(KeyEvent.VK_S);
         RBT.keyPress(KeyEvent.VK_W);
         RBT.keyPress(KeyEvent.VK_O);
         RBT.keyPress(KeyEvent.VK_R);
         RBT.keyPress(KeyEvent.VK_D);
         Thread.sleep(10000);



     }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
