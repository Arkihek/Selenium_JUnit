package tests.day10_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()

    @Test
    public void implicitlyWaitTest() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement messageElement = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(messageElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement messageElementIki = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(messageElementIki.isDisplayed());
        driver.close();
    }

    @Test
    public void explicitlyWaitTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //  Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        /*
            visibilityOf() method`u bize 2 secenek sunuyor
            - Eger webElement`i locate edebiliyorsak, once locate edip
              sonra o elemnti isntenen condition icin beklemesini isteyebiliriz
            - Eger kullanacagimiz elementi locate EDEMIYORSAK
              o zaman locate islemi ile bekleme islemini birlikte yapabiliriz.
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        WebElement messageElement = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(messageElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        WebElement messageElementIki = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(messageElementIki.isDisplayed());
        driver.close();
    }
}
