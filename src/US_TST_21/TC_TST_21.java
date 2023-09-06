package US_TST_21;

import Utility.BaseDriver;
import Utility.Fonksiyon;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_TST_21 extends BaseDriver {

    @Test
    public void DetayliBilgi_Test() throws Exception {
        driver.get("https://techno.study/tr/");
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1900);");
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        WebElement detayliBilgi = driver.findElement(By.cssSelector("a[class='tn-atom'][href='https://techno.study/tr/data']"));
        detayliBilgi.click();
        takeScreenshot(driver);

        WebElement detayliBilgiSayfa = driver.findElement(By.cssSelector("a[class='tn-atom'][href='#rec516068360']"));
        Assert.assertTrue("Detaylı Bilgi gözükmedi! =", detayliBilgiSayfa.isDisplayed());
        takeScreenshot(driver);

        BekleVeKapat();

    }

    public static void takeScreenshot(WebDriver driver) throws Exception {
        SimpleDateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        TakesScreenshot ss = (TakesScreenshot) driver;
        String tarih = tarihFormat.format(date);
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("src/US_TST_21/screenshots/screenshot_" + tarih + ".png"));
    }
}
