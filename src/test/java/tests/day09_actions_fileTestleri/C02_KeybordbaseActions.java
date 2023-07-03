package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeybordbaseActions extends TestBase {

    @Test
    public void test01(){
        /*
            Her ne kadar klavyede pek cok tus olsa da
            bir tus icin yapilabilecek 3 temel islev var
            1- tek seferlik basmak sendkeys(Keys.ENTER)
            2- bazen belirli bir sure icin bir tusu basili tutmak isteriz keyDown()
            3- basili tuttugumuz tusu serbest birakmak isteriz keyUp()
         */

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);

        actions.click(searchBoxElement).keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71").sendKeys(Keys.ENTER).perform();
        bekle(3);

        //4- aramanin gerceklestigini test edin
        String expectedIcerik = "Samsung A71";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualIcerik = sonucYazisiElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
}
