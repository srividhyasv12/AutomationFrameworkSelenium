package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng3 {


@Test
public void createCustomer()

{
	Assert.fail();//fail
System.out.println("create");	
 
}

@Test(dependsOnMethods = "createCustomer")
public void modiCustomer()

{
System.out.println("modify");	

}

@Test
public void deleteCustomer()

{
System.out.println("delete");	

}
}
