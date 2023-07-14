package tests.practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q21 extends TestBase {

    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseButton= driver.findElement(By.id("file-upload"));
        String dosyaYolu="C:\\Users\\ihsan\\IdeaProjects\\team116_JUnit\\src\\test\\java\\tests\\practice\\image_2023_07_12T18_07_43_939Z.png";

        chooseButton.sendKeys(dosyaYolu);
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        bekle(2);
        WebElement UploadedYazisi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(UploadedYazisi.isDisplayed());
        bekle(2);
    }

}
