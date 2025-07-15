package lokeshMavenProject.seleniumFrameWork1;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractComponents.LokeshOrdersPage;
import lokeshMavenProject.TestComponents.BaseTests;
import lokeshMavenProject.baseClass.CartPage;
import lokeshMavenProject.baseClass.CheckOutPage;
import lokeshMavenProject.baseClass.LokeshHomePage;
import lokeshMavenProject.baseClass.OrderPlacedPage;

public class SubmitOrder extends BaseTests {

 	
	String mail="busilokesh143@gmail.com";
    String password = "Hanuman@15091998";
    String productName = "ZARA COAT 3";
   
    
    @Test   (dataProvider="getData", groups="purchaseOrder")
       public void productValidation(HashMap<String,String> input) throws IOException
       {	   
		LokeshHomePage lokeshhomepage =  lokeshlandingpage.loginApplication(input.get("userName"), input.get("password"));
		  lokeshhomepage.selectProductList(input.get("product"));
		  CartPage cartpage =  lokeshhomepage.selectProduct(input.get("product"));
		  boolean flag = cartpage.openCartPage(input.get("product"));
		  Assert.assertTrue(flag);
		 CheckOutPage checkOutPage = cartpage.goToCheckOutPage();
		  OrderPlacedPage orderPlacedPage = checkOutPage.OpenCheckOutPage();
		   String confirmMessage = orderPlacedPage.orderPlaced();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	     }
        
        
        @Test(dependsOnMethods= {"productValidation"})
        public void viewOrdersPage()
        {
        	LokeshHomePage lokeshhomepage =  lokeshlandingpage.loginApplication(mail, password);
             LokeshOrdersPage	lokeshorderspage = lokeshhomepage.goToOrdersPage();
             Assert.assertTrue(lokeshorderspage.VerifyOrderPage(productName));
        }
        
        @DataProvider
        public Object[][] getData() throws IOException
        {
        /*	
        	HashMap<String,String> map = new HashMap<String,String>();
        	map.put("userName","busilokesh143@gmail.com" );
        	map.put("password", "Hanuman@15091998");
        	map.put("product", "ZARA COAT 3");
			
        	HashMap<String,String> map1 = new HashMap<String,String>();
        	map1.put("userName","busilokesh007@gmail.com");
        	map1.put("password", "Hanuman@15091998");
        	map1.put("product", "ZARA COAT 3");
        	
        	HashMap<String,String> map = new HashMap<String,String>();
        	HashMap<String,String> map1 = new HashMap<String,String>();
   */
        	List<HashMap<String,String>> data= getJsonData(System.getProperty
		               ("user.dir")+"\\src\\test\\java\\dataFiles\\PurchaseOrderData.json");
        	return new Object[][] {{data.get(0)},{data.get(1)}};
        	
        //	return new Object[][] {{"busilokesh143@gmail.com","Hanuman@15091998","ZARA COAT 3"},{"busilokesh007@gmail.com","Hanuman@15091998","ZARA COAT 3"}};
        }
}
