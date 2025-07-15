package lokeshMavenProject.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractClass;

public class CartPage extends AbstractClass
{    
     WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".cartSection h3")
	List<WebElement> productList;
	
	@FindBy (css=".totalRow button")
	WebElement select;
	
	
	
	public boolean openCartPage(String productName)
	{
		
		  boolean flag = productList.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(productName));
		  return flag;
	}
    
	public CheckOutPage goToCheckOutPage()
	{
		select.click();
		return new CheckOutPage(driver);
	}
}
