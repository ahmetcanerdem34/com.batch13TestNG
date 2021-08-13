package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {

    /*
    1-Dependson
    2-(Hard) Assert: Kod yazılırken Hard ayazılmaz, sadddece Assert ile başlar
    *Assert edilen durumlarddan bir tanes FAILED olursa excutıon durur.,
    *Sonraki kodlar çalışmaz. Bunun pozitif yonü: Problem bulunur bulunmaz bize rapor eder,
    -bizde düzeltiriz.
    -Negatif yönü; hata sayısı birden çoksa her seferindebir hatayı verir, biz onu düzeltip çalıştırınca
    -sonraki hatayı verir

    3-SoftAssert: (Veification): test edilen durumların PASS veya FAILED olmasına bakmaksızın
    -tum assertları gözden geçirir ve en sonda kaç assertıon PASS,,
    -kaç yanesi FAILED oldu bize rapor eder. 3.adımda calışır
    i)softassert objesi oluştur ii)tum assertıonları yap
    -iii) softAssert.assertAll ile assertıonları raporla
     */

    //Selenıum öğrenmek çok zevkli cümlesinde aşağıdaki testleri yapınız
    //hard ve soft assert arasındaki farkları görmek için şu denemeyi yapalım
    /*
    1-cümle öğrenmek içeriyor
    2-java Java içermiyor
    3-cümle 4 kelimeden oluşuyor
    4- cümledeki karakter sayısı
     */
    WebDriver driver;
    String cumle="Selenıum öğrenmek çok zevkli";

    @Test
    public void hardAssertion() {
        Assert.assertTrue(cumle.contains("öğrenmek"));//burdaki hatalı olsa diğerlerinide çalıştırmaz,
        System.out.println("1");
        Assert.assertFalse(cumle.contains("Java"));
        System.out.println("2");
        //3-cümle 4 kelimeden oluşuyor  ==>önce splitle kelimeleri 4 e bölelim
        String kelimeler[]=cumle.split(" ");//space ile parçalara böldük kelimeleri
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");
        // 4- cümledeki karakter sayısı
        System.out.println("4");
        String karakterler[]=cumle.split("");//hiçilik ile parçalara böldü cümleyi
        Assert.assertEquals(kelimeler.length,65);//failed olmalı
    }
    //yukardaki denemeyi softassertion ile yapalım
    @Test
    public void softAssertionTest01(){

        //SoftAssert clasından önce obje oluştrumalıyız

        SoftAssert softAssert= new SoftAssert();//clasdan obje oluşturduk
        softAssert.assertTrue(cumle.contains("öğrenmek"));
        System.out.println("1");

        softAssert.assertFalse(cumle.contains("Java"));
        System.out.println("2");

        String kelimeler[]=cumle.split(" ");//space ile parçalara böldük kelimeleri
        softAssert.assertEquals(kelimeler.length,44,"kelime sayısı failed");//
        System.out.println("3");


        String karakterler[]=cumle.split("");//hiçilik ile parçalara böldü cümleyi
        softAssert.assertEquals(karakterler.length,25,"karakter ayısı failed");//burası failed olmasına rağmen çalıştı
        System.out.println("4");


        softAssert.assertAll();//bu işlemlere başlamadan eklemek önemli, bunu kullanmayınca hataları rapor etmez
        //açıklamda yapmıyor

        //ÖNEMLİ: yapılan soft assertlerden biri failde olursa işleyiş durur
        //soft assert test bitti olarak algılar ve durumu rapor eder
        //yukardaki hataları konsol softAssert.assertAll(); da gösterir
        System.out.println("bu yazı konsolda çıkar mı");//çıkmaz çünkü softAssert.assertAll(); gördü

    }

}
