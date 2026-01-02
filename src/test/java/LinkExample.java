import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void LinkTest() {
        //Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my destination
        WebElement whereToGo= driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to: " +path);

        //Am i broken
        WebElement brokenLink = driver.findElement(By.xpath("//a[contains(text(),'Broken?')]"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        }else {
            System.out.println("Not broken");
        }
        driver.navigate().back();


        //Duplicate link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //Count page link
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int pageCount = links.size();
        System.out.println("Counts of page links: " +pageCount);

        //Count Layout Links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List <WebElement> countOfLayoutLink = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links: "+countOfLayoutLink.size());


    }



}
