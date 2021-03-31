import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class week3Assignments {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour());
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.merge(cap);
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.redbus.in/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@id='src']").sendKeys("Koyambedu, Chennai");
		
		driver.findElementByXPath("//input[@id='src']").sendKeys(Keys.TAB);
		
		driver.findElementByXPath("//input[@id='dest']").sendKeys("Madurai (All Locations)");
		
		driver.findElementByXPath("//input[@id='dest']").sendKeys(Keys.TAB);

	}

	private static String UnexpectedAlertBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

}
