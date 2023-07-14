package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;
import utilities.TestBaseQuit;

import java.time.Duration;

public class Q18 extends TestBaseQuit {
    /*
        1- Gerekli ayarlamalari yapin
        2- google.com adresine gidin
        3- Google title`in Google icerdigini test edin
        4- Yeni bir pencerede wisequarter sayfasina gidelim
        5- wisequarter sayfasinin title`nin wise icerdigini test edin
     */

    @Test
    public void test01(){

        driver.get("https://www.google.com");
        String expectedIcerik = "Google";
        String actualIcerik = driver.getTitle();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        String ilkWindowHandle = driver.getWindowHandle();
        System.out.println("Ilk sayfanin acildigi handle degeri : " + ilkWindowHandle);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.wisequarter.com");
        String ikinciWindowHandle = driver.getWindowHandle();
        System.out.println("Ikinci sayfanin acildigi handle degeri : " + ikinciWindowHandle);
        String expectedIcerik2 = "Wise";
        String actualIcerik2 = driver.getTitle();
        Assert.assertTrue(actualIcerik2.contains(expectedIcerik2));

        driver.switchTo().window(ilkWindowHandle);
        driver.get("https://www.amazon.com");
        String expectedIcerik3 = "Amazon";
        String actualIcerik3 = driver.getTitle();
        Assert.assertTrue(actualIcerik3.contains(expectedIcerik3));
        String ucuncuWindowHandle = driver.getWindowHandle();
        System.out.println("Ucuncu sayfanin acildigi handle degeri : " + ucuncuWindowHandle);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedIcerik4 = "Amazon";
        String actualIcerik4 = driver.getTitle();
        Assert.assertFalse(actualIcerik4.contains(expectedIcerik4));

        bekle(3);

    }

}
