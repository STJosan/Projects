package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpliLearn_Web_Testing {

    public WebDriver driver;

     public static void main(String args[] ) throws Exception{

        SimpliLearn_Web_Testing obj = new SimpliLearn_Web_Testing();
        obj.launchWebApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
        }
        //This method will launch SimpliLearn Web Application ....

       public void launchWebApplication(){
        //To set Chrome Driver path in System Properties
        System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver");
        driver = new ChromeDriver(); // this will launch your Chrome browser
        driver.get("https://www.simplilearn.com");
        System.out.println("User is able to view Simpli Learn website ");

           }

    //This method will do some test case validation....

          public void doSomeTestScenarioValidation() {

         // 1. Validate login Button  is present or not

             if (driver.findElements(By.className("login")).size() > 0) {
             System.out.println("Log in button is displayed");
             } else {
             System.out.println("Log in button is displayed");
                }
              if (driver.findElements(By.className("login")).size() > 0) {
                  driver.findElement(By.className("login")).click();
                  System.out.println("Login Button can be clicked " + "PASS");
                 // driver.findElement(By.name("user_login")).sendKeys("sweetyjosan@hotmail.com");
                  //driver.findElement(By.name("user_pwd")).sendKeys("Josan@2014");
                  //System.out.println("user is able to type username and password " + "PASS");
                  //driver.findElement(By.name("btn_login")).click();
                  //System.out.println("Login is successful" + "PASS"); }

                  // 2.Validate Google button is displayed

              if(driver.findElement(By.id("customGoogleSignIn")).isDisplayed()){

                   System.out.println("Google Button logo is present "+"PASS");
               }
               else{
                   System.out.println("Google search button is not present "+"FAIL");
               }
               //3. Validate facebook button is displayed

               if (driver.findElement(By.className("social-content")).isDisplayed()){
                   System.out.println("Facebook button is displayed"+ "PASS");
                  }
                 else {
                   System.out.println("Facebook button can not be displayed"+ "FAIL");
               }
                  driver.findElement(By.xpath("/a[text()=‘My Courses’]")).isDisplayed();
                  driver.findElement(By.xpath("/(/a[text()=‘Job Guarantee’])[1]")).isDisplayed();

                  int total_Link_count = driver.findElements(By.xpath("//dive[@id='topsubmenu']/div/a")).size();
              }
           else {
               System.out.println("Unable to click on  login");
           }

                  //4. Validate  login button can be clicked

                 /* if (driver.findElements(By.className("login")).size() > 0) {
                      driver.findElement(By.className("login")).click();
                      System.out.println("Login Button can be clicked " + "PASS");
                      driver.findElement(By.name("user_login")).sendKeys("sweetyjosan@hotmail.com");
                      driver.findElement(By.name("user_pwd")).sendKeys("Josan@2014");
                      System.out.println("user is able to type username and password " + "PASS");
                      driver.findElement(By.name("btn_login")).click();
                      System.out.println("Login is successful" + "PASS");

                  } else {
                      System.out.println("Login failed is failed" + "FAIL");
                  }*/

              /* try {
                driver.findElement(By.xpath("//img[@alt='Simplilearn - Online Certification Training Course Provider']")).isDisplayed();
                System.out.println("SimpliLearn Logo is present ..." + "PASS");
            }catch(Exception e){e.printStackTrace();System.out.println("SimpliLearn Logo is not present ..." + "FAIL");}


            // Validate SimpliLearn Search Text Box

            try {
                driver.findElement(By.id("header_srch")).isDisplayed();
                System.out.println("SimpliLearn Search Text Box is present ..." + "PASS");
            }
            catch(Exception e){e.printStackTrace();System.out.println("SimpliLearn Search Text Box is not present ..." + "FAIL");}
            */
              }



    //This method will close the Application

    public void closeApplication(){

        driver.quit(); //To quit the Driver session / close the Chrome


    }


}
