package Week2Assignments;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;

public class DeleteLead extends BaseTest {

	@Test(enabled = false)
	public  void runDeleteLead() throws InterruptedException {
		
/*WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		//Enter the username
		driver.findElementById("username").sendKeys("demosalesmanager");
		
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Enter login
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();*/
		
		//Click on Leads link
		driver.findElementByLinkText("Leads").click();
		
		//Click findleads link
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
		
		//Click on Phone
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		//Enter phone number 99
		driver.findElementByXPath("//table[@class='x-table-layout']//input[@name='phoneNumber']").sendKeys("99");
		
		//Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Capture lead ID of First Resulting lead
		String text = driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr[1]/td[1]").getText();
		System.out.println(text);
		
		//Click First Resulting lead
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a[@class='linktext']").click();
		
		//Click Delete
		driver.findElementByClassName("subMenuButtonDangerous").click();
		
		//Click Find leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
		
		//Enter captured lead ID
		driver.findElementByXPath("//div[@class='x-form-element']/input[@name='id']").sendKeys(text);
		
		//Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text2 = driver.findElementByXPath("//div[@class='x-panel-bbar']//div[text()='No records to display']").getText();
		//System.out.println(text2);
			{
				if(text2.contains("No")) {
			
				System.out.println("No records to display");
			}
				else {
					System.out.println("Records are available");
				}
			}
		//Close the browser (Do not log out)*/
		//driver.close();
		

	}

}
