package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

   public class SL_WIth_try_Catch {
       public WebDriver driver;
       public actionClass obj;


        public static void main(String args[]) throws Exception{

            SL_WIth_try_Catch obj = new SL_WIth_try_Catch();
            obj.launchApplication();
            obj.doSomeTestScenarioValidation();
            obj.closeApplication();
        }


        // This method will launch Google Application ...

        public void launchApplication(){


            System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver"); // To set Chrome Driver path in System properties

            driver = new ChromeDriver(); // This will launch your Chrome Browser
            driver.manage().window().maximize(); // This will Maximize the Browser
            driver.get("https://www.simplilearn.com"); // To Launch The Google Application

            System.out.println(" User Successfully launched simplilearn Application .....");

            obj =new actionClass(driver);


        }

        // Will do some test case validation here ....

        public void doSomeTestScenarioValidation(){

            // Validate SimpliLearn Logo
                obj.checkForElementPresent(By.xpath("//img[@alt='Simplilearn - Online Certification Training Course Provider']"));
                obj.checkForElementPresent(By.id("header_srch"));

               //How to print current Page Title ?

               System.out.println("The Current Page Title=="+ driver.getTitle());

               //How to print current TAB URL ?

              System.out.println("The Current TAB URL== "+ driver.getCurrentUrl());

              //Validate Search Text Box Functionality ...

              obj.TypeOnATextBox(By.id("header_srch"),"Selenium");

              //Validate that Search Glass ...

              obj.ClickAndWait(By.xpath("//button[@title='search']"));

              //Validate Automation Testing Masters Program in next Page

              obj.checkForElementPresent(By.xpath("//h2[text()='Automation Testing Masters Program']"));
              System.out.println("Search text box Functionality is working as expected....");

              // Move back to home page ...from search Page

              obj.ClickAndWait(By.xpath("//img[@alt='Simplilearn - Online Certification Training Course Provider']"));


            // Scroll to Request For Free Demo Button

              obj.ScrollToElement(By.xpath("(//a[text()='Request a Free Demo'])[1]"));
              System.out.println("Request a Free Demo button text box is available");
        }






       // Will close the Application

        public void closeApplication(){

            driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

        }



    }
