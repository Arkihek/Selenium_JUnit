package tests.practice;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q15 {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/tests/practice/ulkeler2.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre); // Başkent (İngilizce)

        // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String actualResult1 = sayfa1.getRow(1).getCell(3).toString();
        String expectedResult1 = "Kabil";

        System.out.println(actualResult1); // Kabil

        Assert.assertEquals(expectedResult1,actualResult1);

        // - Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190 yani index

        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191 fiziki olarak kullanilan satiri buluruz

        // Sayfa 2 icin son satir numarasi ve fiziki olarak kullanilan satir sayisini yazdirin
        Sheet sayfa2 = workbook.getSheet("Sayfa2");
        System.out.println("Son satir indexi : "+sayfa2.getLastRowNum());
        System.out.println("Fiziki olarak kullanilan satir sayisi : "+sayfa2.getPhysicalNumberOfRows());

        // Listede Togo isminde bir ulke oldugunu test edin

        boolean flag = false;
        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiUlkeIsmi.equals("Togo")){
                flag = true;
                System.out.println("Excell`de Togo mevcut. Test PASSED");
                break;
            }
        }
        Assert.assertTrue(flag);

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkeIsimleriMap = new TreeMap<>();
        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {
            String key = sayfa1.getRow(i).getCell(0).toString();
            String value = sayfa1.getRow(i).getCell(1).toString();

            ulkeIsimleriMap.put(key,value);
        }
        System.out.println(ulkeIsimleriMap);

        // Listede Benin isminde bir ulke bulundugunu test edin
        Assert.assertTrue(ulkeIsimleriMap.containsKey("Benin"));

        // Listede Ankara isminde bir baskent bulundugunu test edin
        Assert.assertTrue(ulkeIsimleriMap.containsValue("Ankara"));






    }

}
