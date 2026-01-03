package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import javax.tools.Tool;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotExample {

    WebDriver driver;

    @BeforeMethod
    public void openWebPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.manage().window().maximize();

    }
    @Test
    public void takeScreenshotTests() throws IOException, AWTException {
        driver.get("https://leafground.com/alert.xhtml#");

        //Capture screenshots of full page
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(
                System.getProperty("user.dir") + "\\src\\screenshot\\alert_full_web_page.png"
        );
        FileHandler.copy(sourceFile, destinationFile);


        //Capture screenshot of section of a web page

        WebElement selectedArea = driver.findElement(By.xpath("//div[@class='col-12 lg:col-6'][1]"));
        File source = selectedArea.getScreenshotAs(OutputType.FILE);
        File target = new File(
                System.getProperty("user.dir") + "\\src\\screenshot\\alert_section_of_the_web_page.png");

        FileUtils.copyFile(source,target);

        //Capture screenshot of an element on a web page
        WebElement selectedElement = driver.findElement(By.xpath("//div[@class='col-12 lg:col-6'][1]/div[1]"));
        File source2 = selectedElement.getScreenshotAs(OutputType.FILE);
        File target2 = new File(
                System.getProperty("user.dir") + "\\src\\screenshot\\alert_element.png");

        FileUtils.copyFile(source2,target2);

        //Capture screenshot of full entire screen
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);

        BufferedImage source3 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(
                System.getProperty("user.dir") + "\\src\\screenshot\\alert_Page_entire_screen.png");

        ImageIO.write(source3,"png",destinationFile2);


    }

}
