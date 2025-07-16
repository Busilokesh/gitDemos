package lokeshMavenProject.seleniumFrameWork1;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import lokeshMavenProject.TestComponents.BaseTests;
import lokeshMavenProject.baseClass.CartPage;
import lokeshMavenProject.baseClass.CheckOutPage;
import lokeshMavenProject.baseClass.LokeshHomePage;
import lokeshMavenProject.baseClass.LokeshLandingPage;
import lokeshMavenProject.baseClass.OrderPlacedPage;

public class FinalExecution extends BaseTests {


	    @Test
    public void startExecution() throws IOException
    {
	    	String mail="busilokesh143@gmail.com";
		    String password = "Hanuman@15091998";
		    String productName = "ZARA COAT 3";
	    	
      //LaunchApplication
		   
	  // LokeshLandingPage lokeshlandingPage =  LaunchApplication();
	   
	LokeshHomePage lokeshhomepage =  lokeshlandingpage.loginApplication(mail, password);
	
	  //Home Page
	 // LokeshHomePage lokeshhomepage = new LokeshHomePage(driver);
	  lokeshhomepage.selectProductList(productName);
	  CartPage cartpage =  lokeshhomepage.selectProduct(productName);
	  
	  
	  //cart page
	 // CartPage cartPage = new CartPage(driver);
	  boolean flag = cartpage.openCartPage(productName);
	  Assert.assertTrue(flag);
	 CheckOutPage checkOutPage = cartpage.goToCheckOutPage();
	  
	  
	  //checkoutpage
	  //  CheckOutPage checkOutPage = new CheckOutPage(driver);
	 OrderPlacedPage orderPlacedPage = checkOutPage.OpenCheckOutPage();
	  
	  //orderPlaced page
	  
	  // OrderPlacedPage orderPlacedPage = new OrderPlacedPage(driver);
	   String confirmMessage = orderPlacedPage.orderPlaced();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
    }
	   public void xypersonMethod()
	    {
	    	System.out.println("Xperson pulled y person code");
	    	System.out.println("Xperson  modifed code");
	    	System.out.println("Xperson pushed code");
	    }
	    public void YpersonMethod()
	    {
	    	System.out.println("yperson pulled y person code");
	    	System.out.println("yperson  modifed code");
	    	System.out.println("yperson pushed code");
	    } 
	    public void ypersonMethod()
	    {
	    	System.out.println("yperson pulled y person code");
	    	System.out.println("yperson  modifed code");
	    	System.out.println("yperson pushed code");
	    }
	    public void yypersonMethod()
	    {
	    	System.out.println("yperson pulled y person code");
	    	System.out.println("yperson  modifed code");
	    	System.out.println("yperson pushed code");
	    }

     }

