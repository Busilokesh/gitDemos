package lokeshMavenProject.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPlacedPage {
WebDriver driver;

 
public  OrderPlacedPage(WebDriver driver)
   {
     this.driver=driver;
     PageFactory.initElements(driver, this);
   }
   @FindBy (css=".hero-primary")
   WebElement confirmMessage;
   
   public String orderPlaced()
   {
	    String Message = confirmMessage.getText();
	   return Message;
   }
}
