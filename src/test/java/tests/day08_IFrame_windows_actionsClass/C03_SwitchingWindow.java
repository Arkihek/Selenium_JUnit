package tests.day08_IFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {

    @Test
    public void test02(){
        driver.get("https://www.amazon.com");
        String wHDAmazon = driver.getWindowHandle();
        bekle(2);

        // yeni bir tab olarak wise quarter`a gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String wHDWise = driver.getWindowHandle();
        bekle(2);

        // yeni bir sayfa olarak youtube`a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String wHDYoutube = driver.getWindowHandle();
        bekle(2);

        // amazon`un acik oludugu sayfaya donun ve url`in amazon icerdigini test edin
        driver.switchTo().window(wHDAmazon);
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        bekle(2);

        // wisequatre`in acik oldugu sayfaya gidin ve title`in wise icerdigini test edin
        driver.switchTo().window(wHDWise);
        String expectedTitleIcerik = "Wise";
        String actualTitleIcerik = driver.getTitle();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        bekle(2);

        // youtube`un acik oldugu sayfaya gidin ve url`in youtube icerdigini test edin
        driver.switchTo().window(wHDYoutube);
        String expectedUrlYoutube = "youtube";
        String actualUrlYoutube = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        bekle(2);

    }
}
