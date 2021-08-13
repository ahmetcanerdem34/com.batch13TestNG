package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_IframeOrnek {

    /*
        https://html.com/tags/iframe/ adresine gidin youtube oynatma düğmesine basın
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
    public void ıframeTest() {

        //iframe sayfa içinde sayfa demek, swichto ile içine girmek gerekir
        //

        //1-● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://html.com/tags/iframe/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        iframe.click();
    }
}