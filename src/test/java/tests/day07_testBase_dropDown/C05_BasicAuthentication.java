package tests.day07_testBase_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        // Username    : admin
        //  password     : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(2);
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basariliGirisElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(basariliGirisElementi.isDisplayed());
        bekle(2);
    }
}
