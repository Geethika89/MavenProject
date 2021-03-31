package steps;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MergeLeadCucumber extends BaseClassCucumber{
	
	
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
	
	
	@When("Click Merge Leads link")
	public void clickMergeLeads() {
		driver.findElementByLinkText("Merge Leads").click();
	}
	
	@Then("Merge Leads page should be displayed")	
	public void verifyMergeLeadspage() {
		softAssert.assertTrue(driver.getTitle().equalsIgnoreCase("Merge Lead"));
		System.out.println("The Merge Leads page is displyed");
	}
	
	@When("Click the icon near 'From Lead' input box")
	public void clickLookUpButtonforFromLead() {
		driver.findElementByXPath("//img[@alt='Lookup']").click();
	}

	@When("Validate if we can switch to new window")
	public void switchNewWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@Then("New Find Leads window should be displayed")
	public void displayFindLeadWindow() {
		softAssert.assertTrue(driver.getTitle().equalsIgnoreCase("Find Leads"));
		System.out.println("New Find Leads page is displayed");
	}
	
	@Then("Click a Lead from the lead list")
	public void clickResultingLead() throws InterruptedException {
		leadID = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[6]").getText();
		System.out.println("The lead is" +leadID);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[6]").click();
		Thread.sleep(3000);
	}
	
	@When("Navigate back to parent window")
	public void navigateToParentWindow() throws InterruptedException {
		driver.switchTo().window(allhandles.get(0));
		System.out.println("Back in Parent Window");
		Thread.sleep(3000);
	}
	
	//@Then("Merge Leads page should be displayed")
//	public void displayMergeLeadsPage() {
		
	//}
	
	@When("Click the icon near 'To Lead' input box")
	public void clickLookUpToField() {
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	}
	
//	@When("Validate if we can switch to new window")
//	public void switchtoNewWindow() {
//		Set<String> allWindows2 = driver.getWindowHandles();
	//	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	//	driver.switchTo().window(allhandles2.get(1));
//	}
		
/*	@Then("New Find Leads window should be displayed")
	public void displayFindLeadWindow() {
	
	}*/
	
	@When("Click a Reulting To Lead")
	public void clickToLead(){
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[5]").click();
	}
	// Navigate back to parent window

	@When("Click Merge button")
	public void clickMergeButton() {
		driver.findElementByXPath("//a[text()='Merge']").click();
	}
	
	@When("Click Ok in Alert")
	public void clickAcceptAlert() throws InterruptedException {
		driver.switchTo().alert().accept();
		//Thread.sleep(5000);
	}
	
	/*View leads page should be displayed
	 * Click Find Leads link
	 * Find Leads page should be displayed*/
	
	@When("Enter Lead Id")
	public void enterLeadId() {
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
	}
	
	/*Click Find Leads button*/
	
	@Then("verify the text message displayed after succesfull Merge")
	public void verifyMessageAfterMergeLeads() {
		softAssert.assertEquals(driver.findElementByClassName("x-paging-info").getText(), "No records to display");
		System.out.println("Merge Lead successfull");
	
	}
}
