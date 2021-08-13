package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Z_TekrarSoru4 extends TestBase {

/*
1. "http://webdriveruniversity.com/IFrame/index.html" sayfasina
gidin
2. "Our Products" butonuna basin
3. "Cameras product"i tiklayin
4. Popup mesajini yazdirin
5. "close" butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine gittigini
test edin
 */

@Test
    public void test01(){
//  1. "http://webdriveruniversity.com/IFrame/index.html" sayfasina
    //gidin
    driver.get("http://webdriveruniversity.com/IFrame/index.html");
    //2. "Our Products" butonuna basin
    WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
    driver.switchTo().frame(iframe);
    WebElement ourproduct=driver.findElement(By.xpath("//a[text()='Our Products']"));
    Actions actions=new Actions(driver);
    actions.click(ourproduct).perform();
//3. "Cameras product"i tiklayin
    WebElement cameras=driver.findElement(By.id("camera-img"));
    actions.click(cameras).perform();
    //4. Popup mesajini yazdirin
    WebElement popup=driver.findElement(By.tagName("h4"));
    System.out.println(popup.getText());

        WebElement popupup= driver.findElement(By.tagName("b"));
    System.out.println(popupup.getText());

/*
    //5. "close" butonuna basin
    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();

    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //ıfrmeden çık
    driver.switchTo().defaultContent();//parent olursa tamamen çık , default olursa sayfalardan tek tek çık
   WebElement yazi= driver.findElement(By.xpath("//a[@class='navbar-brand']"));
   yazi.click();

   //7. "http://webdriveruniversity.com/index.html" adresine gittigini
    //test edin

    String sonuc= driver.getCurrentUrl();
    Assert.assertEquals(sonuc,"http://webdriveruniversity.com/index.html");

 */

}

}
