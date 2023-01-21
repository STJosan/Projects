package selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reusable.actionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AmazonTesting {

        public WebDriver driver;
        public actionClass obj;


        public static void main(String args []) throws Exception
        {


            AmazonTesting obj = new AmazonTesting();
            obj.launchApplication();
            obj.ReadDataFromTable();
            obj.doSomeTestScenarioValidation();

            obj.closeApplication();

        }

        public void launchApplication()
        {
             /*1. Amazon.in is launched on Chrome browser ...*/

            //To set Chrome Driver path in System Properties
            System.setProperty("webdriver.chrome.driver","/Users/satwinder/Downloads/chromedriver");
            driver = new ChromeDriver();// this will launch your Chrome browser
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in");
            System.out.println("User is successfully opening Amazon webpage ");
            obj =new actionClass(driver);


        }

        public void ReadDataFromTable()
        {

            try {

                /* 2. Connection With JDBC ...*/

                String Category = null;
                String SearchVal = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecommerce", "root", "password");
                Statement stmt = con.createStatement();
                String query = "select * from Amazon;";
                ResultSet result = stmt.executeQuery(query);
                //ResultSet result = stmt.executeQuery("select * from Amazon");

                while (result.next())
                {
                    int a_id = result.getInt("id");
                    String cat = result.getString("category");
                    String sitem = result.getString("searchitem");
                    System.out.println(a_id + " : " + cat + " : " + sitem + "  ");

                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Unable to connect to database " + "FAIL");
            }


        }

        public void doSomeTestScenarioValidation() throws Exception {

            // 3. Hover the mouse on some Categories/
            obj.MouserHover(By.xpath("(//span[text()='All'])[2]"));

            // Hover on Best Sellers
            obj.MouserHover(By.xpath("(//a[text()='Best Sellers'])[1]"));

            // Hover on Mobiles
            obj.MouserHover(By.xpath("//a[text()='Mobiles']"));

            // Hover on Electronics
            obj.MouserHover(By.xpath("//a[text()=' Electronics ']"));

            // Hover on Customer Service
            obj.MouserHover(By.xpath("(//a[text()=\"Customer Service\"])[1]"));

            // Hover on Amazon Pay
            obj.MouserHover(By.xpath("//a[text()='Amazon Pay']"));


            int allCategoryCount = driver.findElements(By.xpath("(//select[@title='Search in'])/option")).size();
            System.out.println("Total Number of Amazon categories: "+allCategoryCount);

            // 4. To Print All Categories in Amazon Shopping Website.../

            for (int i = 1; i <= allCategoryCount; i++)
            {

                String linkname = driver.findElement(By.xpath("(//select[@title='Search in'])/option[" + i + "]")).getText();
                System.out.println("When position is " + i + " " + "Then Link name is ==>" + linkname);

            }

            //* 5. To Print the current Page Title.../

            System.out.println("The Current Page Title==" + driver.getTitle());

            System.out.println("The Current Page Title==" + driver.getCurrentUrl());

            //* 6. Validate Search Bar  is present...*/
            obj.checkForElementPresent(By.xpath("//select[@id='searchDropdownBox']"));

            //.Validate Search Text Box Functionality ...

            obj.TypeOnATextBox(By.xpath("//input[@id='twotabsearchtextbox']"), "Samsung Ultra HD");
            obj.ClickAndWait(By.xpath("//input[@id='nav-search-submit-button']"));
            if (obj.GetTheText(By.xpath("//div[@data-component-type='s-search-result']")).contains("Samsung"))
            {
                System.out.println("The TV Model is present...");

            }
            else
            {
                System.out.println("The TV model is not present...");
            }
            /* 7. Printing all the items in the search result...*/

            List<WebElement> col;
            col = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
            System.out.println("No of cols are " + col.size());
            List<WebElement> samsungTVList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

            System.out.println("The Samsung Shopping List have:");
            for (int i= 1; i<samsungTVList.size(); i++)
            {
                String eletext =samsungTVList.get(i).getText();
                System.out.println("The samsung shopping list is "+i+ "then details are: " +eletext);
            }



            /* 8. Click on a selected TV  ...*/

            WebElement tvchoice = driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[10]"));
            obj.ScrollToElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[10]"));

            obj.driver.navigate().back();

            System.out.println("The Current Page Title==" + driver.getCurrentUrl());


            // We need to Capture How many Tabs we have ...
            ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(Tabs.get(0));
            String AmazonTitle = driver.getTitle();


             /* 9. Getting how many items are there in footer( Make Money With Us)*/

             obj.ScrollToElement(By.xpath("//a[@id='navBackToTop']"));
             obj.MouserHover(By.xpath("//div[text()='Make Money with Us']"));
             driver.findElement(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[3]//a"));
             int countlinks = driver.findElements(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[3]//a")).size();
             System.out.println("Total Number of Links present in Make Money with Us: "+countlinks);
             //To Print All Categories in Amazon Shopping Website...
             List<WebElement> makelist = driver.findElements(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[3]//a"));
             for (int i = 1; i < makelist.size(); i++)
                {

                    String eletext =makelist.get(i).getText();
                    System.out.println("The link "+i+ " contains : " +eletext);

                }



                /* 10. Using CSS to find font,color of Amazon Logo...*/

                WebElement ele = driver.findElement(By.xpath("//a[@aria-label='Amazon.in']"));
                // Capture Font size, text color, background color of Get Started Button...

                String fnt_size = ele.getCssValue("font-size");
                String color = ele.getCssValue("color");
                String bg_color = ele.getCssValue("background-color");

                System.out.println("The Font size is ==> " + fnt_size);
                System.out.println("The color is ==> " + color);
                System.out.println("The Background color is ==> " + bg_color);

                /* 11. Validate Amazon Logo is displayed and taking a screen short if not displayed*/
                try
                {
                    driver.findElement(By.xpath("//a[@aria-label='Amazon.in']")).isDisplayed();
                    System.out.println("The Screen shot is working");

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    obj.takeTheScreenShot("Amazon Logo");
                    System.out.println("The Screen shot is not working");
                }

                /* 12. How to Right-Click on Amazan.in Logo */

                WebElement we = driver.findElement(By.xpath("//a[@aria-label='Amazon.in']"));
                Actions act = new Actions(driver);
                act.build().perform();

                Thread.sleep(3000);
                //Now Double on Amazon Logo ...
                WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Amazon.in']"));

                act.doubleClick().perform();
                Thread.sleep(3000);


            }


            // Will close the Application

            public void closeApplication ()
            {

                driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

            }



}
