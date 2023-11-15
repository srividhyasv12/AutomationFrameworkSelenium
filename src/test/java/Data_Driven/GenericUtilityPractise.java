package Data_Driven;

import java.io.IOException;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.javaUtility;
public class GenericUtilityPractise {
public static void main(String[] args) throws IOException {
	

		//test script
	PropertyFileUtility pUtil =new PropertyFileUtility();
	String value = pUtil.readDataFromPropertyFile("abc");
	System.out.println(value);
	String value1 = pUtil.readDataFromPropertyFile("password");
	System.out.println(value1);
	
	
	javaUtility jUtil  = new javaUtility();
	String date = jUtil.getsystemDateInFormat();
	System.out.println(date);
	
	int ran = jUtil.getRandomNumber();
	 System.out.println(ran);
	 
	 ExcelFileUtility eUtil = new  ExcelFileUtility();
	 String orgname = eUtil.readDataFromExcel("Organizations", 1, 2);
	String orgnamewithrandom =orgname+ran;
	
	 System.out.println(orgname);
	 System.out.println(orgnamewithrandom);
}}