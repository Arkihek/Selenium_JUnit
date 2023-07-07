package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Q05{
    // Assertion islemi

    // google adresine gidip title`in google icerdigini kontrol edelim
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");
        String expectedTitle1 = "google";
        String expectedTitle2 = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle1));
        Assert.assertTrue(actualTitle.contains(expectedTitle2));
        driver.close();

    }


}
