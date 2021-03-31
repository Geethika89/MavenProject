package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadCucumber extends BaseClassCucumber{
/*public ChromeDriver driver;
	
	@Given("Open Chrome Browser")
	public void openBrowser() {
	WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@Given("Load the application url")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/");
	}
	
	@Given("Enter the username as {string}")
	public void enterUsername(String username) {
		driver.findElementById("username").sendKeys(username);
	}
	
	@Given("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
	}

	@When("Click login button")
	public void clickLogin() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Then("Homapage should be displayed")
	public void verifyHomepage() {
		boolean crmlink = driver.findElementByLinkText("CRM/SFA").isDisplayed();
		Assert.assertTrue(crmlink);
	}
	
	/*@But("Error message should be displayed")
	public void errorMessage() {
		System.out.println("Error message is displayed");
	
	}*/
	
	@When("Click crmsfa Link")
	public void clickCrmsfaLink() {
		driver.findElementByLinkText("CRM/SFA").click();
	}
	
	@Then("My Homepage should be displayed")
	public void verifyMyHomepage() {
		System.out.println("My Home page is displayed");
	}
	
	@When("Click Leads link")
	public void clickLeadslink() {
		driver.findElementByLinkText("Leads").click();	
	}
	
	@Then("My Leads page should be displayed")
	public void verifyMyLeadspage() {
		System.out.println("My leads page is displayed");
	}
	
	@When("Click Create Lead link")
	public void clickCreateLeadlink() {
		boolean displayed = driver.findElementByLinkText("Create Lead").isDisplayed();
		Assert.assertTrue(displayed);
		driver.findElementByLinkText("Create Lead").click();
		 softAssert.assertAll();
		
	}
	
	@Then("Create Lead page should be displayed")
	public void verifyCreateLeadpage() {
		String title = driver.getTitle();
		System.out.println("The title of create lead page dislayd is : "+title);
	}
	
	@Given("Enter the company name as {string}")
	public void enterCompanyName(String companyName) {
		driver.findElementById("createLeadForm_companyName").sendKeys(companyName);
	}
	
	@Given("Enter the first name as {string}")
	public void enterFirstName(String firstName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);
	}

	@Given("Enter the last name as {string}")
	public void enterLastName(String lastName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);
	}
	
	@When("Click create lead button")
	public void clickCreateLeadbutton(){
		driver.findElementByName("submitButton").click();
	}
	
	@Then("View leads page should be displayed")
	public void verifyviewLeadspage() {
		//String expecTitle  = "View leads";
		String expecTitle = "View Lead | opentaps CRM";
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(actualTitle, expecTitle);
		System.out.println("Actual and Expeted tile are same :  " +actualTitle);
		softAssert.assertAll();
		
	}
	
	@Then("Verify whether the view Lead page is displayed with given {string},{string},{string}")
	public void verifyLeadInformation(String companyName,String firstName,String lastName) {
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText().equalsIgnoreCase("View Lead"));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(companyName));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(firstName));
		softAssert.assertTrue(driver.findElement(By.id("viewLead_lastName_sp")).getText().equalsIgnoreCase(lastName));
		System.out.println("Successfully created lead information for "+firstName+" "+lastName+"with company name as" +companyName);
	}
	

}
