package tests.day11_excellOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucElement.getText();

        // Tum sayfa fotografini cekmek icin 4 adima ihtiyac var
        // 1. adim : driver`i TakesScreenshot objesine cast edelim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : ekran resminin kaydedilecegi bir file olusturalim
        File tumSayfaSS = new File("target/ekranScrenshot/tumsayfaSS.png");

        // 3.adim tss objesini kullanarak screenshot alalim ve gecici bir dosyaya kaydedelim
        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, olusturdugumuz tumSayfaSS'e kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaSS);

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));



        bekle(5);

    }

}
