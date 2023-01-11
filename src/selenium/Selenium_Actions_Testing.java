package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium_Actions_Testing {
    public WebDriver driver;

    public static void main(String args[] ) throws Exception{

        Selenium_Actions_Testing obj = new Selenium_Actions_Testing();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.doPrintAllImageLinks();
       // obj.doPrintAllLinks();
        obj.closeApplication();

    }

    //This method will launch Google Application ....

    public void launchApplication(){
        try {
            //To set Chrome Driver path in System Properties
            System.setProperty("webdriver.chrome.driver", "/Users/satwinder/Downloads/chromedriver");
            driver = new ChromeDriver(); // this will launch your Chrome browser
            driver.manage().window().maximize();
            driver.get("https://www.simplilearn.com");
            System.out.println("User is successfully opening google webpage ");
            Thread.sleep(1000);
        }
        catch(Exception e){}
    }

    //This method will do some test case validation....

    public void doSomeTestScenarioValidation() {
        //Validate Google logo is present or not
        int headermenucount = driver.findElements(By.xpath("//div[@id='topsubmenu']//div/a")).size();

        //To Print all header menu links

        for (int i = 1; i <= headermenucount; i++) {

            String linkname = driver.findElement(By.xpath("//div[@id='topsubmenu']//div/a[" + i + "]")).getText();
            System.out.println("When position is " + i + " " + "Then Link name is ==>" + linkname);

        }

        // To print the Title for Request A Demo Button ...
        String title = driver.findElement(By.xpath("(//a[text()='Request a Free Demo'])[1]")).getAttribute("title");
        System.out.println("The Title value of Request a Free Demo button is ===>" + title);
    }

    public void doPrintAllImageLinks(){

        //To print acount all image present in Simplilearn home page

        int allImageCount = driver.findElements(By.xpath("//img")).size();
        System.out.println("The total number of Image count is:" +allImageCount);
        //Then print src value of all the images
        for(int i =1 ; i <=allImageCount ; i++){

            String linkImg = driver.findElement(By.xpath("(//img)["+i+"]")).getAttribute("src");
            System.out.println("When Image position is "+i+" " +"Then Image Link is ==>"+linkImg);
        }
    }

    public void doPrintAllLinks() {
        //Validate Google logo is present or not

        int allLinksCount = driver.findElements(By.xpath("//a")).size();

        //To Print all header menu links

        for(int i =1 ; i <=allLinksCount ; i++){

            String linkname = driver.findElement(By.xpath("(//a)["+i+"]")).getText();
            System.out.println("When Link position is "+i+" " +"Then Link name is ==>"+linkname);
        }
    }

    //This method will close the Application

    public void closeApplication(){

        driver.quit(); //To quit the Driver session / close the Chrome


    }


}
