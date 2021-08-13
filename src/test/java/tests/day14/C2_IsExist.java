package tests.day14;

import org.testng.Assert;//testng geliyor
import org.testng.annotations.Test;//testng

import java.nio.file.Files;//java
import java.nio.file.Path;//java
import java.nio.file.Paths;//java dan geliyor

public class C2_IsExist {


    @Test
    public void test01(){
        //masaüstünüzde flower dosyasının olduğunu test ediniz

        //1. adım= masaustunun main pathini string olarak kaydedelim
        String mainPath=System.getProperty("user.home");//kullanıcı merkezine giidyoruz, aşağıda kullanacağız

        //2.adım dosya yolunu String olarak kaydedelim
        //önce olduğu yer sonra kendi yolunu belirlemeliyiz

        String dosyaYolu=mainPath+"\\Desktop"+"\\FLOWER.jpg";
        //selenıum ile masaustunde olup olmadığına bakabiliriz, dosyayı açamayız
        System.out.println(dosyaYolu);

        //3-Assertion yapalım
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//C:\Users\ahmet\Desktop\FLOWER.jpg
        //var mı yok mu anlamında baktık



    }
}
