package tests.day07_testBase_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C07_DropDown_Handle extends TestBase {

    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("5000");
        //10. “US Dollars” in secilmedigini test edin
        WebElement radioButton1 = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radioButton1.isSelected());
        //11. “Selected currency” butonunu secin
        WebElement radioButton2 = driver.findElement(By.id("pc_inDollars_false"));
        radioButton2.click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String actualYazi = driver.findElement(By.id("alert_content")).getText();
        String expectedYazi = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
