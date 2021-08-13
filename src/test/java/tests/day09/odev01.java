package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.concurrent.TimeUnit;

public class odev01 {

     /*
1. "http://zero.webappsecurity.com/" Adresine gidin2. Sign in butonuna basin
3. Login kutusuna "username" yazin
4. Password kutusuna "password." yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. "Purchase Foreign Currency" tusuna basin
8. "Currency" drop down menusunden Eurozone'u secin
9. "amount" kutusuna bir sayi girin
10. "US Dollars" in secilmedigini test edin
11. "Selected currency" butonunu secin
12. "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
13. "Foreign currency cash was successfully purchased." yazisinin ciktigini
    control edin
         */

   WebDriver driver;

   @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }
    @AfterMethod
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void tyest01(){
        // 1. "http://zero.webappsecurity.com/" Adresine gidin2. Sign in butonuna basin

        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();

        //3.Login kutusuna "username" yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
//4.Password kutusuna "password." yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5.Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.id("proceed-link")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Pay')]")).click();//partialText le de alabiliriz
        //7. "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.partialLinkText("Purch")).click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        WebElement drop=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select= new Select(drop);

        select.selectByVisibleText("Eurozone (euro)");

        //9. "amount" kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("3000");

        //10. "US Dollars" in secilmedigini test edin
        //assert ten flase yapacağız
        WebElement radio=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radio.isSelected());//seçilmedi mi false false passed eder

        //11. "Selected currency" butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //13. "Foreign currency cash was successfully purchased." yazisinin ciktigini control edin
        WebElement succes= driver.findElement(By.xpath("//div[@id='alert_content']"));
        System.out.println(succes.getText());

        String expected="Foreign currency cash was successfully purchased.";
        String actual=succes.getText();
        Assert.assertEquals(actual,expected);

        Assert.assertTrue(succes.isDisplayed());//yazı görüngü mü göründü true
    }




}
