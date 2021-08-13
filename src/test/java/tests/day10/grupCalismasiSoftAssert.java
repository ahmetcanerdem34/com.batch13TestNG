package tests.day10;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class grupCalismasiSoftAssert {

    //Selenıum öğrenmek çok zevkli cümlesinde aşağıdaki testleri yapınız
    //hard ve soft assert arasındaki farkları görmek için şu denemeyi yapalım
    /*
    1-cümle öğrenmek içeriyor
    2-java Java içermiyor
    3-cümle 4 kelimeden oluşuyor
    4- cümledeki karakter sayısı
     */

    String actualCumle="Selenium öğrenmek çok zevkli";//aşağıdan ulaşmak için class seviyesine aldık

    WebDriver driver;
    @Test
    public void test01(){

        String expected="öğrenmek";
        Assert.assertTrue(actualCumle.contains(expected));
        System.out.println("içeriyor");
    }
    @Test
    public void test02(){
        //cumle java içermiyor
        String exp1="Java";
        Assert.assertFalse(actualCumle.contains("Java"));
        System.out.println("içermiyor");
    }
    @Test
    public void test03(){
        //cumle 4 kelimeden oluşuyor
        //array a atamak lazımki bölümlere ayırsın

        String kelimeler[]=actualCumle.split(" ");//kelimelere ayırır
        int actualKelimeler=kelimeler.length;
        int expectedNumber=4;
        Assert.assertEquals(actualKelimeler,expectedNumber);
        System.out.println("cümle 4 kelimeden oluşuyor");

    }
    @Test
    public void test04(){
        //cumledeki kaakter kayısı

        String karakter[]=actualCumle.split("");//karakterlere böler

        int actualKarakter=karakter.length;//28
        int expectedKarakterSayisi=25;
        System.out.println("cumlenin uzunluğu"+actualCumle.length());
        //Assert.assertEquals(actualKarakter,expectedKarakterSayisi);//false verecek 25-28

        SoftAssert softAssert= new SoftAssert();//BUNDAN SONRA bir yhata olduğunda çalışmaya devam edecek
        softAssert.assertEquals(actualKarakter,expectedKarakterSayisi);

        softAssert.assertAll();
        System.out.println("karakter sayıları uygun olmadı");
    }
}
