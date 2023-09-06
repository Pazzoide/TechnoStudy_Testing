package US_TST_04;

import Utility.BaseDriver;
import Utility.Fonksiyon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_TST_04 extends BaseDriver {
    @Test
    public void testAccessCoursesFromSubmenu(){

    driver.get("https://techno.study/tr");
    Fonksiyon.bekle(2);

    WebElement kurslarText = driver.findElement(By.cssSelector("[class='t-menu__link-item t966__tm-link']"));
        Assert.assertTrue(kurslarText.getText().equals("KURSLAR"),"KURSLAR ana sayfada gorunmedi");

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    Fonksiyon.bekle(1);

    WebElement kurs1 = driver.findElement(By.linkText("SDET Yazılım Test Mühendisi"));
    kurs1.click();
    Fonksiyon.bekle(1);

    WebElement kurs1IsimKontrol = driver.findElement(By.xpath("//div[text()='Yazılım Test Mühendisi']"));
    Assert.assertTrue(kurs1IsimKontrol.getText().equals("Yazılım Test Mühendisi"));

    WebElement kurs1BilgiKontrol = driver.findElement(By.linkText("Detaylı bilgi"));
    Assert.assertTrue(kurs1BilgiKontrol.getText().equals("Detaylı bilgi"));
    Fonksiyon.bekle(1);

        driver.navigate().back();

    WebElement kurs2 = driver.findElement(By.linkText("Android Uygulama Geliştirme"));
    kurs2.click();
    Fonksiyon.bekle(1);

    WebElement kurs2IsimKontrol = driver.findElement(By.xpath("//div[@class='tn-atom']/p"));
    Assert.assertTrue(kurs2IsimKontrol.getText().equals("Android uygulama geliştirme"));
    Fonksiyon.bekle(1);

    WebElement kurs2BilgiKontrol = driver.findElement(By.linkText("Detaylı bilgi"));
    Assert.assertTrue(kurs2BilgiKontrol.getText().equals("Detaylı bilgi"));
    Fonksiyon.bekle(1);

        driver.navigate().back();

    WebElement kurs3 = driver.findElement(By.linkText("Veri bilimi"));
    kurs3.click();
    Fonksiyon.bekle(1);

    WebElement kurs3IsimKontrol = driver.findElement(By.xpath("//div[text()='Veri Bilimi Bootcamp']"));
    Assert.assertTrue(kurs3IsimKontrol.getText().equals("Veri Bilimi Bootcamp"));
    Fonksiyon.bekle(1);

    WebElement kurs3BilgiKontrol = driver.findElement(By.linkText("Detaylı bilgi"));
    Assert.assertTrue(kurs3BilgiKontrol.getText().equals("Detaylı bilgi"));
    Fonksiyon.bekle(1);

        driver.navigate().back();

    WebElement kurs4 = driver.findElement(By.linkText("Master's Program"));
    kurs4.click();
    Fonksiyon.bekle(1);

    WebElement kurs4IsimKontrol = driver.findElement(By.xpath("//h1[@class='tn-atom']"));
    Assert.assertTrue(kurs4IsimKontrol.getText().equals("Master's Degree"));
    Fonksiyon.bekle(1);

    WebElement kurs4BilgiKontrol = driver.findElement(By.linkText("Learn more"));
    Assert.assertTrue(kurs4BilgiKontrol.getText().equals("Learn more"));
    Fonksiyon.bekle(1);

    BekleVeKapat();

    }
}
