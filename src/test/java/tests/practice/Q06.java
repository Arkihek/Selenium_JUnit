package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06 {

    //// Kullanici https://www.google.com adresine gider
    //// Çıkıyorsa Kullanici cookies i kabul eder
    //// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    //// Para birimlerinin karsilastirmasini alin
    //// Karsilastirilacak olan para biriminin x den kucuk oldugu test edilir
    //// yorum yapılabilir

    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void paraKarsilastir(){
        driver.get("https://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("usd to tl" + Keys.ENTER);
        WebElement resultElement = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String resultString = resultElement.getText().replaceAll(",",".");
        double actualResult = Double.parseDouble(resultString);
        double expectedResult = 30.4;

        Assert.assertTrue(actualResult<expectedResult);


    }
    @After
    public void tearDown(){
        driver.close();
    }

}
