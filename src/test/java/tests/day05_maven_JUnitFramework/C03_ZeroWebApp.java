package tests.day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebApp {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//i[@class = 'icon-signin']")).click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("username");
        //4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type= 'submit']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin   sp_amount
        driver.findElement(By.id("sp_amount")).sendKeys("5000");
        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        // String actualText = driver.findElement(By.id("alert_content")).getText();
        String actualText = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();
        String exceptedText = "The payment was successfully submitted.";
        System.out.println("Cikan mesaj : " + actualText);
        if (actualText.equals(exceptedText)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
