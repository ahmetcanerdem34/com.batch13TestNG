package tests.day14;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_BilgisayardakiDosyalaraUlaşma {

   @Test
   public void  test01(){

       System.out.println(System.getProperty("user.dir"));
       //eğer biz sistem .getproperty dersek içinde oldugumuz projenin yolunu verir

       //System.getProperty("user.home")-->kullandığımız bilgisayarın ana path ini verir
       System.out.println(System.getProperty("user.home"));

        //bir dosyaya dinamik olarak ulaşmak için

       //masaüstüne ulaşmak için, önce main path
       String masaUstuDosyaYolu=System.getProperty("user.home") + "\\Deskstop";

       System.out.println(masaUstuDosyaYolu);//C:\Users\ahmet\Deskstop

   }
}
