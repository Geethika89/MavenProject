package Week2Assignments;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;

public class DuplicateLead extends BaseTest{

	@Test
	public  void runDuplicateLead() throws InterruptedException {
		//Launch the browser
		
	/*	WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Enter the username
		driver.findElementById("username").sendKeys("demosalesmanager");
		
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();*/
		
		//Click Leads link
		driver.findElementByLinkText("Leads").click();
		
		//Click Find leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
		
		//Click on Email
		driver.findElementByXPath("(//span[@class='x-tab-strip-text '])[3]").click();
		
		//Enter Email
		driver.findElementByName("emailAddress").sendKeys("DemoLeadA@DemoLeadA.com");
		
		//Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Capture name of First Resulting lead
		String text = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']").getText();
		System.out.println(text);
		
		//Click First Resulting lead
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a[@class='linktext']").click();
		
		//Click Duplicate Lead
		driver.findElementByLinkText("Duplicate Lead").click();
		
		//Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		{
			if(title.contains("Duplicate"))
					{
				System.out.println("Poper page Landing");
			}
			else
			{
				System.out.println("Landed page not proper");
			}	
		}
		//Click Create Lead
		driver.findElementByName("submitButton").click();
		
		//Confirm the duplicated lead name is same as captured name
		
		//driver.close();
		//Close the browser (Do not log out)
	}

	}

//driver.findElementById("createLeadForm_companyName").sendKeys("demoA");
