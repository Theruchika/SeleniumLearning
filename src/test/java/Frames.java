import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Frames {

    WebDriver driver;

    @BeforeMethod
    public void framesTestsPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/frame.xhtml");


    }

    @Test
    public void frameTests(){
        //Click Me (Inside frame)

        WebElement firstIframe = driver.findElement(By.xpath("//iframe[@src='default.xhtml']"));
        driver.switchTo().frame(firstIframe);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String buttonText = button1.getText();
        System.out.println("First " +buttonText);

    // Click me Inside nested frame
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
        WebElement thirdClickMe = driver.findElement(By.id("Click"));
        thirdClickMe.click();

        String thirdClickMeText = thirdClickMe.getText();
        System.out.println("Third "+thirdClickMeText);

        // How many frames in this page
        driver.switchTo().defaultContent();

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("iFrame count is: "+iframes.size());

        for (WebElement iframeElement : iframes){
            String frameSRC = iframeElement.getAttribute("src");
            System.out.println("Frame src attribute value " +frameSRC);
        }
    }
}
