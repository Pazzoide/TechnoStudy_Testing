package US_TST_05;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_TST_05 extends BaseDriver {
    @Test
    public void socialMenu() {
        driver.get("https://techno.study/tr");

        WebElement submenu = driver.findElement(By.cssSelector(".t420__logo.t-title"));
        String SubmenuText = submenu.getText();
        Assert.assertTrue(SubmenuText.contains("Techno Study"));

        WebElement facebook = driver.findElement(By.cssSelector("li.t-sociallinks__item_facebook>a[aria-label='facebook']"));
        Assert.assertNotNull(facebook);
        Assert.assertTrue(facebook.isEnabled() && facebook.isDisplayed(), "facebook ikonu tiklanabilir değil veya görünmez.");


        WebElement instagram = driver.findElement(By.cssSelector("li.t-sociallinks__item_instagram > a[aria-label='instagram']"));
        Assert.assertNotNull(instagram);
        Assert.assertTrue(instagram.isEnabled() && instagram.isDisplayed(), "Instagram ikonu tiklanabilir değil veya görünmez.");

        WebElement youtube = driver.findElement(By.cssSelector("li.t-sociallinks__item_youtube > a[aria-label='youtube']"));
        Assert.assertNotNull(youtube);
        Assert.assertTrue(youtube.isEnabled() && youtube.isDisplayed(), "youtube ikonu tiklanabilir değil veya görünmez.");

        WebElement linkedin = driver.findElement(By.cssSelector("li.t-sociallinks__item_linkedin > a[aria-label='linkedin']"));
        Assert.assertNotNull(linkedin);
        Assert.assertTrue(linkedin.isEnabled() && linkedin.isDisplayed(), "linkedin ikonu tiklanabilir değil veya görünmez.");

       BekleVeKapat();
    }

}
