package tests.day12_screenshot_isExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_jsExecutor extends TestBase {

    @Test
    public void test01(){
        //Wisequarter sayfasina gidelim
        driver.get("https://www.wisequarter.com");

        //jsExecutor kullanarak contact linkini tiklayin
        WebElement contactLinkElementi = driver.findElement(By.xpath("//a[text()='Contact']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",contactLinkElementi);

        // anasayfaya geri donun asagida bulunan go to career page butonuna kadar assagiya inin ve click yapin
        driver.navigate().back();

        WebElement careerLinkElementi = driver.findElement(By.xpath("//i[@class='fas fa-paper-plane']"));

        jse.executeScript("arguments[0].scrollIntoView(true);", careerLinkElementi);

        bekle(5);

        careerLinkElementi.click();

        jse.executeScript("alert('hoydaaaaaa');");

        bekle(5);

    }
}
