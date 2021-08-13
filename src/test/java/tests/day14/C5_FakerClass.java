package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C5_FakerClass extends TestBase {
/*
1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
 */
    @Test
    public void facebookFaker(){
    //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
    //2.“create new account” butonuna basin
      driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
    //3.“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu= driver.findElement(By.name("firstname"));
    //4.“surname” giris kutusuna bir soyisim yazin
        //action clasından yapalım, önce actions clsı oluştururuz
        Actions actions=new Actions(driver);
        //faker classı ile yapacagız onuda actıon gibi obje ile yapablilriz
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.
                click(isimKutusu).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("10").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("2021").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ARROW_LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement radio1= driver.findElement(By.xpath("//input[@type='radio'][1]"));
        Assert.assertTrue(radio1.isSelected());
        WebElement radio2= driver.findElement(By.xpath("//input[@type='radio'][2]"));
        Assert.assertFalse(radio2.isSelected());
        WebElement radio3= driver.findElement(By.xpath("//input[@type='radio'][3]"));
        Assert.assertFalse(radio3.isSelected());





    }
}
