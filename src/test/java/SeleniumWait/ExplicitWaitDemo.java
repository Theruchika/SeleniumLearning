package SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");

    }

    @Test
    public void explicitWaitTest(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement BtnClick = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']"));
        BtnClick.click();

        WebElement newbtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_idt87:j_idt90']/span/")));
        String amHere = newbtn.getText();
        System.out.println("New button text is: "+amHere);


    }


}
