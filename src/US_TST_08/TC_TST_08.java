package US_TST_08;

import Utility.BaseDriver;
import Utility.Fonksiyon;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TC_TST_08 extends BaseDriver {

    @Test
    public void Kullanim_Sartlari_Sayfasina_Erisebilme() {
        driver.get("https://techno.study/tr");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='t-checkbox__labeltext']>span")));

        WebElement sartlar = driver.findElement(By.cssSelector("span[class='t-checkbox__labeltext']>span"));
        js.executeScript("arguments[0].scrollIntoView(true);", sartlar);

        WebElement checkBox = driver.findElement(By.cssSelector("div[class='t-checkbox__indicator']"));
        checkBox.click();

        Fonksiyon.bekle(2);
        ScreenshotCapture();
        sartlar.click();
        BekleVeKapat();
    }
    @Test
    public void Kullanim_Sartlari_Sayfasina_ErisebilmeGlobal() {
        driver.get("https://techno.study");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Terms of Use'])[1]")));

        WebElement termsOfUse = driver.findElement(By.xpath("(//a[text()='Terms of Use'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", termsOfUse);

        WebElement checkBox = driver.findElement(By.cssSelector("div[class='t-checkbox__indicator']"));
        checkBox.click();

        ScreenshotCapture();
        termsOfUse.click();

        String anasayfaWindowId = driver.getWindowHandle();
        Set<String> windowsIdler = driver.getWindowHandles();
        for (String id : windowsIdler) {
            if (id.equals(anasayfaWindowId)) continue;{driver.switchTo().window(id);}
        }

        Fonksiyon.bekle(2);
        ScreenshotCapture();
        BekleVeKapat();
    }

    public void ScreenshotCapture() {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.YYYY-hh.mm.ss");
        LocalDateTime dt = LocalDateTime.now();


        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);

            String dosyaYolu = "src\\US_TST_08\\ekranGoruntuleri\\"+dt.format(f)+".png";
            FileUtils.copyFile(hafizadakiHali, new File(dosyaYolu));

        } catch (Exception ex) {
            System.out.print("ex.getMessage() = " + ex.getMessage());
            System.out.println("EKRAN GÖRÜNTÜSÜ ALMA HATASI");
        }

    }
}
