package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_Priority {


    //testNG sıraya göre testleri gerçekleştiri Junıt ten farklı

    WebDriver driver;

    //before methodumuzu oluşturalım
    @BeforeMethod
    public void seup(){
        WebDriverManager.chromedriver().setup();//web driver ı oluşturduk şimdi değer atayalım
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



    }
    //after methodumuzu oluşturalım
    @AfterMethod
    public void tearDown(){//hepsinden sonra kapat
        driver.close();

//***çalışma sırasını değiştirmek istiyorsak
        //(priorty= bir sayı yaz)

        //priority öncelik demek sayının en düşüğünden başlar
        //priority yazmazsak önce yazmadıklarımız çalışır sonra sayı değerine göre

        /*
        ***TestNG ile genel bir yeniliktir priority=öncelik sıralama anlamında
    1- PRIORITY YAZILMAYAN METHODLAR EN BASTA CALISIR
    2- PRIORITY YAZILAN METHODLAR ISE ; VERILEN ONCELIK SIRASINA GORE CALISIR
    3- EGER HERHANGI BIR PRIORITY VERILMEDIYSE ALFABETIK SIRAYA GORE CALISIR.
 */

    }
    //test methodu yapalım
    @Test (priority = 10)
    public void test01(){

        System.out.println("test01 çalıştı");

    }
    //bir test methodu dahga yapalım
    @Test (priority = 5)
    public void ikincitest(){

        System.out.println("ikinci test çalıştı");

    }
    //bir test methodu dahga yapalım
    @Test (priority = 2)
    public void yazdimtesti(){

        System.out.println("yazdım  test çalıştı");

    }
}
