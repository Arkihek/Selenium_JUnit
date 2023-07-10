package tests.practice;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Q14 {

    // Eger excel dosyasi, proje icerisinde degil de
    // masaustu, downloads gibi baska bir klasorun icinde ise
    // dosya yolu dinamik hale getirilebilir

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/tests/practice/ulkeler2.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

          /*
            olusturdugumuz workbook bizim excelimizi canli olarak kullanmaz
            23. satir calistiginda
            fis`deki yani verdigimiz dosyaYolun`da olan excel`deki
            tum bilgileri alip bu class`da olustudugumuz
            workbook objesine yukler.

            YANI workbook objesi excel`deki bilgilerin bir kopyasina sahip olur

            workbook`da bir degisiklik yaparsak
            ana excell degismez.
            Eger ana excell`in de degismesini istiyorsak
            islem bittikten sonra
            yani class`in en sonunda
            workbook`daki yeni hali excel`e kaydetmemiz gerekir.
         */

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(3);

        System.out.println(cell);

        // Excell`de satir ve sutun numaralari index numarasi kullanir
        // yani 0`dan baslar

        // 12. satirda bulunan Azerbaycan`in ingilizce baskent isminin Baku oldugunu test edin

        Row onikinciSatir = sheet.getRow(11);
        Cell baskent = onikinciSatir.getCell(1);

        String expectedBaskent = "Baku";
        String actualBaskent = baskent.toString();

        System.out.println(baskent);

        Assert.assertEquals(expectedBaskent,actualBaskent);







    }
}
