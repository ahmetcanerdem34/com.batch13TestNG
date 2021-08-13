package tests.day12;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_TestBase01 extends TestBase {//before after olan utılıtıes clasına ulaşmak istiyoruz

    //bu clasımda befor after methodu oluşturmak istemiyorum
    //direk test oluşturalım

    @Test
    public void test01(){

        //youtube.com a gitmek istiyoruz

        driver.get("https://youtube.com");

        //testBase clasından obje de oluşturabiliriz



    }
}
