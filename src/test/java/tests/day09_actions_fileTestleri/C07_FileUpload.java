package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {

    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim

        /*
            Eger chooseFile butonuna basarsak
            bilgisayarimizin klasor yapisi acilir
            oradan dosya secmek icin mouse`u kullanamayacagimizdan
            bu yontemle dosya upload mumkun degildir

            Bunun yerine selenium`un bize sundugu cozumu kullaniyoruz
            chooseFile butonuna sendKeys ile
            yuklemek istedigimiz dosyanin dosyaYolunu gonderiyoruz
         */

        //3.Masaustune kopyaladigimiz avatar.png dosyayi secelim.
        WebElement chooseFileElement = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.home") + "/OneDrive/Masaüstü/avatar.png";

        chooseFileElement.sendKeys(dinamikDosyaYolu);
        bekle(10);

        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(5);

        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement actualResultElement = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(actualResultElement.isDisplayed());

    }
}
