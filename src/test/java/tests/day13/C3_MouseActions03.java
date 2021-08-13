package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C3_MouseActions03 extends TestBase {

    /*
    Yeni bir class olusturalim: D15_MouseActions4
    1- https://www.facebook.com adresine gidelim
    2- yeni hesap oluştru butonuna basalım
    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    4- Kaydol tusuna basalim
     */

    @Test
    public void test01() {
        driver.get("https://www.facebook.com ");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        WebElement isimKutusu=driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);


        /*
        actions.click(isimKutusu).perform();
        actions.sendKeys("Mehmet").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Bulut").perform();
        actions.sendKeys(Keys.TAB).perform();
        */
        //bu şekildde de yazılabilir

        actions.click(isimKutusu).
                sendKeys("Konrolsüz").
                sendKeys(Keys.TAB).
                sendKeys("Güç").
                sendKeys(Keys.TAB).
                sendKeys("kontrolayagı89@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("12345").
                perform();







    }



    }

