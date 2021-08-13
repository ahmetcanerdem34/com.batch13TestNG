package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_Allerts {

    //sayfa içinde sayfaya girmem meselesi swich to ile

    /*
    - JS Alert'unun 3 cesidi vardir.
        Alert sayfada acildiginda inceleme yapilamaz ve biz alert'u handle edene kadar bekler.
        1) Sadece "Tamam" secenegine tiklanabilen.
        2) JS Alert'unde "Tamam" veya "Iptal" butonu cikan.
        Tamam'a tiklarsak arkada baska bir kod calisir.
        Iptal'e basarsak bambaska bir kod calisir.
        3) Icerisine yazi yazilan bir kutucuk ile alert veren.
        Burada iptal'e basarsak null deger gonderir ve o calisir, uyari verebilir bos girilemeyecegine dair.
        Eger yazi kutucuguna deger girersek girdigimiz degere gore kodu yapilandirir.
     */
    /*
            ● Bir class olusturun: D12_Alerts
        ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        ● Bir metod olusturun: acceptAlert
         ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
         “You successfully clicked an alert” oldugunu test edin.
        ● Bir metod olusturun: dismissAlert
         ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
         “successfuly” icermedigini test edin.
        ● Bir metod olusturun: sendKeysAlert
         ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
         OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //bir defalık buraya yazalım
        //1-● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlert() {

       /*
         ● Bir metod olusturun: acceptAlert
         ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
         “You successfuly clicked an alert” oldugunu test edin.

        */
        driver.findElement(By.xpath("(//button[@onclick='jsAlert()'])[1]")).click();

        driver.switchTo().alert().accept();//accept yapınca sayfadaki ok tıklar
        //ekranda bu yazı çıkar You successfully clicked an alert

        WebElement sonucYazisiWebElement= driver.findElement(By.cssSelector("#result"));
        String expextedResulYazisi="You successfully clicked an alert";
        String actualResulYazisi=sonucYazisiWebElement.getText();

        //Bu durlarda hard assert kullanamk dah önemli
        Assert.assertEquals(actualResulYazisi, expextedResulYazisi);
        Assert.assertTrue(actualResulYazisi.equals(expextedResulYazisi));



    }
    @Test
    public void dismissAlert(){

        // ● Bir metod olusturun: dismissAlert
        //         ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //         “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();//cansel yani dismis e tıkla

        WebElement sonucYazisiWebElement= driver.findElement(By.cssSelector("#result"));
        String unexpextedYazi="successfuly";
        String actualResultYazisi=sonucYazisiWebElement.getText();
       // ve result mesajı “successfuly” icermedigini test edin.
        Assert.assertFalse(actualResultYazisi.contains(unexpextedYazi));
    }
    @Test
/*
● Bir metod olusturun: sendKeysAlert
         ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */
    public void sendKeysAlert() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String isim="Muharrem";
        driver.switchTo().alert().sendKeys(isim);
        driver.switchTo().alert().accept();


        WebElement sonucYazisiWebElement= driver.findElement(By.cssSelector("#result"));
        String actualResulYazisi = sonucYazisiWebElement.getText();
        String expextedReustYazisi="Muharrem";
        Assert.assertTrue(actualResulYazisi.contains(expextedReustYazisi));

    }
    }
