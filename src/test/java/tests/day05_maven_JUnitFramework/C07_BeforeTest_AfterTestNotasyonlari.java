package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeTest_AfterTestNotasyonlari {
    /*
        JUnit ile class`daki her test method`u calismaya baslamadan once
        calismasini istedigimiz method`lari
        @Before,
        her test method`undan sonra calismasini istedigimiz method`lari ise
        @After notasyonu ile isaretleriz

        Boylece test method`u calismaya baslarken
        ekstradan methodCall yapmaya gerek olmadan
        @Before Notasyonuna sahip method calisir

        test method`u bitince de hic bir method Call olmaksizin
        @After notasyonuna sahip method calisir

        Bu class, class level`dan calistirildiginda
        class`daki method`lar toplam kac kere calismis oldu?

        @Before
        amazon
        @After
        @Before
        wisequarter
        @After
        @Before
        youtube
        @After

        sadece youtube test method`unu calistirmak istersek
        @Before
        youtube
        @After
     */
    WebDriver driver ;

    @Test
    public void amazonTesti() throws InterruptedException {
        // amazon`a gidelim ve url`in amazon icerdigini test edip sayfayi kapatin

        driver.get("https://www.amazon.com");
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Amazon Url test is PASSED");
        }else {
            System.out.println("Amazon Url test is FAILED");
            throw new RuntimeException();
        }
        System.out.println("Amazon Url : " + actualUrl);

    }

    @Test
    public void wisequarterTest(){
        // Wise quarter anasayfaya gidip
        // title`in Wise Quarter icerdigini test edin
        // ve sayfayi kapatin

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

    }
    @Test
    public void youtubeTest(){
        // youtube anasayfaya gidin

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

    }
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
}
