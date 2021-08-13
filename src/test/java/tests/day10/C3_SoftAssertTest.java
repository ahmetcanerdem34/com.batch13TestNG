package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_SoftAssertTest {

        /*
        Yeni bir Class Olusturun : D10_SoftAssertTest
1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
 "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
 "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
 "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
 "Singapore (dollar)","Thailand (baht)"
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
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.className("icon-signin")).click();

        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.id("proceed-link")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Pay')]")).click();//partialText le de alabiliriz
        //7. "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.partialLinkText("Purch")).click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        //drondown da ilk adıp locate etmek
        WebElement acilirListe=driver.findElement(By.id("pc_currency"));
        Select select = new Select(acilirListe);
        select.selectByVisibleText("Eurozone (euro)");

        //soft aseert objesi oluştur
        SoftAssert softAssert= new SoftAssert();
        String actualSeciliOpsiyon=select.getFirstSelectedOption().getText();
        String expectedValue="Eurozone (euro)";
        softAssert.assertEquals(actualSeciliOpsiyon,expectedValue);

        //10. madde array listle atılıp for each le her biri yazdırılabilir

        List<WebElement> tumOpsiyonlar= select.getOptions();
        List<String> tumOpsiyonlarString = new ArrayList<String>();
        for (WebElement w:tumOpsiyonlar
        ) {
            tumOpsiyonlarString.add(w.getText());
        }
        List<String > expectedOptionsList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand (dollar)","Sweden (krona)", "Singapore (dollar)","Thailand (baht)");
        System.out.println(expectedOptionsList);
        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"options listesi actual ile ayni degil...");

        softAssert.assertAll();

    }

}