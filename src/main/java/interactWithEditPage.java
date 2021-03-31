//import java.awt.event.FocusListener;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

//import javax.swing.JTextField;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class interactWithEditPage {

	public static void main(String[] args) {
	
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		
		//anothr approach to load url
		//driver.navigate().to("enter the url");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println(title);

		
		driver.findElementById("email").sendKeys("geethikago@gmail.com");
		
		WebElement appendfield = driver.findElementByXPath("//label[text()='Append a text and press keyboard tab']/following-sibling::input");
		 appendfield.sendKeys("addit");
		
		System.out.println(driver.findElementByName("username").getAttribute("value"));
		
	 WebElement disabledfield = driver.findElementByXPath("//label[text()='Confirm that edit field is disabled']/following::input");
	 System.out.println(disabledfield.isEnabled());
		
	 WebElement clearfield = driver.findElementByXPath("(//input[@name='username'])[2]");
	 clearfield.clear();
		
		//driver.close();
		
	}

}
