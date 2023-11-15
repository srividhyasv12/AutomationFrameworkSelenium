package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is a Implementation class of IRetryanalyse interface of TestNG
 * @author rajes
 *
 */
public  class RetryAnalyserImplementation  implements IRetryAnalyzer{
int count = 0;
int retrycount = 3;//manual   analysis
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<3fail
		while(count<retrycount)
		{
			count++;//1 2 3
			return true;//retry retry retry
		}
		return false;//stop  the retrying 
	}

}
