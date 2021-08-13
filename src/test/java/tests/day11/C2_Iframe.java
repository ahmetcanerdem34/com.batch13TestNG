package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_Iframe {

    /*
        ● Bir class olusturun: D12_IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium”
     linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
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
        driver.close();
    }

    @Test
    public void ıframeTest() {

        //iframe sayfa içinde sayfa demek, swichto ile içine girmek gerekir
        //

        //1-● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
       WebElement iFrameYazisiElement= driver.findElement(By.tagName("h3"));
       //softassert ile yapalım, önce softassert onjesi oluşturalım
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(iFrameYazisiElement.isEnabled());
        System.out.println(iFrameYazisiElement.getText());

        driver.switchTo().frame(0);
        //○ Text Box’a “Merhaba Dunya!” yazin.
    WebElement yaziAlani= driver.findElement(By.cssSelector(".mce-content-body"));
    yaziAlani.clear();
    yaziAlani.sendKeys("Merhaba Dünya");//gönderdiğimiz yazı gitmizyorsa orda ıframe vardır



        //○ TextBox’in altinda bulunan “Elemental Selenium”
        // linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        //en son ıframe yani sayfa içinde sayfaya girmiştik
        //şimdi switch ile ıframe den çıkmamız gerekir
        //çıkmanın 2 yolu var: içe içe 1 den fazla ı frame varsa, parent frame bir üstte geçiş yaptırır
        //diğeri defaultContent en uste

        driver.switchTo().defaultContent();
        WebElement linkElement= driver.findElement(By.linkText("Elemental Selenium"));

        softAssert.assertTrue(linkElement.isDisplayed());
        System.out.println(linkElement.getText());



       softAssert.assertAll();
    }
}