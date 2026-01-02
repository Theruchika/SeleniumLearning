import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("137");
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/input.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){

        //Type your name
        WebElement Typename = driver.findElement(By.id("j_idt88:name"));
        Typename.sendKeys("Ruchika");

        //Append Country to this City.

        WebElement Country = driver.findElement(By.id("j_idt88:j_idt91"));
        Country.sendKeys("India");

        //Verify if text box is disabled
        boolean isDislayed = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("IS text box enabled: "+isDislayed);

        //Clear the typed text.
        WebElement clear = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']"));
        clear.clear();

        //Retrieve the typed text.
        WebElement typeText = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']"));
        String value = typeText.getAttribute("value");
        System.out.println("Value of the typed text is" +value);

        //Type email and Tab. Confirm control moved to next element.
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("ruchikapromodya@gmail.com" + Keys.TAB + "Confirmed control moved to next element");


        //Type about yourself
        WebElement myself = driver.findElement(By.id(""));



    }

}
