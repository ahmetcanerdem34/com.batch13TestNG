package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_AmazonDropDown {
    /*
    ● Bir class oluşturun: C3_DropDownAmazon
    ● https://www.amazon.com/ adresine gidin.
- Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
-Test 2
    1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin

     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void DropdownTesti() {
        driver.get("https://amazon.com");
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        //locate edelim
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement acilirListe= driver.findElement(By.id("searchDropdownBox"));

        //select objesi oluştur
        Select select = new Select(acilirListe);
        List<WebElement> tumOpsiyonlar= select.getOptions();//butun opsiyonları getir diyoruz

        //test etmeden önce
        int expectedOpsiyonSayisi=45;
        int actualOpsiyon=tumOpsiyonlar.size();//tum opsiyonlar listesi. size ile gelir

        //testin bizdeki karşılığı assert
        Assert.assertEquals(actualOpsiyon,expectedOpsiyonSayisi);
        /*
        Expected :45
        Actual   :28
         */


    }
    /*
    -Test 2
    1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin

     */
    @Test
    public void javaKitabiTesti(){
        driver.get("https://amazon.com");
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement acilirListe= driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(acilirListe);
        select.selectByVisibleText("Books");
        //arama ksımına jav ayazdıralım, incelede id si var
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucYazisiElementi.getText().contains("Java"));


    }
}