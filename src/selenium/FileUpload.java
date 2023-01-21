package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.python.antlr.ast.Str;
import org.sikuli.script.Screen;
import reusable.actionClass;
import reusable.Reusable;



// Sikuli Implementation of Picture Matching it is not working as My Mac has high resolution...

public class FileUpload {
    public WebDriver driver;
    public actionClass obj;
    public static Reusable res;


     public static void main(String args[]) throws Exception{

         FileUpload obj = new FileUpload();
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
         driver.get(res.readPropertiesFile("url")); // To Launch The Google Application

         System.out.println(" User Successfully launched HerokuApp Application .....");

         obj = new actionClass(driver);


     }

     // Will do some test case validation here ....

    public void doSomeTestScenarioValidation() throws Exception
    {
        //Uploading an Image using Selenium ...
        driver.findElement(By.id("file-upload")).sendKeys("/Users/satwinder/Desktop/Sweety_Project/Docker_Logo.png");

        // Now Click on

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(4000);

        if(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed()
            && driver.findElement(By.xpath("//div[contains(.,'Docker_Logo.png') and @id ='uploaded-files']")).isDisplayed())
        {
            System.out.println("Image uploaded is Success!!!!");
        }
        else
        {
            System.out.println("Image uploaded is Fail!!!");
        }

        // Capture the Screenshot if test fails ...

        driver.navigate().to(res.readPropertiesFile("dockerurl"));

        Thread.sleep(5000);

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // Validate Get Started Button ...
        try{
            //driver.findElement(By.xpath("(//a[text()='Get Started'])[1]")).isDisplayed();
            driver.findElement(By.xpath("(//a[text()='Get Started'])[1]")).isDisplayed();

            //driver.findElement(By.xpath("(//a[text()='Get Started'])[10]")).isDisplayed();
            // As Xpath is wrong [10] does not have it so, it will save an image ...
        }
        catch(Exception e){
            e.printStackTrace();
            obj.takeTheScreenShot("Get Started Button");
        }

        // How to Right-Click on any HTML element ...
        WebElement ele = driver.findElement(By.xpath("(//a[text()='Get Started'])[1]"));
        Actions action = new Actions(driver).contextClick(ele);
        action.build().perform();

        Thread.sleep(4000);

        //Now Double on Docker Logo ...
        WebElement logo = driver.findElement(By.xpath("//li[@class='logo']"));

        action.doubleClick().perform();
        Thread.sleep(4000);




    }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
