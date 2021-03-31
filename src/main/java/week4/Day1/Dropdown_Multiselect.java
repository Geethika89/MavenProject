package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Multiselect {

	@Test
	public  void runDropdownMultiselect() throws InterruptedException {
		
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class='example']//option");
		
		WebElement item1 = driver.findElementByXPath("//option[text()='Select your programs']//following::option[text()='Appium']");
		
		WebElement item2 = driver.findElementByXPath("//option[text()='Select your programs']//following::option[text()='Loadrunner']");
		
		Actions builder = new Actions(driver);
		
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();		
		
		driver.close();
	}

}
