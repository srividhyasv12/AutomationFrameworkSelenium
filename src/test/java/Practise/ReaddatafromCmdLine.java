package Practise;

import org.testng.annotations.Test;

public class ReaddatafromCmdLine {

	@Test
	public void read()
	{
	String UN = System.getProperty("username");
	String PWD = System.getProperty("password");
	
	System.out.println(UN);
	System.out.println(PWD);
	}
	
}
