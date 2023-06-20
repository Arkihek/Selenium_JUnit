package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        // a. Verilen web sayfasına gidin.
        //     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkbox1Element.isSelected()) {
            checkbox1Element.click();
        }
        Thread.sleep(3000);

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2Element.isSelected()) {
            checkbox2Element.click();
        }
        Thread.sleep(3000);
        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkbox1Element.isSelected());
        Assert.assertTrue(checkbox2Element.isSelected());

    }
}
