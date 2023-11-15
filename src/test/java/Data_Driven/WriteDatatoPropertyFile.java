package Data_Driven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDatatoPropertyFile {
public static void main(String[] args) throws IOException, Throwable {
/*	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);

String value = p.getProperty("browser");
System.out.println(value);
	
String value1= p.getProperty("username");
System.out.println(value1);	*/



Properties p= new Properties();
p.setProperty("username", "admin");
p.setProperty("password", "admin");
FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\write.properties",true);
p.store(fos, "new file created");
System.out.println("Property file created");


}
}
