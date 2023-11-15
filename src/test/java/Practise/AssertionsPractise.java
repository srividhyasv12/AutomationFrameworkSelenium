package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractise {
@Test
public void practise()
{
	System.out.println("step 1");
	System.out.println("step 2");
	Assert.assertEquals(2    , 1);//1==>actual data//1==>expected data
	System.out.println("step 3");
	
}
@Test
public void practice1()
{
	SoftAssert sa = new SoftAssert();
	System.out.println("step 1");
	//Assert.assertTrue(true);//p
	sa.assertEquals(true, false);
	System.out.println("step 2");

	
	sa.assertEquals("8", "b");
	Assert.assertTrue(false);//f
	System.out.println("step 3");
	sa.assertAll();//all failures are logged
}
}
