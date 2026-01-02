import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadDownload {

    WebDriver driver;

    @BeforeMethod
    public void initiateDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void download() throws InterruptedException {
        driver.get("https://leafground.com/file.xhtml");

        driver.findElement(By.xpath("//span[text()='Download']")).click();
        Thread.sleep(4000);

        File file = new File("C:\\Users\\ruchi\\Downloads");
        File[] totalfiles = file.listFiles();

        for (File findFile :totalfiles){
            if (findFile.getName().equals("TestLeaf Logo.png"));{
                System.out.println("File is downloaded");
                break;
            }
        }
    }

   @Test
    public void upload() throws AWTException, InterruptedException {
       driver.get("https://leafground.com/file.xhtml");

       driver.findElement(By.xpath("//span[@id='j_idt88:j_idt89']")).click();

       //Windows control afterward
       String data = "C:\\Users\\ruchi\\Downloads\\Screenshot 2025-12-30 103606.png";
       StringSelection clipboardData = new StringSelection(data);

       //Copy path to clipboard
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipboardData, null);

       Thread.sleep(3000);
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);

       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
   }

   @Test
       public void upload2()  {
       driver.get("https://leafground.com/file.xhtml");

        //2nd way - Using send keys
       WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
       uploadUsingSendKeys.sendKeys("C:\\Users\\ruchi\\Downloads\\Screenshot 2025-12-30 103606.png");
   }

}
