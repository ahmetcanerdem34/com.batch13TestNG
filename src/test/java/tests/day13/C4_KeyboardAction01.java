package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C4_KeyboardAction01 extends TestBase {

    /*
    1- Bir Class olusturalim D14_KeyboardActions1
    2- https://www.amazon.com sayfasina gidelim
    3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    4- aramanın basarili olup olmadigini test edin
     */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions=new Actions(driver);

        actions.click(aramaKutusu).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).//şifte bastık
                sendKeys("a").//sifte basılı olduğu için a yı A buyuk yazacak
                keyUp(Keys.SHIFT).//şiften elimizi kaldırdık
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();

        // 4- aramanın basarili olup olmadigini test edin
        //title dan url den olabilir
        String actualTitle=driver.getTitle();
        String arananKelime="samsung A71";
        Assert.assertTrue(actualTitle.contains(arananKelime));


    }
}
