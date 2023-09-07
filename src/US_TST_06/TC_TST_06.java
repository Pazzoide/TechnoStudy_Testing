package US_TST_06;

import Utility.BaseDriver;
import Utility.Fonksiyon;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_TST_06 extends BaseDriver {
    @Test
    public void TechoStudyLogo_Test() throws Exception {
        driver.get("https://techno.study/tr/");
        Fonksiyon.bekle(2);
        takeScreenshot(driver);

        WebElement tstLogo=driver.findElement(By.cssSelector("[class='t228__imglogo ']"));
        tstLogo.click();

        WebElement ekranYazisiGorme = driver.findElement(By.cssSelector("a[class='tn-atom js-click-zero-stat']"));
        Assert.assertTrue(ekranYazisiGorme.getText().equals("APPLY NOW"));
        takeScreenshot(driver);

        BekleVeKapat();
    }
    public static void takeScreenshot(WebDriver driver) throws Exception {
        SimpleDateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        TakesScreenshot ss = (TakesScreenshot) driver;
        String tarih = tarihFormat.format(date);
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("src/US_TST_06/screenshots/screenshot_" + tarih + ".png"));
    }
}
