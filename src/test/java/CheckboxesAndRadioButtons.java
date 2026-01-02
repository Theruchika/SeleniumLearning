import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class CheckboxesAndRadioButtons {

    WebDriver driver;

      @BeforeMethod
    public void radio_checkbox_BeforeTests (){
          driver = new ChromeDriver();
          driver.manage().window().maximize();
      }

      @Test
    public void radioTests() throws InterruptedException {

        //Find the default select radio button
          driver.get("https://leafground.com/radio.xhtml#");

          Boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
          Boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
          Boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
          Boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

          if (chromeRadioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
              System.out.println("Default select radio button is: " +chromeText);
          } else if (firefoxRadioOption) {
             String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
              System.out.println("Default select radio button is: "+firefoxText);
          } else if (safariRadioOption) {
             String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
              System.out.println("Default select radio button is: "+safariText);
          } else if (edgeRadioOption) {
              String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
              System.out.println("Default select radio button is: " +edgeText);

          }

          List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
          int radioCount = radioElements.size();
          System.out.println("Radio button count: "+radioCount);

          int index = -1;

          for (WebElement radioElement : radioElements){
              index++;

              if (radioElement.isSelected()){
                  WebElement defaultSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2:"+ index +"']"));
                  String defaultSelectedRadioText = defaultSelectedRadioButton.getText();
                  System.out.println("Default select Radio button text : "+defaultSelectedRadioText);
                  break;
              }

          }

          //Select the age group (if not selected)
            WebElement AgeGroup = driver.findElement(By.xpath("//input[@id='j_idt87:age:0']"));
            boolean isChecked = AgeGroup.isSelected();
            if (!isChecked ){
             //   AgeGroup.click();
                 driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
            }
            Thread.sleep(4000);

      }

      @Test
    public void CheckboxTest (){

          driver.get("https://leafground.com/checkbox.xhtml#");
          List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

          for (WebElement checkBox : checkboxList) {
              if (!(checkBox.getText().equals("Others"))) {
                  checkBox.click();
              }
          }
            for (int i=1; i<checkboxList.size(); i++){
                Boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
                System.out.println("Checkbox " + i + " selected status is" + checkboxStatus);
            }

    }

}
