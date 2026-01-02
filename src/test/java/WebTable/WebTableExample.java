package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void webTablePage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
    }


    @Test
    public void PaginationTable() throws InterruptedException {
        //How many rows in the table
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row count is: " +rowCount);

        //How many headers in the table
        int headerCount = driver.findElements(By.xpath("//table[@id='productTable']/thead//th")).size();
        System.out.println("Row count is: " + headerCount);

        //Retrieve the specific row/column data
        String columnData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified row/column data is : " +columnData);

        //Retrieve all data from table
        for (int i=1; i<=rowCount; i++){ //rows
            for (int j=1; j<headerCount; j++){ //Column
                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData + "  ");
            }
            System.out.println();
        }


        //Print ID and name only
        for (int i=1; i<=rowCount; i++){
            String tableID= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String ProductName= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println("Table Id: "+tableID + "      Product name is: "+ProductName);

            //Find the product price which name related to product 3
            if (ProductName.equals("Tablet")){
            String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(ProductName + "Relevant product price is: " +productPrice);
                break;
            }
        }

        //Select all the checkboxes
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pagination = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pagination.get(k).click();
            Thread.sleep(2000);

            for (int l=1; l<rowCount; l++){
                boolean atb = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+l+"]/td[4]/input")).isSelected();
                if (!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+l+"]/td[4]/input")).click();
                    Thread.sleep(2000);

                }
            }

        }

        //Select one checkbox
        int tableRow = 3;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tableRow+"]/td[4]/input")).click();



    }



}
