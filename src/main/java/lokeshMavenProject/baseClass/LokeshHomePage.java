package lokeshMavenProject.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractClass;

public class LokeshHomePage extends AbstractClass
{
    WebDriver driver;
    
    public LokeshHomePage(WebDriver driver)
    {
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy (css=".mb-3")
    List<WebElement> products; 
    
    @FindBy (css=".ng-animating")
    WebElement toastContainer;
    
    @FindBy (css="[routerlink*='cart']")
    WebElement click;
    
    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.xpath("//div/button[text()=' Add To Cart']");
    By spinner = By.xpath("//div[@aria-label='Product Added To Cart']");
    
    public List<WebElement> getProductList()
    {
       waitForElementToAppear(productsBy);
    	return products;
    	
    }
    
    public WebElement selectProductList(String productName)
    {
    	WebElement prod = getProductList().stream().filter(product -> 
    	product.findElement(By.tagName("b")).getText().equals(productName)).findAny().orElse(null);
     	 	return prod;
    }
    
    public CartPage selectProduct(String productName)
    {
    	 WebElement prod = selectProductList(productName);
    	 prod.findElement(addToCart).click();
    	 waitForElementToAppear(spinner);
    	 waitForElementToDisappear(toastContainer);
    	 click.click();
       return new CartPage(driver);
    }
  
   
}
