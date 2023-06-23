package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {
    //BeforeClass ile driver'i oluşturun ve class icinde static yapin
    //Maximize edin ve 10 sn bekletin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

  @Before
  public void test01(){
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));

  }

  @After
  public void after(){

  }
    //http://www.google.com adresine gidin
    //1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
    //2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
    //3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin


    //AfterClass ile kapatin.
    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
