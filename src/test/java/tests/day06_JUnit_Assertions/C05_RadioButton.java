package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //     https://facebook.com
        driver.get("https://facebook.com");
        // b. Cookies’i kabul edin
        // Cookies cikmadi
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement radioButton1 = driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        WebElement radioButton2 = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        WebElement radioButton3 = driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));
        radioButton2.click();
        Thread.sleep(2000);
        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        System.out.println(radioButton1.isSelected());
        System.out.println(radioButton2.isSelected());
        System.out.println(radioButton3.isSelected());
        if (radioButton2.isSelected() && !(radioButton1.isSelected()) && !(radioButton3.isSelected())){
            System.out.println("Radio Button test is PASSED");
        }else {
            System.out.println("Radio Button test is FAILED");
        }

    }
}
