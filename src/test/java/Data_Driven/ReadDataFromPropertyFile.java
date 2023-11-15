package Data_Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	
	
///step:1 open the document in java readable format
FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

//step 2:create an object of properties class from java.util package
Properties p = new Properties();

//stem load tht inputstream into properties
p.load(fis);

//step4:provide the keys to read the values
String value = p.getProperty("browser");
System.out.println(value);
	
String value1= p.getProperty("username");
System.out.println(value1);	
}
}
