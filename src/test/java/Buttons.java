import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.awt.*;

public class Buttons {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/button.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void button (){
        //Click and Confirm title.
        WebElement confirmTitle = driver.findElement(By.id("j_idt88:j_idt90"));
        confirmTitle.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected");
        } else {
            System.out.println("Actual title is mismatched");
        }

        Assert.assertEquals(actualTitle,expectedTitle,"Title mismatched");

        //Find the position of the Submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();

        System.out.println("X position is: " + x + " | Y position is: " +y);

        //Find the Save button color
        WebElement saveBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String color = saveBtn.getCssValue("background-color");
        System.out.println("Button color is: " +color);

        //Find the height and width of this button
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int height = submitBtn.getSize().getHeight();
        int width = submitBtn.getSize().getWidth();

        System.out.println("Height is: "+height + " | Width: "+width);

        driver.quit();


    }

}
