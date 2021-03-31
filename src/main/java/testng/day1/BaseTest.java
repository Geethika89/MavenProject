package testng.day1;


import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import testng.day2.LearnExcel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public RemoteWebDriver driver;
	public String excelFileName;
	public SoftAssert softAssert;
	
  @Parameters({"browser","url","username","password"})
    
  @BeforeMethod
  public void preConditions(String browser, String url,String username,String password) {
	  
	  System.out.println("In BeforeMethod");
	
	  if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	  
		
		//String browser = edge;
	  	  
	  /***************** to add common browser steps */
	 // WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		//driver=new ChromeDriver();
	/**************************************************************/	
		//driver.get("http://leaftaps.com/opentaps/control/main");
		driver.get(url);
		
		driver.manage().window().maximize();
		//driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("username").sendKeys(username);
		
		//driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementById("password").sendKeys(password);
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In AfterMethod");
	  driver.close();
	 
  }
  
	@DataProvider(name = "fetchData")
    public String[][] dataSetup() throws IOException {
	LearnExcel le = new LearnExcel() ;
		
		return le.excelRead(excelFileName);
		
		
}

}
