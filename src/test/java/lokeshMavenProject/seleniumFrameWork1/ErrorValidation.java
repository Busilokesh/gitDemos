package lokeshMavenProject.seleniumFrameWork1;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import lokeshMavenProject.TestComponents.BaseTests;
import lokeshMavenProject.baseClass.CartPage;
import lokeshMavenProject.baseClass.CheckOutPage;
import lokeshMavenProject.baseClass.LokeshHomePage;
import lokeshMavenProject.baseClass.OrderPlacedPage;

public class ErrorValidation extends BaseTests {


	 @Test(groups= {"ErrorHandling"})
    public void startExecution() throws IOException
    {
	    	String mail="busilokesh143re@gmail.com";
		    String password = "Hanuman@15091998";
		    String productName = "ZARA COAT 3";
	    	
      //LaunchApplication
		   
	  // LokeshLandingPage lokeshlandingPage =  LaunchApplication();
	   
	  lokeshlandingpage.loginApplication(mail, password);
	  Assert.assertEquals("Incorrect email or password.",lokeshlandingpage.getErrorMessage());

     }
	    
	    public void productValidation() throws IOException
	    {
		    	String mail="busilokesh143@gmail.com";
			    String password = "Hanuman@15091998";
			    String productName = "ZARA COAT 3";
		   
		LokeshHomePage lokeshhomepage =  lokeshlandingpage.loginApplication(mail, password);
		  lokeshhomepage.selectProductList(productName);
		  CartPage cartpage =  lokeshhomepage.selectProduct(productName);
		  boolean flag = cartpage.openCartPage(productName);
		  Assert.assertTrue(flag);
		 CheckOutPage checkOutPage = cartpage.goToCheckOutPage();
		  OrderPlacedPage orderPlacedPage = checkOutPage.OpenCheckOutPage();
		   String confirmMessage = orderPlacedPage.orderPlaced();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	     }
}
