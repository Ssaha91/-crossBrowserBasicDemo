import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.util.concurrent.TimeUnit;

public class BeforAndAfter {

    WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "/Users/sukantasaha/Downloads/Macy/src/test/resources/geckodriver 3");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            //create chrome instance
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("phantomjs")){
            WebDriverManager.phantomjs().setup();
            //create chrome instance
            driver = new PhantomJSDriver();
        }

        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
