package Week2Assignments;



import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class InteractWithDropdown {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		//anothr approach to load url
		//driver.navigate().to("enter the url");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//select dropdown option by index
		WebElement firstDropdown = driver.findElementById("dropdown1");
		Select dropdown1= new Select(firstDropdown);
		dropdown1.selectByIndex(1);
		
		//select dropdown option by visible text
		WebElement secondDropdown = driver.findElementByName("dropdown2");
		Select dropdown2=new Select(secondDropdown);
		dropdown2.selectByVisibleText("Appium");
		
		//select dropdown option by value
		WebElement thirdDropdown = driver.findElementByXPath("(//div[@class='example']//select)[3]");
		Select dropdown3=new Select(thirdDropdown);
		dropdown3.selectByValue("4");
		
		//select dropdown count the number of options
		Select count= new Select(driver.findElementByXPath("(//div[@class='example']//select)[4]"));
		List<WebElement> options= count.getOptions();
		System.out.println("The number of options in dropdown is:  " +options.size());
		
		//select dropdown by sending keys
		driver.findElementByXPath("(//div[@class='example']//select)[5]").sendKeys("APP");
		
		//to select multiple options from dropdown
		Select selDrop = new Select (driver.findElementByXPath("(//div[@class='example']//select)[6]"));
		if(selDrop.isMultiple()) {
			
			selDrop.selectByVisibleText("Selenium");
			selDrop.selectByVisibleText("UFT/QTP");
			
			
		}
		
		driver.close();
		
	}

}
