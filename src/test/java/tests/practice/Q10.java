package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q10 {


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
    @Test @Ignore
    public void test01() throws InterruptedException {
        ///* 1. Test
        //    -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //    - 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);

        //    -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert = "I am a JS Alert";

        Assert.assertEquals(expectedAlert,actualAlert);

        //    -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        WebElement actualResultElement = driver.findElement(By.id("result"));
        Assert.assertTrue(actualResultElement.isDisplayed());

        // */
    }

    @Test @Ignore
    public void test02(){
        //2.Test
        //    - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //    - 2.alert'e tiklayalim
        //    - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String expectedAlert = "You clicked: Cancel";
        String actualAlert = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedAlert,actualAlert);

    }

    @Test
    public void test03() throws InterruptedException {

        //   3.Test
        //       - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        //       - 3.alert'e tiklayalim
        //       - Cikan prompt ekranina "Abdullah" yazdiralim
        //       - OK tusuna basarak alert'i kapatalim
        //       - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        //
        //*/

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Ihsan");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String expectedAlert = "You entered: Ihsan";
        String actualAlert = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedAlert,actualAlert);
    }


}
