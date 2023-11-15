package Data_Driven;

public class GenericMethodPractice {
public static void main(String[] args) {//caller function -values
	//test script
	int sum = add(20,30);//run only if called
	System.out.println(sum);
}
public static int add(int a,int b) {//called function
	int c = a+b;
	return c;
}
}

//step:1