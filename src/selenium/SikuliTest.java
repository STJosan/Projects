package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import reusable.actionClass;

// Sikuli Implementation of Picture Matching it is not working as My Mac has high resolution...

public class SikuliTest {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         SikuliTest obj = new SikuliTest();
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
         driver.get("https://the-internet.herokuapp.com/basic_auth"); // To Launch The Google Application

         System.out.println(" User Successfully launched HerokuApp Application .....");

         obj = new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception
    {
        Screen test = new Screen();
        test.exists("/Users/satwinder/Desktop/Sweety_Project/Username.png");
        test.exists("/Users/satwinder/Desktop/Sweety_Project/Password.png");

        test.type("/Users/satwinder/Desktop/Sweety_Project/Username.png" , "username");
        Thread.sleep(2000);
        test.type("/Users/satwinder/Desktop/Sweety_Project/Password.png" , "Password");
        Thread.sleep(2000);



    }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
