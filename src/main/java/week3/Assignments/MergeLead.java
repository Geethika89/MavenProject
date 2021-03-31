package week3.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;


public class MergeLead extends BaseTest{

	@Test
	public  void runMergeLead() throws InterruptedException {
		
	/*	WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notification");
		options.merge(cap);
		Thread.sleep(3000);*/
		
	/*	ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
				//Enter the username
				driver.findElementById("username").sendKeys("demosalesmanager");
				
				//Enter the password
				driver.findElementById("password").sendKeys("crmsfa");
				
				//Enter login
				driver.findElementByClassName("decorativeSubmit").click();
				Thread.sleep(2000);
				//Click CRM/SFA link
				driver.findElementByLinkText("CRM/SFA").click();*/
				
				//Click on Leads link
				driver.findElementByLinkText("Leads").click();
				
				//Click Merge leads
				driver.findElementByLinkText("Merge Leads").click();
				Thread.sleep(3000);
				//Click on Icon near From Lead
				driver.findElementByXPath("//input[@id='partyIdFrom']/following-sibling::a").click();
				
				//Move to new window
				Set<String> allwindows = driver.getWindowHandles();
				List<String> windowHandle = new ArrayList<String>(allwindows);
				driver.switchTo().window(windowHandle.get(1));
				driver.manage().window().maximize();
				
				String title = driver.getTitle();
				System.out.println("the title is : " +title);
				
				//Enter Lead ID
				driver.findElementByXPath("//input[@name='id']").sendKeys("10166");
				
				//Click Find Leads button
				driver.findElementByXPath("//td[@class='x-btn-center']").click();
				Thread.sleep(3000);
				
				//Click First Resulting lead
				driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr//a[@class='linktext']").click();
				
				//Switch back to primary window
				driver.switchTo().window(windowHandle.get(0));
				Thread.sleep(3000);
				
				//Click on Icon near To Lead
				driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
				
				//Move to new window
				Set<String> allwindows2 = driver.getWindowHandles();
				List<String> windowHandle2 = new ArrayList<String>(allwindows2);
				driver.switchTo().window(windowHandle2.get(1));
				driver.manage().window().maximize();
				
				// Enter Lead ID
				driver.findElementByXPath("//input[@name='id']").sendKeys("10165");
				
				//Click Find Leads button
				driver.findElementByXPath("//td[@class='x-btn-center']").click();
				Thread.sleep(3000);
				
				//Click First Resulting lead
				driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr//a[@class='linktext']").click();
				
				//Switch back to primary window
				driver.switchTo().window(windowHandle2.get(0));
				Thread.sleep(3000);
				
				// Click Merge
				driver.findElementByXPath("//a[@class='buttonDangerous']").click();
				Thread.sleep(3000);
				
				//Accept Alert
				driver.switchTo().alert().accept();
				
				//Click Find Leads link
				driver.findElementByLinkText("Find Leads").click();
				
				//Enter From Lead ID
				driver.findElementByName("id").sendKeys("10166");
				
				//Click Find Leads button
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				Thread.sleep(3000);
				
				//Verify message "No records to display" in the Lead List. This message confirms that the successful merge of lead
				String text = driver.findElementByXPath("//div[text()='No records to display']").getText();
				
				if(text.contains("No records to display")) {
					System.out.println("The Merge Lead was successfull");
				}
				
				else {
					System.out.println("Unsuccesfull Merge Lead");
				}
				
				//Close the browser (Do not log out)
		
			//	driver.close();
	}

}
