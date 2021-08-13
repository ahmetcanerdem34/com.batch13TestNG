package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class grupCalismasi02 {


    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown() {
      //  driver.close();



    }
    @Test
    public void test01(){

        driver.get("https://amazon.com");
        WebElement dropDown= driver.findElement(By.tagName("select"));
        dropDown.click();

        Select select = new Select(dropDown);//obje oluşturduk
        List<WebElement> list= select.getOptions();//selectle aldığımız get optionslar



        int i=0;
        while (i<list.size()){

            System.out.println(list.get(i).getText());
            i++;
        }


    }


}
