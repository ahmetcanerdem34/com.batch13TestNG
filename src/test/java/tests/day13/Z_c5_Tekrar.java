package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Z_c5_Tekrar extends TestBase {
    /*
     1- Bir Class olusturalim D14_KeyboardActions2
       2- https://html.com/tags/iframe/ sayfasina gidelim
       3- video’yu gorecek kadar asagi inin
       4- videoyu izlemek icin Play tusuna basin
       5- videoyu calistirdiginizi test edin
     */
    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
        sendKeys(Keys.PAGE_DOWN).perform();
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);
        WebElement button= driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button']"));
        actions.click(button).perform();
        //5- videoyu calistirdiginizi test edin
        WebElement watchOn= driver.findElement(By.xpath("//div[@class='ytp-impression-link-text']"));
        Assert.assertFalse(watchOn.isDisplayed());

    }
}
