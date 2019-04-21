
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SetUpDriverAutomatically extends BeforAndAfter {

    @Parameters("BROWSER")
    @Test
    public void testOnGoogle(@Optional String BROWSER) throws IOException, InterruptedException {

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Google");
        Thread.sleep(3);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(3);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target" + driver + "screenshoot.png"));

    }
    @Parameters("BROWSER")
    @Test(enabled = false)
    public void testOnMacy(@Optional String BROWSER)throws Exception{

        driver.get("https://www.macy.com");

        String acual = driver.getTitle();
        System.out.println(acual);

        String expected = "Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com";

        Assert.assertEquals(acual, expected);

    }

}
