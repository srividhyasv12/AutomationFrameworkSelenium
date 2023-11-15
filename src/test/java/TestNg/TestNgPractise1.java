package TestNg;

import org.testng.annotations.Test;

public class TestNgPractise1 {//INNVOCATION COUNT

public class TestNGPractice {
@Test(invocationCount = -1)//invocation -1 means disable
public void createCustomer()

{
System.out.println("create");	
//Assert.fail();
}

@Test(invocationCount = 4)
public void modiCustomer()

{
System.out.println("modify");	

}

@Test(invocationCount = 2,priority = 0)
public void deleteCustomer()

{
System.out.println("delete");	

}

}
}
