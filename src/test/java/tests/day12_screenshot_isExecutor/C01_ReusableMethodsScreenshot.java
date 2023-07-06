package tests.day12_screenshot_isExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_ReusableMethodsScreenshot extends TestBase {
    @Test
    public void test01(){

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // url`in wise icerdigini test edin
        String expectedUrl = "wise";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tum sayfa screenshot alin
        ReusableMethods.screenshot(driver);
    }
}
