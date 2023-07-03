package tests.day09_actions_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Faker extends TestBase {
    @Test
    public void test01(){
        /*
            Faker kutuphanesi. testlerimizi yazarken ihtiyac duyabilecegimiz
            isim, soyisim, email, password, usarname ...
            gibi bilgileri fake olarak kullanabilmemizi saglar
         */

        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().avatar());

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        String email = faker.internet().emailAddress();

        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
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

    }
}
