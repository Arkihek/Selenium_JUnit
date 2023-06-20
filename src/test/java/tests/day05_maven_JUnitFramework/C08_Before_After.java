package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Before_After {

    @Test
    public void test01() {
        //1. “https://www.saucedemo.com Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrun = driver.findElement(By.id("item_4_title_link")).getText();
        driver.findElement(By.id("item_4_title_link")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String actualUrun = driver.findElement(By.id("item_4_title_link")).getText();
        if (actualUrun.equals(ilkUrun)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        //9. Sayfayi kapatin

    }

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        driver.close();
    }

}
