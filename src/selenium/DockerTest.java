package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

public class DockerTest {
    public WebDriver driver;
    public actionClass obj;


     public static void main(String args[]) throws Exception{

         DockerTest obj = new DockerTest();
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
         driver.get("https://www.docker.com"); // To Launch The Google Application

         System.out.println(" User Successfully launched Docker Web Application .....");

         obj =new actionClass(driver);


     }

     // Will do some test case validation here ....

     public void doSomeTestScenarioValidation()
     {
        // Hover on Products Header Menu Link

        obj.MouserHover(By.xpath("(//a[text()='Products'])[1]"));

         // Mouse Hover on Developer Header Menu Link

         obj.MouserHover(By.xpath("(//a[text()='Developers'])[1]"));

         //Mouse Hover on Pricing Menu link

         obj.MouserHover(By.xpath("(//a[text()='About Us'])[1]"));

         // How many Social Media links are present in Docker Webpage

         int medialinkCount = driver.findElements(By.xpath("//ul[@class='social-wrap']/li")).size();
         // To print All links ...
         System.out.println("medialinkCount is :"+medialinkCount);
        for (int i = 1; i <= medialinkCount; i++) {
             String linkName = driver.findElement(By.xpath("(//ul[@class='social-wrap']/li/a/img)[" +i +"]")).getAttribute("src");
             System.out.println("When src is" + " " + i + " " + "Then src name is =>" + linkName);
         }

         // validate 2022 inside copywright text ...

             if(obj.GetTheText(By.xpath("//p[contains(.,'All rights reserved')]")).contains("2022"))
         {
             System.out.println("The Copywright text is having 2022 as current year...");
         }
         else {
             System.out.println("The Copywright text is not having 2022 as current year...");
         }

     }



    // Will close the Application

     public void closeApplication()
     {

         driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

     }



 }
