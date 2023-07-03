package tests.day09_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeybordbaseActions extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        actions.click(firstName)
                .sendKeys("Ihsan")
                .sendKeys(Keys.TAB)
                .sendKeys("Yilmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("yilmzihsn@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("yilmzihsn@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234qwerRR.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("9")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();

        bekle(5);

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        bekle(5);
    }
}
