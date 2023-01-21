package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reusable.Reusable;
import reusable.actionClass;



public class cssElementRead {
    public WebDriver driver;
    public actionClass obj;
    public static Reusable res;


     public static void main(String args[]) throws Exception{

         cssElementRead obj = new cssElementRead();
         res = new Reusable();
         obj.launchApplication();
         obj.doSomeTestScenarioValidation();
         obj.closeApplication();
     }


     // This method will launch docker Application ...

     public void launchApplication()
     {


        // System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver"); // To set Chrome Driver path we can use second method as every user has to change the path of chrome driver...
         System.setProperty("webdriver.chrome.driver",res.readPropertiesFile("chromepath"));
         driver = new ChromeDriver(); // This will launch your Chrome Browser
         driver.manage().window().maximize(); // This will Maximize the Browser
         driver.get(res.readPropertiesFile("urlkub")); // To Launch The Google Application

         System.out.println(" User Successfully launched Kubernetes Application .....");

         obj = new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception
    {
        WebElement ele = driver.findElement(By.xpath("//a[text()='Learn Kubernetes Basics']"));
        // Capture Font size, text color, background color of Get Started Button...

        String fnt_size = ele.getCssValue("font-size");
        String color = ele.getCssValue("color");
        String bg_color = ele.getCssValue("background-color");

        System.out.println("The Font size is ==> " +fnt_size);
        System.out.println("The color is ==> " +color);
        System.out.println("The Background color is ==> " +bg_color);







    }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
