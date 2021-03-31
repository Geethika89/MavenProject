package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks_Implementation extends BaseClassCucumber{
	
	@Before
	public void precondition() {
		WebDriverManager.chromedriver().browserVersion("89.0.4389.90").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		
	}
		
	@After
	public void postcondition() {
		driver.close();
	}

}
