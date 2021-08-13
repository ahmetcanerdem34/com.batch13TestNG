package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Z_TekrarSoru3 extends TestBase {
    /*
        1."http://webdriveruniversity.com/Actions" sayfasina gidin
        2."Hover over Me First" kutusunun ustune gelin
        3."Link 1" e tiklayin
        4.Popup mesajini yazdirin
        5.Popup'i tamam diyerek kapatin
        6."Click and hold" kutusuna basili tutun
        7. "Click and hold" kutusunda cikan yaziyi yazdirin
        8. "Double click me" butonunu cift tiklayin
     */

    @Test
    public void test01() {
//1."http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//2."Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverKutusu = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverKutusu).perform();
//3."Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert']")).click();
//4.Popup mesajini yazdirin
        String allertYazi=driver.switchTo().alert().getText();
        System.out.println(allertYazi);
//5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
// 6."Click and hold" kutusuna basili tutun
        WebElement clikAnHold= driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(clikAnHold).perform();
//7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndhold= driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        System.out.println(clickAndhold.getText());
//8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick= driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();
    }
}