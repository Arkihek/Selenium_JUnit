package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnitTestNotasyonu {

    /*
        JUnit`in bize kazandirdigi en onemli yeniliklerden biri
        @Test notasyonudur.

        NOTASYON (annotation) : kucuk bilgiler (meta data) barindiran yapilardir.
                                sadece bir yazi yada gosterim degillerdir
                                yaptiklari islemler vardir.

        @Test notasyonu siradan bir method`u
        tek basina calistirilabilir bir test method`una donusturur.

        JUnit ile test method`lari istersek tek basina
        istersek de class level`dan calistirilip
        tum testlerin birlikte calisabilecegi bir yapiya donusur.

        JUnit class icerisindeki test method`larini
        belirsiz bir sirada calistirir.
        Test method`larinin hangi sira ile calisacagini
        ONGOREMEYIZ ve DUZENLEYEMEYIZ
     */

    // Bir class`da 3 farkli test olsa
    // ve ben testleri istersem toplu, istersem bagimsiz olarak calistirabilsem

    @Test // Artik main methoda ihtiyacimiz yok JUnit sayesinde
    public void amazonTesti() throws InterruptedException {
        // amazon`a gidelim ve url`in amazon icerdigini test edip sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Amazon Url test is PASSED");
        }else {
            System.out.println("Amazon Url test is FAILED");
        }
        System.out.println("Amazon Url : " + actualUrl);

        driver.close();
    }

    @Test
    public void wisequarterTest(){
        // Wise quarter anasayfaya gidip
        // title`in Wise Quarter icerdigini test edin
        // ve sayfayi kapatin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");
        String actualTitle = driver.getTitle();;
        String exceptedTitle = "Wise Quarter";

        if (actualTitle.contains(exceptedTitle)){
            System.out.println("WiseQuarter Title test is PASSED");
        }else {
            System.out.println("WiseQuarter Title test is FAILED");
        }
        System.out.println("WiseQuarter Title : " + actualTitle);
        driver.close();


    }

}
