import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

public class Amazon extends BeforAndAfter {
    @Parameters("BROWSER")
    @Test(enabled = true)
    public void amazon(@Optional String BROWSER)throws Exception{

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class=\"nav-sprite nav-logo-tagline nav-prime-try\""))));

        driver.get("https://www.amazon.com");
        WebElement tryPrime = driver.findElement(By.xpath("//a[@class=\"nav-sprite nav-logo-tagline nav-prime-try\"]"));

        System.out.println(tryPrime.getCssValue("color"));
        System.out.println(tryPrime.getCssValue("display"));
        System.out.println(tryPrime.getCssValue("border-color"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(3);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target" + driver + "screenshoot.png"));


    }
}
