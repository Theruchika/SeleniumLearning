import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptExecutor {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeMethod
    public void openJSExecutorPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        javascriptExecutor = (JavascriptExecutor) driver;

    }

    @Test
    public void jsExecutorTests() throws InterruptedException {


            //Get an alert nox in tp webpage using JS
            javascriptExecutor.executeScript("alert('My name is Ruchika')");

            driver.switchTo().alert().accept();


            // Set an input value in a text box using js

                    // Set the value using the value property

            WebElement name= driver.findElement(By.xpath("//input[@id='name']"));
            javascriptExecutor.executeScript("arguments[0].value='Ruchika';",name);

                    //Set the value using setAttribute
            javascriptExecutor.executeScript("arguments[0].setAttribute('Ruchika','YourValue');",name);

            Thread.sleep(3000);


            //Highlight element
            javascriptExecutor.executeScript("arguments[0].style.border='3px solid red';",name);
            javascriptExecutor.executeScript("arguments[0].style.background='yellow';",name);
            Thread.sleep(3000);


            //Click element using js
            WebElement maleCheckbox = driver.findElement(By.xpath("//input[@id='male']"));
            javascriptExecutor.executeScript("arguments[0].click();",maleCheckbox);
            Thread.sleep(3000);

            //Scrolling the page
            scrollPage();

            //Page refresh
            javascriptExecutor.executeScript("location.reload();");

        }


    @Test
    //Scrolling the page
    public void scrollPage() throws InterruptedException {
        //Scroll to some Position
        javascriptExecutor.executeScript("window.scrollTo(0,1000)");
        javascriptExecutor.executeScript("window.scrollTo(0,-1000)");
        Thread.sleep(3000);

        //Scroll to bottom of the page by pixel number
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);


        //Scroll to the top of the page
        javascriptExecutor.executeScript("window.scrollTo(0,0);");
        Thread.sleep(3000);

        //Scroll the page till element is visible
        WebElement gender =driver.findElement(By.xpath("//label[text()='Gender:']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",gender);
        Thread.sleep(3000);

    }

}
