package week4.Assignments;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Serivicenow {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		//Load ServiceNow application https://dev68594.service-now.com/
		driver.get("https://dev68594.service-now.com/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
			
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='gsft_main']"));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Enter username as “admin”
		driver.findElementById("user_name").sendKeys("admin");
		
		//Enter password as “India@123”
		driver.findElementByXPath("(//input[contains(@id,'password')])[1]").sendKeys("India@123");
		
		//Click Login
		driver.findElementByXPath("//button[text()='Login']").click();
		
		driver.switchTo().defaultContent();
		
		//Search “incident “ Filter Navigator
		WebElement filter = driver.findElementById("filter");
		filter.sendKeys("incident");
		//filter.sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		
		//Click “All”
		WebElement scroll = driver.findElementByXPath("(//div[text()='All'])[2]");
		scroll.click();
		Thread.sleep(2000);
		
		//Click New button
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='gsft_main']"));
		driver.findElementByXPath("//button[text()='New']").click();
		
		//Select a value for Caller and Enter value for short_description
		driver.findElementByXPath("(//button[contains(@id,'caller_id')])[1]").click();
		Thread.sleep(3000);
		Set<String> allwindowHandles= driver.getWindowHandles();
		List<String> windowhandle= new ArrayList<String>(allwindowHandles);
		driver.switchTo().window(windowhandle.get(1));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement callername = driver.findElementByXPath("//table[@id='sys_user_table']/tbody[1]/tr[4]/td[3]/a[1]");
		callername.click();
		Set<String> allwindowHandles1= driver.getWindowHandles();
		List<String> windowhandle1= new ArrayList<String>(allwindowHandles1);
		driver.switchTo().window(windowhandle1.get(0));
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='gsft_main']"));
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Selenium Learning");
		
		//Read the incident number and save it a variable
		String incidentnum = driver.findElementById("incident.number").getAttribute("value");
		System.out.println("The icident number is : " +incidentnum);
		
		//Click on Submit button
		driver.findElementById("sysverb_insert").click();
		Thread.sleep(5000);
		
		//: Search the same incident number in the next search screen as below
		//driver.find
		WebElement search = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		search.sendKeys(incidentnum);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		//: Verify the incident is created successful
		String confirmation = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(confirmation);
		{
		
		if(confirmation.equals(incidentnum)) {
			System.out.println("The new incident is created");
		}
		
		else {
			System.out.println("The incident is not created");
		}
		}
		
		driver.close();
	}

}
