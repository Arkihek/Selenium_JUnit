package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReusableMethods {

    public static String ikinciSayfaWHD(String ilkSayfaWindowHandleDegeri, WebDriver driver) {

        String ikinciSayfaWHD = "";

        Set<String> windowHandleSeti = driver.getWindowHandles();

        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWHD = each;
            }
        }

        return ikinciSayfaWHD;
    }

    public static String hucredekiYaziyiGetir(int satirNo, int sutunNo, WebDriver driver) {

        //                                  tbody/tr[   5   ]/td[    1    ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucredekiElement.getText();
    }

    public static void screenshot(WebDriver driver) {
        // 1. adim : driver`i TakesScreenshot objesine cast edelim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : ekran resminin kaydedilecegi bir file olusturalim
        // dosya adini dinamik hale getirmek icin time stamp kullanalim
        LocalDateTime ldt = LocalDateTime.now(); // 2023-07-06T10:17:47.634441
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddhhmm");
        String dinamikDosyaYolu = "target/ScreenShots/TumSayfa" + ldt.format(dtf) + ".png"; // target/ScreenShots/TumSayfa23061023.png

        File tumSayfaFoto = new File(dinamikDosyaYolu);
        // 3.adim tss objesini kullanarak screenshot alalim ve gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementFotoCek(WebDriver driver, WebElement istenenWebElement) {

        LocalDateTime ldt = LocalDateTime.now(); // 2023-07-06T10:17:47.634441
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddhhmm");
        String dinamikDosyaYolu = "target/ScreenShots/webElement" + ldt.format(dtf) + ".png";

        File webElementFoto = new File(dinamikDosyaYolu);
        File geciciDosya = istenenWebElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,webElementFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
