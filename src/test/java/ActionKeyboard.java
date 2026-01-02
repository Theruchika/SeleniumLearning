import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboard {

    WebDriver driver;

    @BeforeMethod
    public void actionKeyboard () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
        @Test
        public void keyboardActionsTest1(){

        driver.get("https://www.google.com/");
        WebElement search= driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']"));
        search.sendKeys("Welcome");
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

            actions.keyDown(Keys.SHIFT).sendKeys("Capital").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

            actions.contextClick(search).perform();
            //driver.findElement(By.xpath("//div[@id='Zrbbw']")).click();

            //To write captial in a text box

            actions.keyDown(search,Keys.SHIFT).sendKeys("Learn with Ruchika").perform();

    }
    @Test
    public void keyboardActionsTest2() throws InterruptedException {

        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(2000);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        System.out.println("Size of the menu items: " + menuItems.size());

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(menuItems.get(1))
                .click(menuItems.get(2))
                .click(menuItems.get(3))
                .keyUp(Keys.CONTROL)
                .perform();
    }

}
