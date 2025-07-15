package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass 
{
     WebDriver driver;
     
     public AbstractClass(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
    
     @FindBy (css="[routerlink*='myorders']")
     WebElement orderHeader;    
    
     public void waitForElementToAppear(By findBy1)
     {
    	 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
    	 w.until(ExpectedConditions.visibilityOfElementLocated(findBy1));
     }
    
     public void waitForWebElementToAppear(WebElement findBy1)
     {
    	 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
    	 w.until(ExpectedConditions.visibilityOf(findBy1));
     }
     
     public void waitForElementToDisappear(WebElement findBy)
     {
    	 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    	 w.until(ExpectedConditions.invisibilityOf(findBy));
     }
     
     public LokeshOrdersPage goToOrdersPage()
     {
    	 orderHeader.click();
    	 LokeshOrdersPage lokeshorderspage = new LokeshOrdersPage(driver);
    	 return lokeshorderspage;
     }
}
