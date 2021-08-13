package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {//abstract yapınca başka classlardan obje oluşrumank isterse oluşturup ulaşamazlar

    //oluşturduğumuz farklı package lardan ulaşmak için Webdriver imizi protected yaptık
    protected WebDriver driver;

    //en geniş acces modifier imiz hangisi public-->herkes ulaşabilir ve değiştirebilir
    //onun için protected--->aynı package ve child class lar ulaşbilir---İŞİMİZW YARAR
    //default--birşey yazmayınca  de default kabul edilir): package private --bu şimizi göremz
    //private-->sadece clas içerisinde kullanıyoruz

    @BeforeMethod//her methoddan önce çalışır
    public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();//DRİVER ımıza değer atadık
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @AfterMethod
    public  void tearDown(){
     //driver.quit();//işlem yapacağımız butun sayfları kapatacak

    }

}
