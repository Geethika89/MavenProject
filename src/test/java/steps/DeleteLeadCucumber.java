package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DeleteLeadCucumber extends BaseClassCucumber{
	public static String leadID;
	// Enter the username as <username>
	//Enter the password as <password>
	// Click login button
	// Homapage should be displayed
	// Click crmsfa Link
	// My Homepage should be displayed
	// Click Leads link
	// My Leads page should be displayed
	//Click Find Leads Button
	//  Find Leads page should be displayed
	// Click phone tab under Find by section
	
	@Given("Enter the phone number for delete Lead as {string}")
	public void enterPhoneNumberforDelete(String PhnNum){
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(PhnNum);
	}
	
	//Click Find Leads link
	
	@When("Get the lead Id and click it")
	public void clickResultingLead(){
		leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	}
		
	//View leads page should be displayed 
	
	@When("Click the Delete button")
	public void clickDeleteButton(){
		driver.findElementByLinkText("Delete").click();
	}
	
	//My Leads page should be displayed
	//Click Find Leads Button
	@Given("Enter Captured LeadId")
	public void enterDeletedLeadId() {
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
	}
	
	//Click Find Leads link
	@Then("verify the text message displayed after succesfull Deletion")
	public void verifyMessageAfterDeletion() {
		softAssert.assertEquals(driver.findElementByClassName("x-paging-info").getText(), "No records to display");
		System.out.println("Delete Lead successfull");
	
	}

}
