package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeTest_AfterTest {

    /*
        Bir class`in icinde birden fazla test method`u varsa
        hepsi bagimsiz olarak da calistirilabilsin diye
        her method`a mahserin 4 atlisini eklememiz gerekir

        Ancak bu islem test method`larini gereksiz uzattir.

        Bunun yerine bir setup method`u olusturup
        ilgili ayarlari setup method`unda yapip
        test method`larinda SADECE teste odaklanabiliriz

        Bu yontemde scope`dan kaynaklanan bir sorun olusur

        Eger Webdriver objesini setup method`unda olusturursaniz
        diger test method`larindan kullanamazsiniz.
        Bunun yerine Webdriver`i class level`da olusturup
        setup method`unda sadece deger atamasi yapiyoruz
     */
    WebDriver driver ;

    @Test
    public void amazonTesti() throws InterruptedException {
        // amazon`a gidelim ve url`in amazon icerdigini test edip sayfayi kapatin

        setup();
        driver.get("https://www.amazon.com");
        String expectedUrl = "Ramazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Amazon Url test is PASSED");
        }else {
            System.out.println("Amazon Url test is FAILED");
            throw new RuntimeException();
        }
        System.out.println("Amazon Url : " + actualUrl);

        driver.close();
    }

    @Test
    public void wisequarterTest(){
        // Wise quarter anasayfaya gidip
        // title`in Wise Quarter icerdigini test edin
        // ve sayfayi kapatin

        setup();
        driver.get("https://www.wisequarter.com");
        String actualTitle = driver.getTitle();;
        String exceptedTitle = "Wise Quarter";

        if (actualTitle.contains(exceptedTitle)){
            System.out.println("WiseQuarter Title test is PASSED");
        }else {
            System.out.println("WiseQuarter Title test is FAILED");
            throw new RuntimeException();
        }
        System.out.println("WiseQuarter Title : " + actualTitle);
        driver.close();

    }
    @Test
    public void youtubeTest(){
        // youtube anasayfaya gidin
        setup();
        driver.get("https://www.youtube.com");

        // title`in Youtube oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Youtube title test is PASSED");
        }else {
            System.out.println("Youtube title test is FAILED");
            throw new RuntimeException();
        }
        driver.close();

    }
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
