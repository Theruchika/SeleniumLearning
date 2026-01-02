import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void dropdownTestPage(){
        driver = new ChromeDriver();

    }

    @Test
    public void dropdownTest() {
        //Which is your favorite UI Automation tool?
        driver.get("https://www.leafground.com/select.xhtml");

        WebElement selectdropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(selectdropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //Get the number of dropdown options
        //Generics
        List <WebElement> listOfOptions = select.getOptions();
        int drpSize = listOfOptions.size();
        System.out.println("The size of the dropdown is: " +drpSize);

        for (WebElement element : listOfOptions){
            System.out.println(element.getText());
        }

        //Select dropdown value using send keys
        selectdropdown.sendKeys("Puppeteer");

        //Selecting value in a bootstrap dropdown
        WebElement bootStrpDropdown = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        bootStrpDropdown.click();

        List <WebElement> listBtstrp = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element: listBtstrp){
            String dropdownvalue = element.getText();
            if (dropdownvalue.equals("USA")){
                element.click();
                break;
            }
        }


        //Google search - Pick a value from

    }
        @Test
    public void gSearchDropdown () throws InterruptedException {

            driver.get("https://www.Google.com");

            driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Palitha");
            Thread.sleep(2000);

            List<WebElement> googleDropdown= driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
            System.out.println(googleDropdown.size());

            for (WebElement element:googleDropdown){
                System.out.println(element.getText());
            }

            //Handle hidden auto suggestions dropdown and search using DOM debugger trick



    }

}
