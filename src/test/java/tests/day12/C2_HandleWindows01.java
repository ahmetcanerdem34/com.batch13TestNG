package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C2_HandleWindows01 extends TestBase {


    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        // Elemental Selenium yazisina tiklayalim
        // acilan windows'da Sponsored by Sauce Labs yazisi locate edip yazdirin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // ben click yapmadan var olan window'un handle'ni alsam
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // click yaptiktan sonra tum handle degerlerini alsam
        Set<String> handleListesi = driver.getWindowHandles();
        // elimizde icinde 2 handle degeri bulunan bir set var
        // Bunlardan biri ilk sayfanin handle degeri
        // ikinci sayfanin handle degerini nasil bulabilirim
        String ikinciSayfaHandleDegeri="";
        for (String each: handleListesi
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        //2. sayfanın handle ı var artık elimizde, yapacağımız şey swict to ile ona geçmek

        driver.switchTo().window(ikinciSayfaHandleDegeri);//windovun içerisine 32. windowun değerini yazmak

        //şimdi yazdırdı Sauce Labs

        WebElement souceLabYazisiElementi=driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(souceLabYazisiElementi.getText());//Sauce Labs
    }
}