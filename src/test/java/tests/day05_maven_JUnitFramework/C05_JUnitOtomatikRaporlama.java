package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_JUnitOtomatikRaporlama {

    /*
        JUnit framework`unde
        bir class veya test method`u calistirildiginda
        JUnit tum class veya istenen method`un
        sorunsuz olarak sonuna kadar calisip calismadigini kontrol eder

            - Sorunsuz calisirsa test PASSED
            - Kodlar sorun ciktigi icin calistirilamazsa test FAILED
        olarak isaretlenir

        Eger if-else ile yaptigimiz testlerde
        JUnit`in raporlarinin da test sonuclari ile uyumlu olmasini isterseniz
        FAILED durumlarinda throw keyword ile herhangi bir exception olusturtabiliriz
     */

    @Test // Artik main methoda ihtiyacimiz yok JUnit sayesinde
    public void amazonTesti() throws InterruptedException {
        // amazon`a gidelim ve url`in amazon icerdigini test edip sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
            throw new RuntimeException();
        }
        System.out.println("WiseQuarter Title : " + actualTitle);
        driver.close();


    }
}
