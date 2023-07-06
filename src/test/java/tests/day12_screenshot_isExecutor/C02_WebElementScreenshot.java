package tests.day12_screenshot_isExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_WebElementScreenshot extends TestBase {

    @Test
    public void test01(){
        // google gidelim
        driver.get("https://www.google.com");

        // cikiyorsa cookies kabul edin

        // Nutella aratalim
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella" + Keys.ENTER);

        // arama sonuc sayisinin screenshot`ini alalim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        bekle(2);
        ReusableMethods.webElementFotoCek(driver,aramaSonucElementi);

        bekle(3);
    }

}
