package GenericUtilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of re_usable methods related to property file
 * @author srividhya


 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from property file for he key provided by caller
	 * and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException 
	
	
	 */
public String readDataFromPropertyFile(String key) throws IOException   {
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
}
}
//single line comment
/*multi line comment*/