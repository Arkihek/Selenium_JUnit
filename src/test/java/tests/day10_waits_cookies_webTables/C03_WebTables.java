package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    @Test
    public void test01() {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        bekle(2);
        //3.Web table tum body’sini yazdirin
        WebElement tumBodyElement = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElement.getText());

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 9;
        int actualSatirSayisi = satirlarListesi.size();
        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        //5.Tum satirlari yazdirin

        System.out.println("===================");

        int satirNo = 1;
        for (WebElement eachElement : satirlarListesi
        ) {
            System.out.println(satirNo + "- " + eachElement.getText());
            satirNo++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int actualSutunSayisi = sutunSayisi.size();
        int expectedSutunSayisi = 13;
        Assert.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        //7. 5.sutunu yazdirin
        System.out.println("-----------------5.Sutun yazdirin-----------------");
        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        satirNo = 1;
        for (WebElement eachSutun : besinciSutunElementleri
        ) {
            System.out.println(satirNo + "- " + eachSutun.getText());
            satirNo++;
        }

        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun
        ReusableMethods.hucredekiYaziyiGetir(8,8,driver);

    }
}
