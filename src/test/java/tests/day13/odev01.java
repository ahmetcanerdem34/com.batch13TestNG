package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class odev01 extends TestBase {
    /*

    1."http://webdriveruniversity.com/" adresine gidin
    2."Login Portal" a kadar asagi inin
    3."Login Portal" a tiklayin
    4.Diger window'a gecin
    5."username" ve "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    8.Ok diyerek Popup'i kapatin
    9.Ilk sayfaya geri donun
    10.Ilk sayfaya donuldugunu test
     */


    @Test
    public void test01(){
        //  1."http://webdriveruniversity.com/" adresine gidin
        //driver.get("http://webdriveruniversity.com/");
        driver.navigate().to("http://webdriveruniversity.com/");

        // 2."Login Portal" a kadar asagi inin --->inin diyorsa action vardır
        Actions actions= new Actions(driver);//action objemizi oluşturduk
        actions.sendKeys(Keys.PAGE_DOWN).perform();//bir kez inmek yeterli oldu
        //1. sayfanın handle ını alalım
        String ilkSayfa= driver.getWindowHandle();

        // 4.Diger window'a gecin
        driver.findElement(By.id("login-portal")).click();

        Set<String> liste=driver.getWindowHandles();//getindowHandlse set le çalışır
        // Stringlerden oluşan elimizde bir liste var onun için set açtık

        String ikinciSayfaHandles="";//hiçliğe eşitliyoruz

        for (String each: liste) {//neden for each hangisinin geleceğini bilmiyoruz, eşit değilse diyoruz
            if(!each.equals(ilkSayfa)){
                ikinciSayfaHandles=each;
            }
        }
    driver.switchTo().window(ikinciSayfaHandles);

        //  5."username" ve "password" kutularina degerlerini yazdirin
        WebElement loginButton = driver.findElement(By.id("text"));
        actions.sendKeys(loginButton,"username").
                sendKeys(Keys.TAB).
                sendKeys("password").
                sendKeys(Keys.TAB). // "login" butonuna basma isini burda yaptik
                sendKeys(Keys.ENTER).
                perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        //alerte geçmeliyiz
        String actualYazi=driver.switchTo().alert().getText();
        String expectedYazi="validation failed";
        Assert.assertEquals(expectedYazi, actualYazi);
        driver.switchTo().alert().accept();//alerti kapattık

        driver.switchTo().window(ilkSayfa);

        //   10.Ilk sayfaya donuldugunu test
        //url ile bakabiliriz
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

        /*
        BİRDEN FAZLA TAB OLURSA
        Set<String> allWindowHandle = Driver.getDriver().getWindowHandles();
       List<String> windowsHandles = new ArrayList<>(allWindowHandle);
       Driver.getDriver().switchTo().window(windowsHandles.get(2));-->burdaki sayıtab sayısı paranteze göre değişir
       String pageTitle = Driver.getDriver().getTitle();
Driver.getDriver().quit();
         */

    }



}
