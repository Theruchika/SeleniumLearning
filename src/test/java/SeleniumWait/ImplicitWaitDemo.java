package SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://leafground.com/waits.xhtml");

    }

    @Test
    public void implicitWaitTest(){
        WebElement BtnClick = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']"));
        BtnClick.click();

        String amHere= driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New button text is: "+amHere);


    }
}


