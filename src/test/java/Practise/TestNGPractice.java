package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test
public void sampleTest()

{
System.out.println("hello!");	
Assert.fail();
}

@Test
public void sample1()

{
System.out.println("hi");	

}

@Test
public void sample2()

{
System.out.println("hey!");	

}

}
