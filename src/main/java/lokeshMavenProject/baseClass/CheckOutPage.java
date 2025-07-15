package lokeshMavenProject.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractClass;

public class CheckOutPage extends AbstractClass
{
    WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy (css="input[placeholder='Select Country']")
	WebElement EnterCountry;
	
	@FindBy (xpath="//section/button")
	List<WebElement> countryList;
	
	@FindBy (css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	By sbtButton = By.cssSelector(".btnn.action__submit.ng-star-inserted");
	
	public OrderPlacedPage OpenCheckOutPage()
	{
	  EnterCountry.sendKeys("Ind");
	  List<WebElement> countryCode = countryList;
	  WebElement selectCountry = countryCode.stream().filter(country-> country.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
	  selectCountry.click();
	  driver.manage().window().setSize(new Dimension(1440, 900));
	  waitForElementToAppear(sbtButton);	 
	  submit.click();
	  return new OrderPlacedPage(driver);
}
  }