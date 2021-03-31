package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLeadCucumber extends BaseClassCucumber {
	public static String orginalFirstName;
	@When("Click Find Leads Button")
	public void clickFindLeadsButton() {
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
	}
		
	@When("Click On email in Find by section")
	public void clickEmailinFindBy() {
		driver.findElementByXPath("(//span[@class='x-tab-strip-text '])[3]").click();
	}
	
	@Given("Enter the email id as {string}")
	public void enterEmail(String emailId) {
		driver.findElementByName("emailAddress").sendKeys(emailId);
	}
	
	//Click Find Leads link
	
	@When("Cick the Resultin lead displayed with the respective mailid")
	public void clickResultingLeadEntry() {
		orginalFirstName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']").getText();
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a[@class='linktext']").click();
	}
	
	//View leads page should be displayed
	
	
	@When("Click Duplicate Lead button")
	public void clickDupicateLead() {
		driver.findElementByLinkText("Duplicate Lead").click();
	}
	
	@Then("Verify that the Duplicate Lead page is displayed")
	public void verifyDuplicateLeadTitle() {
		softAssert.assertTrue(driver.getTitle().equalsIgnoreCase("Duplicate Lead"));
		System.out.println("Displayed page is Duplicate Lead page");
	}
	
	@When("Click on create lead button in duplicate Lead page")
	public void clickCreateLeadDuplicateLeadPage() {
		driver.findElementByXPath("//input[@value='Create Lead']").click();
	}
	
	//View leads page should be displayed
	
	@Then("Verify whether the DuplicatedLeadFirstName is same as OriginalLeadFirstName")
	public void compareLeadNames() {
		
		String duplicatedLeadFirstName=driver.findElementById("viewLead_firstName_sp").getText();
		softAssert.assertEquals(duplicatedLeadFirstName, orginalFirstName);
		System.out.println("Duplicate entry for "+duplicatedLeadFirstName+" is created successfully");
	}

}
