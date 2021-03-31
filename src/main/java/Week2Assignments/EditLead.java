package Week2Assignments;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;

public class EditLead extends BaseTest{

	@Test
	public  void runEditLead() throws InterruptedException {
		
		//Launch browser
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
		driver.findElementByLinkText("Find Leads").click();
		
		//Enter firstname as gopi and click find leads button
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Gopi");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Click first displayed result
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a[text()='Gopi']").click();
		
	    //To Print Title	
		String title = driver.getTitle();
		System.out.println("The title of edit page is : " +title);
		
		//Click on Edit button
		driver.findElementByXPath("(//a[@class='subMenuButton'])[3]").click();
		
		//Change Company name
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("NoCompany");
		
		//Click update
		driver.findElementByClassName("smallSubmit").click();
		
		String companyName = driver.findElementById("viewLead_companyName_sp").getText();
		if(companyName.contains("NoComp")) {
			System.out.println("The company name is updated");
		}
		
		else {
			System.out.println("The company name is not updated");
		}
		
	//	driver.close();
	}

}		
		
		/*for(int i=3;i<=rows.size();i++) {
		
			String text = driver.findElementByXPath("(//table[@class='x-grid3-row-table']//tr["+ i +"]/td[1]").getText();
			System.out.println(text);
		}
		
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='x-grid3-row-table']//tr");
		System.out.println(rows.size());
		
		
		
		driver.findElementByXPath("//a[text()='Edit']/parent::div").click();
		
		driver.findElementById("updateLeadForm_companyName").clear();
		
		driver.findElementById("updateLeadForm_companyName").sendKeys("NewCompany");
		
		driver.findElementByXPath("//input[@value='Update']").click();
		
		WebElement updatedCName = driver.findElementById("viewLead_companyName_sp");
		System.out.println(updatedCName);*/

		

