import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowMultipleTabs {

    WebDriver driver;

    @BeforeMethod
    public void windowTestpage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://leafground.com/window.xhtml");

    }

    @Test
    public void windowTests() throws InterruptedException {
        // Click and confirm new window opens
        driver.findElement(By.id("j_idt88:new")).click();
        Thread.sleep(2000);

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + oldWindow);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handle size: " + handles.size());


        //First method - using foreach loop

        for (String handle : handles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
            System.out.println("Page title is: " + driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(oldWindow);
        boolean openButtonVisibility = driver.findElement(By.id("j_idt88:new")).isDisplayed();
        System.out.println("Open button visibility: " + openButtonVisibility);


    //Second method - Using list

        driver.findElement(By.id("j_idt88:new")).click();
        Set<String> handles2 = driver.getWindowHandles();
        List<String> list = new ArrayList<String>(handles2); //Converting SET to List
        if(list.size() > 1) {
            driver.switchTo().window(list.get(1));
            System.out.println("Child tab title is: " + driver.getTitle());

            driver.close();
            driver.switchTo().window(oldWindow);
        }

        boolean openButtonVisibilityy = driver.findElement(By.id("j_idt88:new")).isDisplayed();
        System.out.println("Open button visibility: " + openButtonVisibilityy);

        //Find the number of opened tabs
        WebElement multiwindow = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiwindow.click();

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("Window count:" +howmanyWindows);

        //Close all window expect primary

        WebElement closeWindow = driver.findElement(By.id("j_idt88:j_idt93"));
        closeWindow.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandle = driver.getWindowHandles();

        for(String windows: newWindowsHandle){
            if (!windows.equals(oldWindow)){
                driver.switchTo().window(windows);
                driver.close();
            }
        }

        driver.quit();
//        driver.switchTo().window(oldWindow);
//        driver.close();

    }

}

