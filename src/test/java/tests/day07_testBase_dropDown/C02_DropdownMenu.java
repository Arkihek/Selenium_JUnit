package tests.day07_testBase_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C02_DropdownMenu extends TestBase {

    @Test
    public void test01(){

        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusunun yanindaki dropdown menude 28 secenek oldugunu test edin - 3 adimda
            // 1- Dropdown menuyu locate et
        WebElement dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));
            // 2- Select class`indan bir obje olusturalim
        Select select = new Select(dropdownMenuElementi);
            // 3- 28 secenek oldugunu test edelim
        int expectedOptionSayisi = 28;
        int actualOptionSayisi = select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        // dropdown menuden Baby kategorisini secin
        select.selectByVisibleText("Baby");
        // Arama kutusuna Nutella yazip aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        // bulunan sonuc sayisinin 9`dan fazla oldugunu test edin
        String sonucYazisi = driver.findElement(By.xpath("//*[@class = 'a-section a-spacing-small a-spacing-top-small']")).getText();
        // 10 results for "Nutella" / 10 sayisini nasil alicaz
        String sonucSayisiStr = sonucYazisi.substring(0,sonucYazisi.indexOf(" ")); // "10"

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr); // int olarak 10
        System.out.println(sonucSayisiInt);
        Assert.assertTrue(sonucSayisiInt>9);
        // sectigimiz opsiyonu yazdirin

        /*
            Biz daha once dropdownMenuyu locate etmis ve bu menuyu kullanarak select objesi olusturmustuk
            ANCAK arama yaptirdigimizda HTML kodlar yenilendigi icin eski elementleri BULAMAYABILIR
            Bu durumda "stale element" / bayat element uyarisi verir
            Yapmamiz gereken :
            yeniden obje olusturmak degil var olan objelere ayni degerleri tekrar atamaktir
         */

        dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropdownMenuElementi);

        System.out.println(select.getFirstSelectedOption().getText());

        // sectigimiz opsiyon`un Baby oldugunu test edin
        String expectedOpsiyon = "Baby";
        String actualOpsiyon = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOpsiyon,actualOpsiyon);

        bekle(3);
    }
}
