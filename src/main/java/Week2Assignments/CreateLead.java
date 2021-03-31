package Week2Assignments;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day1.BaseTest;
import testng.day2.LearnExcel;

public class CreateLead extends BaseTest {

	@Test(dataProvider = "fetchData")
	public  void runCreateLead(String Company,String fname, String lname)  {
			
		//String title = driver.getTitle();
		
		//System.out.println(title);
		/*WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();*/
		driver.findElementByLinkText("Create Lead").click();
		
		//driver.findElementById("createLeadForm_companyName").sendKeys("NoCompany");
		driver.findElementById("createLeadForm_companyName").sendKeys(Company);
		
		//driver.findElementById("createLeadForm_firstName").sendKeys("Geethika");
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		
		//driver.findElementById("createLeadForm_lastName").sendKeys("Gokul");
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		
		
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select dropdown1 = new Select (source);
		dropdown1.selectByVisibleText("Employee");
		
		
		WebElement marketingId = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdown2 = new Select(marketingId);
		dropdown2.selectByValue("9001");
		
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropdown3 = new Select(ownership);
		dropdown3.selectByIndex(5);
		
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdown4 = new Select(country);
		dropdown4.selectByVisibleText("India");
		
		driver.findElementByName("submitButton").click();
		
		String title2 = driver.getTitle();	
		System.out.println("The title of the page is  ;  " + title2);
		
	}
	
	/*@DataProvider(name = "fetchData")
	public String[][] dataSetup() throws IOException {
		LearnExcel le = new LearnExcel();
		
		
		/*	String[][] data = new String[1][3];
		data[0][0] = "NoCompany";
		data[0][1] = "Geethika";
		data[0][2] = "Gokul";
		
		return le.excelRead();*/
		
	}


