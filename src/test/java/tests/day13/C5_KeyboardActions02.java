package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C5_KeyboardActions02 extends TestBase {

    /*
    1- Bir Class olusturalim D14_KeyboardActions2
    2- https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4- videoyu izlemek icin Play tusuna basin
    5- videoyu calistirdiginizi test edin
     */
   @Test
   public void test01(){
       // 2- https://html.com/tags/iframe/ sayfasina gidelim
       driver.get("https://html.com/tags/iframe/");


       // 3- video’yu gorecek kadar asagi inin
       //aşağı inmem için actions kullanmam gerekir
       Actions actions=new Actions(driver);//objeyi oluşrtuduk
       actions.sendKeys(Keys.PAGE_DOWN).
               sendKeys(Keys.PAGE_DOWN).perform();
       //istediğimiz kadar aşağı indik video göründü

        //4- videoyu izlemek icin Play tusuna basin
       //iframe yani iç sayfa olduğu için iframe var, önce ona geçmeliyiz
       //3 yöntem vardır, ya class, id, locate
       //sonra swich ile ifrmae geçip vide oyu tıklayacağız
       WebElement iFrame=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
       driver.switchTo().frame(iFrame);


        ////4- videoyu izlemek icin Play tusuna basin
       driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //  5- videoyu calistirdiginizi test edin

       driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).getAttribute("current time");
       driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).getAttribute("ended time");




   }
}
