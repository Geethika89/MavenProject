package TestLeaf;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testng.day1.BaseTest;

public class CreateLead extends BaseTest{
	
	@BeforeClass
	public void setFileName() {
		excelFileName="CreateLead";
	}
	
	@Test(dataProvider = "fetchData")

	public  void runCreateLead(String Company,String fname, String lname) {
		SoftAssert softAssert = new SoftAssert();
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();*/
		boolean leadlink = driver.findElementByLinkText("Leads").isDisplayed();
	
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		WebElement userfield = driver.findElementById("createLeadForm_companyName");
		userfield.sendKeys(Company);
		boolean userName = driver.findElementById("createLeadForm_companyName").isDisplayed();
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("submitButton").click();
		
		
		
		
		softAssert.assertTrue(leadlink);
		softAssert.assertTrue(userName);
		//softAssert.assertFalse(userName);
		//driver.close();
		//boolean name = driver.findElementById("viewLead_firstName_sp").isDisplayed();
		//softAssert.assertTrue(name);
		
		boolean actual = driver.findElementById("viewLead_firstName_sp").isDisplayed();
		
		 
		 softAssert.assertTrue(actual);
		 System.out.println("First Name of the created lead is displayed");
		 softAssert.assertAll();
}

	
	/*@DataProvider(name = "fetchData")
public String[][] dataSetup() throws IOException {
	LearnExcel le = new LearnExcel() ;
		return le.excelRead();
	/*	String[][] data = new String[1][3];
		data[0][0] = "NoCompany";
		data[0][1] = "Geethika";
		data[0][2] = "Gokul";
		
		return data;*/
		
	
	
}



