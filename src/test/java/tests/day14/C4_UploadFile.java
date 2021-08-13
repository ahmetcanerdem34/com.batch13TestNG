package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.Assert.*;

public class C4_UploadFile extends TestBase {

    /*
    1.Tests packagenin altina bir class oluşturun : D14_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
3.chooseFile butonuna basalim
4.Yuklemek istediginiz dosyayi secelim.
5.Upload butonuna basalim.
6.“File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void uploadFile() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

        //1- dosya seç butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        //2- yuklemek istediğiniz dosyanın dosya yolunu yolunu kaydedin
        String  dosyaYolu=System.getProperty("user.home")+"\\Desktop\\FLOWER.jpg";

        // 3- SendKeys ile dosyayi dosyasec butonuna yollayin
        dosyaSecButonu.sendKeys(dosyaYolu);
        Thread.sleep(5000);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisiElementi=driver.findElement(By.tagName("h3"));
        assertTrue(fileUploadedYazisiElementi.getText().contains("File"));
        assertFalse(fileUploadedYazisiElementi.getText().contains("Mehmet"));
        assertEquals(fileUploadedYazisiElementi.getText(),"File Uploaded");

        //bir sayfada birden fazla assert yapacaksanız ve her seferin assert yazmak istemiyorsak
        //baştaki Assert u sil alt enter yap seç ve bundan sonrakilerde Assert yazmadan assert. ile yapabiliriz
        //Assert.*; yukarı çık butun assertlerde equal false tru hepsinde Asserte gerek kalmadı
        //Soft Assert olmaz çünkü ona obje üzerinden ulaşıyoruz, bunlar static tir import edilirler


    }
}









