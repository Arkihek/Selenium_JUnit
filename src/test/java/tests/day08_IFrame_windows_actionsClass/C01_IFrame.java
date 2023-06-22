package tests.day08_IFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement textElement = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(textElement.isEnabled());
        System.out.println(textElement.getText());
        // - Text Box’a “Merhaba Dunya!” yazin.

        /*
            Textbox elementi gozumunuzun onunde olmasina
            ve rahatca locate edilebilmesine ragmen direk kullanilamiyor.

            HTML kodlarini inceleyince
            textbox`in bir iFrame icerisinde oldugunu gorduk
            textbox`i kullanmadan once iFrame`e gecis yapmaliyiz
         */

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElement = driver.findElement(By.tagName("p"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");
        bekle(3);
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.

        /*
            Bir iFrame`e gecis yapildiysa
            normal sayfada islem yapilamaz
            normal sayfada islem yapmak isterseniz
            iFrame`den cikmaniz gerekir

            defaultContent() : anasayfaya cikar
            parentFrame() : eger ic ice iFrame`ler varsa, bir ust iFrame`e cikar
         */
        driver.switchTo().defaultContent();

        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi);

        elementalSeleniumElementi.click();
    }
}
