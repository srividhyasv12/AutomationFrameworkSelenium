package TestNg;

import org.testng.annotations.Test;

public class Testng2 {

public class TestNGPractice {
@Test(enabled = false)
public void createCustomer()

{
System.out.println("create");	
//Assert.fail();
}

@Test
public void modiCustomer()

{
System.out.println("modify");	

}

@Test
public void deleteCustomer()

{
System.out.println("delete");	

}
}}
