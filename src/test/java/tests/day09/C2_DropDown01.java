package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C2_DropDown01 {

    /*
    **DropDown  webelemntlerini handle etemk için 3 adım gerekir
    * 1_Dropdown ı locate etmek
    * 2-Locate ettiğimiz webelemntini parametre olarak kullanıp select objesi oluşturuyoruz
    * 3-select objesi kullanarak 3 yöntemle sitediğimzi optionu seçebiliriz
    *       a)index b) value c)visibletext
    * DropDown webelemntini htmltag olarak select kullanır
    * ğer tum opsiyonları testimizde kullanmak istiyorsak Webelemntlerinden oluşan bir liste
    * -oluşturup opsiyonları bu listeye kaydederiz.Bu işlem için get.options() methodu kullanılır
    * *Eğer select objesi ile bir opsiyonu seçersek, seçtiğimiz opsiyonu yazdırmak;
    * -get.FirstSelectionOption() methodu kullanılır

        Handle Dropdown :
        1) Dropdown menuyu herhangi bir locator ile locate edin.
            WebElement selectElement = driver.findElement(By.id("value of id"));
        2) Yeni bir "select" objesi olusturun ve daha once locate ettigimiz
        WebElement'i parameter olarak yeni objeye ekleyin.
            Select options = new Select(selectElement);
        3) Dropdown icin kullanilan 3 yontemden biriyle dropdown menusundeki
        elemanlardan istediginizi seciniz.
            options.SelectByIndex(1);
        - Dropdown menuleri her zaman <select> tag'i ile baslar.
        - Dropdown'u nasil handle edersin ?
            <select> tag'i ile
     */
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void DropdownTesti(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // dropdown'i kullanabilmek icin 3 asama yapmamiz gerekir
        // 1.asama---- dropdown'u locate edelim
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement dropdownMenu =driver.findElement(By.xpath("//select[@id='dropdown']"));
        // 2.asama seelct objesi oluştur
        Select dropdownListe = new Select(dropdownMenu);
        // 3.asama dropdown menusunden istedigimiz option'i secelim
        dropdownListe.selectByIndex(1);
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        System.out.println("listeden  " + dropdownListe.getFirstSelectedOption().getText());
        System.out.println("get text" + dropdownMenu.getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    }
    @Test
    public void degerKullanma(){

        //önce sayfay gidelim
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //1. adım locate etmek
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2. adım select objesi oluştur
        Select select= new Select(acilirListe);//seelct objesi oluşturduk
        //seelct objesini yaz ve istediğin şeyi yaz valu ile seçeceğimiz için içerisine string"" yazmalıyız
        select.selectByValue("2");//gidip 2. yi seçmesi lazım yani index 2 yi, zaten 0 1 2 seçenekleri var

        System.out.println(select.getFirstSelectedOption());//select objesiyle, seçileni bul option 2 yi yazdır
    }
    @Test //
    public void gorunurIsim(){
       // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        //önce adrese git
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //locate et
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(acilirListe);

        select.selectByVisibleText("Option 1");//optıon 1 i seç ve yazdır
        System.out.println(select.getFirstSelectedOption().getText());

    }
    @Test
    public void tumListe(){


        //önce adrese git
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // drodown ı locate et
        //dropdown ı handle etmek istiyorsanız ilk yapılacak şey onu locate etmek
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //edindiğimi drop down ı select objesine atamalıyız
        Select select = new Select(acilirListe);

        //tum listeyi istiorsa select yaz . get optıons ı tıklayınca bir liste döndurecek
        //önce liste oluşturualım
        List<WebElement> tumOpsiyonlar = select.getOptions();//elimde birliste var ve bunlar webelemntlerden oluşuyor
        //listeyi yazzdırmsk istiyorsak for each kullanmalıyız

        //   4.Tüm dropdown değerleri(value) yazdırın

        for (WebElement each: tumOpsiyonlar) {

            System.out.println(each.getText());
            /*
Please select an option
Option 1
Option 2
             */
            // 5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
            System.out.println("dropdown daki web element sayisi : " + tumOpsiyonlar.size());

            if(tumOpsiyonlar.size()==4){
                System.out.println("True");

            }else
                System.out.println("False");
        }

    }
}
