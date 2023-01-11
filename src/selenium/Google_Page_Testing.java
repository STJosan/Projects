package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Page_Testing {
    public WebDriver driver;

    public static void main(String args[] ) throws Exception{

        Google_Page_Testing obj = new Google_Page_Testing();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();

    }

    //This method will launch Google Application ....

    public void launchApplication(){
        //To set Chrome Driver path in System Properties
        System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver");
        driver = new ChromeDriver(); // this will launch your Chrome browser
        driver.get("https://www.google.com");
        System.out.println("User is successfully opening google webpage ");


    }

    //This method will do some test case validation....

    public void doSomeTestScenarioValidation(){
        //Validate Google logo is present or not
        try{
            driver.findElement(By.className("lnXdpd")).isDisplayed();
            System.out.println("Google logo is displayed "+"PASS");
        }
        catch(Exception e)

        {  e.printStackTrace();
            System.out.println("Google is not displayed"+"FAIL");
        }


        //Validate if Google search button is there or not
        if(driver.findElements(By.className("gNO89b")).size()>0){

            System.out.println("Google search Button logo is present "+"PASS");
        }
        else{
            System.out.println("Google search button is not present "+"FAIL");
        }

        //Validate Search Text Box

        if(driver.findElement(By.name("q")).isDisplayed()){
            driver.findElement(By.name("q")).sendKeys("Software Testing");
            System.out.println("Google search text box is displayed "+"PASS");
        }
        else {
            System.out.println("Google search text box is not displayed"+"FAIL");
        }



    }

    //This method will close the Application

    public void closeApplication(){

        driver.quit(); //To quit the Driver session / close the Chrome


    }


}
