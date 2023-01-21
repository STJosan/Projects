package reusable;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class actionClass {

    public WebDriver  driver = null;

    public actionClass(WebDriver driver)
    {
        this.driver = driver;
    }

    public void checkForElementPresent(By test)
    {
        try
        {
            driver.findElement(test).isDisplayed();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(test+" ......is not present");
        }

    }

    public void TypeOnATextBox(By element, String whatToType)
    {
        try
        {
            driver.findElement(element).sendKeys(whatToType);
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(element+" ......is not present");
        }

    }

    // This method Can Click on A HTML Element

    public void ClickAndWait(By element) {
        try {
            driver.findElement(element).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(element + " ......is not present");
        }
    }

    // Explicit wait implementation
     /*  public void ClickAndExplicitWait(By element){
           try{
               driver.findElement(element).click();
               Thread.sleep(10000);
           }
           catch(Exception e){e.printStackTrace();
               System.out.println(element+"..... is not present ...");}
       }*/

    // Scroll to a particular Web Element

        public void ScrollToElement(By element){
        try{
            WebElement ele = driver.findElement(element);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
            Thread.sleep(5000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present to Scroll...");}
        }

        // This is reusable method can do a Mouse Hover ...

    public void MouserHover(By element){
        try{
            WebElement ele = driver.findElement(element);
            Actions action = new Actions(driver);
            action.moveToElement(ele).build().perform();
            Thread.sleep(2000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present to Scroll...");}
    }

    // To get a particular text from a website

    public String GetTheText(By element){
        String text = null;
        try{
           text = driver.findElement(element).getText();
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present in the website...");
        }
        return text;
    }

    //Capture Screenshot ...
    public void takeTheScreenShot(String imageName) throws Exception
    { //Convert Web Driver Object to take Screenshot ...
        TakesScreenshot scrshot = ((TakesScreenshot) driver);

        //Call getScreenshots method to create Image File ...

        File SrcFile = scrshot.getScreenshotAs((OutputType.FILE));

        // Move Image File to a new Destination ...
        File DesSrcFile = new File(System.getProperty("user.dir")+"/screenshot/"+imageName+".png");

       //FileUtils.copyFile(SrcFile,DesSrcFile);


    }




}

