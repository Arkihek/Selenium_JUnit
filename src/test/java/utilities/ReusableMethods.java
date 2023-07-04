package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ReusableMethods {

    public static String ikinciSayfaWHD(String ilkSayfaWindowHandleDegeri, WebDriver driver){

        String ikinciSayfaWHD = "";

        Set<String> windowHandleSeti = driver.getWindowHandles();

        for (String each : windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWHD = each;
            }
        }

        return ikinciSayfaWHD;
    }

    public static String hucredekiYaziyiGetir(int satirNo, int sutunNo,WebDriver driver){

        //                                  tbody/tr[   5   ]/td[    1    ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucredekiElement.getText();
    }
}
