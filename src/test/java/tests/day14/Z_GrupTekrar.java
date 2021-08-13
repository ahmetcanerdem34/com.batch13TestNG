package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Z_GrupTekrar extends TestBase {

     /*
1."https://facebook.com" Adresine gidin
2."create new account" butonuna basin
3."firstName" giris kutusuna bir isim yazin
4."surname" giris kutusuna bir soyisim yazin
5."email" giris kutusuna bir email yazin
6."email" onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
         */

    @Test
    public void faker(){
        //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2."create new account" butonuna basin
        WebElement button= driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        button.click();

        //3."firstName" giris kutusuna bir isim yazin
        Actions actions=new Actions(driver);
        WebElement firstName=driver.findElement(By.name("firstname"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();//internetle alakalı durumları internet methodundan
        actions.click(firstName).
                sendKeys(faker.name().name()).//name-->name sınıdfından geliyor
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).//internetle alakalı durumları internet methodundan
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1994").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).
                sendKeys(Keys.ARROW_RIGHT).
                perform();

        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement radio1=driver.findElement(By.xpath(("(//input[@class='_8esa'])[1]")));
        Assert.assertTrue(radio1.isSelected());
        WebElement radio2=driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        Assert.assertFalse(radio2.isSelected());
        WebElement radio3=driver.findElement(By.xpath(("(//input[@class='_8esa'])[3]")));
        Assert.assertFalse(radio3.isSelected());
//13.Sayfayi kapatin

        driver.close();

    }

}
