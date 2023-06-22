package tests.day08_IFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseQuit;

import java.util.Set;

public class C04_SwitchingWindow extends TestBaseQuit {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD = driver.getWindowHandle();
        System.out.println(ilkSayfaWHD);

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            KONTROLUMUZ disinda yeni bir tab veya window acilinca
            driver otomatik olarak oraya gecmez

            Yeni sayfaya gecebilmek icin ikinci sayfanin Window Handle degerini bulmaliyiz
            Bunun icin:

            1- ilk sayfada iken ilkSayfaWHD`ini kaydedelim
            2- yeni sayfayi acan linki tiklayalim
            3- ilk ve ikinci sayfanin window handle degerlerini bir set olarak kaydedelim
               Set<String> wHDSeti = driver.getWindowHandles();
            4- Bir for-each loop ile set`deki window handle degerlerini
               ilk sayfanin window handle degeri ile karsilastiralim
               ilkSayfaWHD`ne esit OLMAYAN window handle degerini
               ikinciSayfaWHD olarak kaydedelim
            5- Buldugumuz ikinciSayfaWHD`ini kullanarak 2. sayfaya gecelim
         */
        Set<String> wHDSeti = driver.getWindowHandles();
        System.out.println(wHDSeti);

        String ikinciSayfaWHD="";

        for (String eachWHD:wHDSeti
             ) {
            if (!(eachWHD.equals(ilkSayfaWHD)))
                ikinciSayfaWHD = eachWHD;
        }

        driver.switchTo().window(ikinciSayfaWHD);
        String expectedTitleNewPage = "New Window";
        String actualTitleNewPage = driver.getTitle();

        Assert.assertEquals(expectedTitleNewPage,actualTitleNewPage);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedTextNewWindow = "New Window";
        String actualTextNewWindow = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedTextNewWindow,actualTextNewWindow);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
