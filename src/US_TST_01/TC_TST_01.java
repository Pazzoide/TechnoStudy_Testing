package US_TST_01;

import Utility.BaseDriver;
import Utility.Fonksiyon;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_TST_01 extends BaseDriver {
    @Test
    public void testViewCoursesDropdownOnHomePage() throws Exception {
        driver.get("https://techno.study/tr/");
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        WebElement kurslar = driver.findElement(By.xpath("//a[@class='t-menu__link-item t966__tm-link']"));
        Actions aksiyon = new Actions(driver);
        aksiyon.moveToElement(kurslar).perform();
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        WebElement yeniPencere = driver.findElement(By.xpath("//div[@class='t966__content']"));
        aksiyon.moveToElement(yeniPencere).perform();
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", yeniPencere);
        Fonksiyon.bekle(2);

        WebElement master = driver.findElement(By.xpath("//div[@field='li_title__1663426353172']"));
        master.click();
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techno.study/masters";
        Assert.assertTrue(expectedURL.equals(actualURL),"URL Doğrulanamadı: "+actualURL);

        BekleVeKapat();
    }
    public static void takeScreenshot(WebDriver driver) throws Exception {
        SimpleDateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        TakesScreenshot ss = (TakesScreenshot) driver;
        String tarih = tarihFormat.format(date);
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("src/US_TST_01/screenshots/screenshot_" + tarih + ".png"));
    }
}
