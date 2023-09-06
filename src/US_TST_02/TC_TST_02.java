package US_TST_02;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TC_TST_02 extends BaseDriver {
    @Test
    public void Anasayfadan_Campus_Platformuna_Giris_Yapabilme() {
        driver.get("https://techno.study/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='tn-atom__img t-img loaded'])[1]")));
        ScreenshotCapture();

        WebElement signIn = driver.findElement(By.linkText("SIGN IN"));
        Assert.assertTrue(signIn.isDisplayed(),"Login functionality not found!");
        signIn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[loading='eager']")));

        Assert.assertTrue(driver.getCurrentUrl().contains("https://campus.techno.study"),
                "CAMPUS GİRİŞ SAYFASI DIŞINDA BİR SAYFAYA YÖNLENDİRME MEVCUT");
        ScreenshotCapture();

        BekleVeKapat();
    }


    public void ScreenshotCapture() {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.YYYY-hh.mm.ss");
        LocalDateTime dt = LocalDateTime.now();


        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);

            String dosyaYolu = "src\\US_TST_02\\ekranGoruntuleri\\"+dt.format(f)+".png";
            FileUtils.copyFile(hafizadakiHali, new File(dosyaYolu));

        } catch (Exception ex) {
            System.out.print("ex.getMessage() = " + ex.getMessage());
            System.out.println("EKRAN GÖRÜNTÜSÜ ALMA HATASI");
        }

    }
}
