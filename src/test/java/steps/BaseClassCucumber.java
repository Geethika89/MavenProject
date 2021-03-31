package steps;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BaseClassCucumber {

	public static ChromeDriver driver;
/****************static is used so that the driver session id ill be passed on to different classes
 * from the same memory space*********************A different base class is used because to declare the 
 * public variable ...we need a class without steps
 */
	public static List<String> allhandles;
	SoftAssert softAssert = new SoftAssert();
	public static String leadID;
	
}
