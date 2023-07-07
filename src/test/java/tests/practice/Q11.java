package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q11 {

    @Test
    public void implicitWaitMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement messageElement = driver.findElement(By.id("message"));
        Assert.assertTrue(messageElement.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement messageElement2 = driver.findElement(By.id("message"));
        Assert.assertTrue(messageElement2.isDisplayed());

        driver.close();
    }

    @Test
    public void explicitWaitMethod(){
        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        // 4. Remove butonuna basin.
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // 6. Add buttonuna basin
        // 7. It’s back mesajinin gorundugunu test edin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement messageElement = driver.findElement(By.id("message"));
        Assert.assertTrue(messageElement.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement messageElement2 = driver.findElement(By.id("message"));
        Assert.assertTrue(messageElement2.isDisplayed());

        driver.close();


    }

}
