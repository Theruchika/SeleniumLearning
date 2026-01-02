import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActions {

     WebDriver driver;

     @BeforeMethod
     public void mouseActions(){

         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://leafground.com/drag.xhtml");

     }

     @Test
     public void  mouseOperationsTest1() throws InterruptedException {

         System.out.println("<<<<<<<<<<<<<<<<<<<<<Move to element operator>>>>>>>>>>>>>>>>>");
         Actions actions = new Actions(driver);

         actions.moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                 .moveToElement(driver.findElement(By.id("menuform:j_idt39")))
                 .moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();


         System.out.println("<<<<<<<<<<<<<<<<<<<<<Drag and Drop Operation>>>>>>>>>>>>>>>>>");
         WebElement from = driver.findElement(By.id("form:drag_content"));
         WebElement to = driver.findElement(By.id("form:drop_content"));

         //actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
         actions.dragAndDrop(from, to).perform(); //2nd way


         System.out.println("<<<<<<<<<<<<<<<<<<<<<Move to element operator>>>>>>>>>>>>>>>>>");

         WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
         System.out.println("Location of slider point 1:" + sliderPoint1.getLocation());

         actions.dragAndDropBy(sliderPoint1, 50, 0).perform();
         System.out.println("Location of slider point 1 after moving:" + sliderPoint1.getLocation());

     }
     @Test
            public void mouseRightclick(){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<Right Click>>>>>>>>>>>>>>>>>");
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

            WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

            Actions actions1 = new Actions(driver);
            actions1.contextClick(rightClickButton).perform();

            driver.findElement(By.xpath("//span[text()='Edit']")).click();
                Alert alertPopup = driver.switchTo().alert();
                System.out.println("Alert is " +alertPopup.getText());

                alertPopup.accept();
     }



}
