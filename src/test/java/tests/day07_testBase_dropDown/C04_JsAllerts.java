package tests.day07_testBase_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_JsAllerts extends TestBase {

    /*
        Bir testi calisitirirken
        web sayfasi bize uyari verebilir(Alert)
        EGER bu uyariyi sag click ole inspect edebiliyorsak
        bu bir HTML alert`dir
        ve diger tum HTML Webelement`ler gibi
        locate edilebilir ve kullanilabilirler

        ANCAK
        sag click yapip inspect edemiyorsak
        bunlar javascript alert olabilirler

        Js alert`ler locate edilemez
        sadece driver`imizi o alert`lere switch yapip
        o alert`lerde istenen islemleri yapabiliriz
     */

    @Test
    public void test01(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();
        bekle(1);

        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        bekle(1);
        System.out.println(actualAlertYazisi);

        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
        bekle(1);
    }

    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")).click();
        bekle(1);
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();
        String expectedSonucYazisi = "You clicked: Cancel";
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        bekle(2);
    }

    @Test
    public void test03(){
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text() = 'Click for JS Prompt']")).click();
        bekle(1);
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        bekle(1);
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        bekle(1);
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();
        String expectedSonucYazisi = "Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
        bekle(2);
    }

}
