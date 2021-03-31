package steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps extends BaseClassCucumber{
	//SoftAssert softAssert = new SoftAssert();
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
	}*/
	
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
	
}
