import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Alerts {

    WebDriver driver;


    @BeforeMethod
    public void alertsPage (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://leafground.com/alert.xhtml");

    }

    @Test
    public void alertsTests () throws InterruptedException {
        // Alerts Simple dialog
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']")).click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Alert Confirm dialog
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']")).click();
        Thread.sleep(3000);

        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.dismiss();

        String resultText = driver.findElement(By.xpath("//span[@id='result']")).getText();
        System.out.println(resultText);
        assertTrue(resultText.contains("Cancel"),
                "Expected result text to contain 'Cancel' but found: " + resultText);

        //Alert prompt dialog
        WebElement promptDialog = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']"));
        promptDialog.click();

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Ruchika");
        promptAlert.accept();

        String promptText = driver.findElement(By.id("confirm_result")).getText();
        Thread.sleep(3000);
        assertTrue(promptText.contains("User entered name as: Ruchika"),
                "User entered name as: Ruchika");

    }

}
