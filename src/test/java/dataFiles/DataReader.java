package dataFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader 
{
   public List<HashMap<String, String>> getJsonDataToMap() throws IOException
   {
	   //to read convert the json file to string
	 String jsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir")
			 +"\\src\\test\\java\\dataFiles\\PurchaseOrderData.json"), StandardCharsets.UTF_8);
	 
	 //by using jackson databind dependecy convert string to map
	 
	 ObjectMapper mapper = new ObjectMapper();
	 List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>(){} );
      return data;
   }
}
