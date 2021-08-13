package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Z_TekrarSoru2 extends TestBase {

    /*
    1. " https://demoqa.com/dynamic-properties" sayfasina gidin
2. "Visible After 5 Seconds" butonunun gorunun oldugunu test edin
     */

    @Test
    public void test01(){
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait=new WebDriverWait(driver,5);
        WebElement visibleAfter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(visibleAfter.isDisplayed());


    }
}
