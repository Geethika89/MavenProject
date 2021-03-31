package steps;

import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadCucumber extends BaseClassCucumber{
	String oldCompanyName;
	/*@Given("Load the application url")
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
	
	@But("Error message should be displayed")
	public void errorMessage() {
		System.out.println("Error message is displayed");
	
	}
	
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
	}*/
	
	@When("Click Find Leads link")
	public void clickFindLeadsLink() {
		driver.findElementByLinkText("Find Leads").click();		
	}
	
	@Then("Find Leads page should be displayed")
	public void verifyFindLeadsPage() {	
		String title = driver.getTitle();
		softAssert.assertTrue(title.equalsIgnoreCase("Find Leads"));
	}
	
	@When("Click phone tab under Find by section")
	public void clickPhonetab() {
		driver.findElementByXPath("//span[text()='Phone']").click();
	}
	
	@Given("Enter the phone number as {string}")
	public void enterPhoneNo(String phoneNum) {
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNum);
	}
	
	@When("Click Find Leads button")
	public void clickFindLeadsButton() {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}
	
	@Then("The correspondig Leads List should be displayed with phone number")
	public void verifyResultingList() throws InterruptedException {
	System.out.println("The resulting leads list should be displayed");
	Thread.sleep(3000);
	}
	
	@When("Click the first displayed Lead")
	public void clickFirstDisplayedLead() throws InterruptedException {
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		Thread.sleep(3000);
	
	}
	/*@Then("View leads page should be displayed")
	public void verifyEditviewLeadspage() {
		softAssert.assertTrue(driver.findElementByXPath("//div[@class='x-panel-header sectionHeaderTitle']").getText().equalsIgnoreCase("View Leads"));
		
	}*/
	
	@Then("Get the old Company Name")
	public void getOldComapnyName() {
		String oldCompanyName = driver.findElementById("viewLead_companyName_sp").getText().replaceAll("^[a-z][A-Z]","");
	
	}
	@When("Click Edit button")
	public void clickEdit() {
		driver.findElementByLinkText("Edit").click();
	}
	
	@Then("Edit Lead page should be displayed")
	public void verifyEditLeadPage() {
		softAssert.assertTrue(driver.findElementByXPath("//div[@class='x-panel-header sectionHeaderTitle']").getText().equalsIgnoreCase("Edit Lead"));
	}
	
	@When("Replace the Company Name as {string}")
	public void replaceCompanyName(String newCompanyName) {
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys(newCompanyName);
	}
	
	@When("Click Update button")
	public void clickUpdateButton() {
		driver.findElementByName("submitButton").click();	
	}
	
	@When("Updated View leads page should be displayed")
	public void updatedLeadsPage() {
		softAssert.assertTrue(driver.findElementByXPath("//div[@class='x-panel-header sectionHeaderTitle']").getText().equalsIgnoreCase("View Leads"));
	}
	
	@Then("Valiadte the updated company name is updated to {string}")
	public void validateUpdatedCompanyName(String newCompanyName) {
	softAssert.assertEquals(newCompanyName, driver.findElementById("viewLead_companyName_sp").getText().replaceAll("^[a-z][A-Z]",""));
	
	System.out.println("The company name is updated to  "+newCompanyName);
	}
	

}
