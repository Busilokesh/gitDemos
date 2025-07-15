package lokeshMavenProject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lokeshMavenProject.baseClass.LokeshLandingPage;

public class BaseTests 
{
	public WebDriver driver;
	public LokeshLandingPage lokeshlandingpage;
	@Test
	public WebDriver initializeDriver() throws IOException
	{
	
		//Properties
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		//C:\Users\hp\Workspaces\SeleniumWorkSpace\seleniumFrameWork1\src\main\java\resources\GlobalData.properties
		properties.load(fis); 
		String browserName = properties.getProperty("browser");
				
	if(browserName.equals("chrome"))
	{
	  driver = new ChromeDriver();
	  //  WebDriver driver = new FirefoxDriver();
	  driver.get("https://www.google.com");
	 
	 
	 }
	
	else if(browserName.equals("firefox"))
	{
		//WebDriver driver = new ChromeDriver();
		 driver = new FirefoxDriver();
		  driver.get("https://www.google.com");
		
	}
	

      driver.manage().window().setSize(new Dimension(1440, 900));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	return driver;
	}	  
	  @BeforeMethod(alwaysRun=true)
	  public LokeshLandingPage LaunchApplication() throws IOException
	  {
		 driver = initializeDriver();
		 lokeshlandingpage = new LokeshLandingPage(driver);
		lokeshlandingpage.launchHomePage();
		return lokeshlandingpage;
	  }
	  
	  @AfterMethod(alwaysRun=true)
	  public void tearDown()
	  {
		  driver.close();
	  }

	  public List<HashMap<String, String>> getJsonData(String filePath) throws IOException
	  {
		  //convert jsondata to string
		  String jsonContent = FileUtils.readFileToString(new File(filePath),
				                StandardCharsets.UTF_8);
		  
		  //convert string to hashMap using jackson databind dependecies
		  ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		  return data;
	  }
}