package lokeshMavenProject.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractComponents.AbstractClass;

public class LokeshLandingPage extends AbstractClass
{
	WebDriver driver;

   public LokeshLandingPage(WebDriver driver)
   {
	   super(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy (id="userEmail")
   WebElement userMail;
   
   @FindBy (id="userPassword")
   WebElement userPassword;
   
   @FindBy (id="login")
   WebElement login;
   
   @FindBy (css="[class*='flyInOut']")
   WebElement errorMessage;
  
   public void launchHomePage()
   {
	   driver.get("https://rahulshettyacademy.com/client"); 
	  
   }
   
   public String getErrorMessage()
   {
	   waitForWebElementToAppear(errorMessage);
	   return errorMessage.getText();
	  
   }
   
   public LokeshHomePage loginApplication(String userName, String password)
   {
	   userMail.sendKeys(userName);
	   userPassword.sendKeys(password);
	   login.click();
	   return new LokeshHomePage(driver);
   }
}
