package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test(priority=1)
public void createCustomer()

{
System.out.println("create");	
//Assert.fail();
}

@Test(priority=-3)
public void modiCustomer()

{
System.out.println("modify");	

}

@Test(priority=3)
public void deleteCustomer()

{
System.out.println("delete");	

}

}//ASCII value based Execution
//lower first
//HIGHRer next //////capitalhas less ascii value
//if we wont give priority considered to be as zero first priority
