package tests.day10_waits_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
    @Test
    public void test01() {
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        int siraNo = 1;
        for (WebElement eachHeader : headerElementList
        ) {
            System.out.println(siraNo + "- " + eachHeader.getText());
            siraNo++;
        }
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3. Sutun basligi : " + headerElementList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> dataElementList = driver.findElements(By.xpath("//div[@role='gridcell']"));
        siraNo = 1;
        for (WebElement eachData : dataElementList
        ) {
            if (!eachData.getText().isBlank()) {
                System.out.println(siraNo + "- " + eachData.getText());
                siraNo++;
            }
        }

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Listede bos olmayan hucre sayisi : " + (siraNo - 1));

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Satir sayisi : " + satirlarList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + headerElementList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("============3. SUTUN ELEMENTLERI==============");
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("//div[@role='gridcell'][3]"));
        for (WebElement eachList : ucuncuSutunElementleri
        ) {
            if (!eachList.getText().isBlank()) {
                System.out.println(eachList.getText());
            }

        }

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("============ Kierra`nin maasi ====================");
        WebElement isimElementi;
        WebElement maasElementi;

        for (int i = 2; i <= satirlarList.size(); i++) {

            isimElementi = driver.findElement(By.xpath("(//div[@role='row'])[" + i + "]/div[@role='gridcell'][1]"));
            maasElementi = driver.findElement(By.xpath("(//div[@role='row'])[" + i + "]/div[@role='gridcell'][5]"));

            if (isimElementi.getText().equals("Kierra")) {
                System.out.println(maasElementi.getText());
            }
        }

        //  10. bir method olusturun, satir ve sutun sayisini girdigimde bana datayi yazdirsin
        hucreBilgisiYazdir(3,5);
    }

    public void hucreBilgisiYazdir(int satirNo,int sutunNo){
        WebElement hucreElementi = driver.findElement(By.xpath("(//div[@role='row'])[" + satirNo + "]/div[@role='gridcell']["+sutunNo+"]"));
        System.out.println(hucreElementi.getText());
    }


}
