package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q09 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        ////https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");
        ////Ülke menüsünü locate edin
        WebElement dropDownMenu = driver.findElement(By.className("a-dropdown-prompt"));
        dropDownMenu.click();

        ////Türkiye Seçeneğini seçin
        driver.findElement(By.xpath("//*[@id='icp-dropdown-item-18']")).click();
        Thread.sleep(3000);

        ////Go to website butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='icp-save-button']")).click();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

}
