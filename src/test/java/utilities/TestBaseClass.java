package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBaseClass {




    WebDriver driver;

    @BeforeMethod//her methoddan önce çalışır
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();//DRİVER ımıza değer atadık
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @AfterMethod
    public  void tearDown(){
        driver.close();
}
}