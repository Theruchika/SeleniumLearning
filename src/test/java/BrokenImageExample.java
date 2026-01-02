import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageExample {
    WebDriver driver;

    @BeforeMethod
    public void openImagePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void brokenImage() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        int i = 1;
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Image " + i + " is broken");
            } else {
                System.out.println("Image " + i + " is displaying");
            }
            i++;
        }
    }

    @Test
    public void brokenImage2 (){
        driver.get("https://demoqa.com/broken");

        WebElement brknImage = driver.findElement(By.xpath("//img[@src='/images/Toolsqa_1.jpg']"));
        if (brknImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is broken");
        }else {
            System.out.println("Image is not broken");
        }
    }

    @Test
    public void datePicker() throws InterruptedException {
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement calendar = driver.findElement(By.xpath("//input[@id='datepicker']"));
        calendar.sendKeys("03/08/1995");
        Thread.sleep(3000);
        calendar.clear();
        calendar.click();

        selectFutureDate("1995", "November", "3");

    }

    public void selectFutureDate(String year, String month, String date){

        while (true) {
            String actualMonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
        List<WebElement> calendarDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a"));

        for (WebElement dateElement : calendarDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }

    }

}

