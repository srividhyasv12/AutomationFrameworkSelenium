package GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consist of generic method reated to java
 * @author srividhya
 * @param <SimpleDateFormat>
 *
 */
public class javaUtility {
	/**
	 * this method will return the current sysytem date in specified format
	 * @return
	 */
	public String getsystemDateInFormat() {
		
		Date d= new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate = formatter.format(d);
		return currentdate;
		
		
	}
	/**
	 * this method will return random numbers for every run
	 * @return
	 */
public int getRandomNumber() {
		Random r = new Random();
		int value = r.nextInt(1000);
	return value;
	}

}
