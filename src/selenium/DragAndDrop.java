package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reusable.Reusable;
import reusable.actionClass;

import javax.swing.plaf.TableHeaderUI;

// Not working as Expected ...
public class DragAndDrop {
    public WebDriver driver;
    public actionClass obj;
    public static Reusable res;


     public static void main(String args[]) throws Exception{

         DragAndDrop obj = new DragAndDrop();
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
         driver.get(res.readPropertiesFile("url1")); // To Launch The Google Application

         System.out.println(" User Successfully launched HerokuApp Application .....");

         obj = new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception
    {

        // How to Drag and Drop ...
        obj.ClickAndWait(By.xpath("//a[text()='Drag and Drop']"));

        WebElement what_To_Drag = driver.findElement(By.xpath("//div[@id='column-a']/header[text()='A']"));
        WebElement Where_To_Drop = driver.findElement(By.xpath("//div[@id='column-b']/header[text()='B']"));

        Actions test = new Actions(driver);
        test.dragAndDrop(what_To_Drag,Where_To_Drop);
        Thread.sleep(4000);

        WebElement sourcePro = driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']"));
        WebElement destPro = driver.findElement(By.xpath("//div[@id='column-b']/header[text()='A']"));

        if (sourcePro.isDisplayed() && destPro.isDisplayed())
        {
            System.out.println("DRAG and DROP is successful...");
        }
        else
        {
            System.out.println("DRAG and DROP is Failed..");
        }



    }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
