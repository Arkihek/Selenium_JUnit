package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q13 extends TestBase {

    @Test
    public void test01() {
        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        bekle(3);


        //3.Web table tum body’sini yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        // System.out.println(tumBody.getText());

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirSayisiList = driver.findElements(By.xpath("//tbody/tr"));
        int actualSayi = satirSayisiList.size();
        int expectedSayi = 9;
        Assert.assertEquals(expectedSayi, actualSayi);

        //5.Tum satirlari yazdirin
        int siraNo = 1;

        for (WebElement eachSatir : satirSayisiList
        ) {
            System.out.println(siraNo + "- " + eachSatir.getText());
            siraNo++;
        }
        //6. Web table’daki 1 satirin sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int actualSutunNo = sutunSayisi.size();
        int expectedSutunNo = 13;

        Assert.assertEquals(expectedSutunNo,actualSutunNo);


        //7. 5.sutunu yazdirin
        System.out.println("=============5 SUTUN==============");
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//tbody/tr[5]/td"));
        siraNo=1;
        for (WebElement eachSutun: besinciSutun
             ) {
            System.out.println(siraNo+"- " + eachSutun.getText());
            siraNo++;
        }
        //8. Satir ve sutun sayisini parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("**********************************");

        System.out.println(bilgiyiGetir(5,3));


    }

    public String bilgiyiGetir(int satirNo, int sutunNo){

        //tbody/tr[   5   ]/td[    1    ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo +"]";

        WebElement istenenHucre = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucre.getText();


    }




}
