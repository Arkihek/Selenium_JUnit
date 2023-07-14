package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q19 extends TestBase {
    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement sayfadakiYazi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfadakiYazi.isDisplayed());
        System.out.println(sayfadakiYazi.getText());

        //iframe olan sayfada iframe içindeki herhangi bir şeyi test edebilmek için
        //önce iframe çerçevesine girmek(geçmek) gerekir.

        WebElement iframeCercevesi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeCercevesi);  //Iframe çerçevesine geçiş yapıyoruz

        WebElement iframeYazisi= driver.findElement(By.id("tinymce"));
        String iframedekiYazi=iframeYazisi.getText();
        System.out.println(iframedekiYazi);
        iframeYazisi.clear();
        iframeYazisi.sendKeys("have a wise day");
    }
}
