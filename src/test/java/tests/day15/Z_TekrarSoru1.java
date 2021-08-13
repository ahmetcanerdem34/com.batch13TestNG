package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Z_TekrarSoru1 extends TestBase {

    /*
    1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox'in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. "It's enabled!" mesajinin goruntulendigini dogrulayın.
7. Textbox'in etkin oldugunu(enabled) dogrulayın
     */

    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Textbox'in etkin olmadigini(enabled) dogrulayın
        WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textbox.isEnabled());
        // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableBtn=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(enableBtn).perform();
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement enable= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
//6. "It's enabled!" mesajinin goruntulendigini dogrulayın.
        WebElement enableYazi=driver.findElement(By.id("message"));
        softAssert.assertTrue(enableYazi.isDisplayed());
// Textbox'in etkin oldugunu(enabled) dogrulayın
        softAssert.assertTrue(textbox.isEnabled());
        softAssert.assertAll();

    }
}
