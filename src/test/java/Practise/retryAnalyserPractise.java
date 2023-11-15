package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;





public class retryAnalyserPractise {


	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
Assert.fail();
		System.out.println("Hi");
		
	}
	
	@Test
	public void sample1()
	{
		System.out.println("Hello");
	}
	}
