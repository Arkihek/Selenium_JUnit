package tests.day08_IFrame_windows_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseQuit;

import java.util.List;

public class C07_IFrame extends TestBaseQuit {


    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        int iFrameCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println(iFrameCount);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        List<WebElement> iFrameListElementi = driver.findElements(By.tagName("iframe"));
        System.out.println(iFrameListElementi);
        WebElement firstIFrameElement = iFrameListElementi.get(0);
        driver.switchTo().frame(firstIFrameElement);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        bekle(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement secondIFrameElement = iFrameListElementi.get(1);
        driver.switchTo().frame(secondIFrameElement);
        WebElement linkElementi = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        linkElementi.click();
        bekle(3);


    }

}
