package tests.day07_testBase_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_DropDownAmazon extends TestBase {




    @Test
    public void test01(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        //oldugunu test edin
        WebElement aramaKutusuElementi = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(aramaKutusuElementi);
        int aramaKutusuSayisi = select.getOptions().size();
        int actualAramaKutusuSayisi = 28;

        Assert.assertEquals(aramaKutusuSayisi,actualAramaKutusuSayisi);
    }
    @Test
    public void test02(){
        driver.get("https://www.amazon.com/");
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        String actualWord = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(actualWord);
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedWord = "Java";

        Assert.assertTrue(actualWord.contains(expectedWord));
    }

}
