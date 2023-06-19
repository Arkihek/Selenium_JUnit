package tests.day05_maven_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        /*
            Selenium 4.7.0 ile Selenium kendi Webdriver`ini olusturma
            ve kullanabilme imkani verdi

            Tum sirketler Selenium Webdriver`i kullanmayabilir
            Sirketlerde eskiden beri kullanilan bir WebDriver varsa
            onu projemize eklememiz ve kullanmamiz istenebilir

            Boyle bir durumda istenen Webdriver`i da
            pom.xml`e eklememiz gerekir
            pom.xml`e ekledikten sonra her class`da
            Webdriver objesi olusturmadan once
            yukledigimiz Webdriver ile ilgili setup`i calistirmaliyiz
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
        Thread.sleep(2);
        driver.close();
    }
}
