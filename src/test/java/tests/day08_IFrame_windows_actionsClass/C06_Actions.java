package tests.day08_IFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseQuit;

public class C06_Actions extends TestBaseQuit {

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeButtonElement = driver.findElement(By.id("draggable"));
        WebElement dropHereElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeButtonElement,dropHereElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualText = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedText = "Dropped!";

        Assert.assertEquals(expectedText,actualText);
    }

}
