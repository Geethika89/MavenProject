package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMousehover {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver  = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		
		WebElement mensfashion = driver.findElementByXPath("(//span[contains(text(),'Men')])[2]");
		builder.moveToElement(mensfashion).perform();
		
		driver.findElementByXPath("//span[text()='Loafers']").click();
		Thread.sleep(6000);
		
		WebElement loafer = driver.findElementByXPath("//i[contains(@class,'sd-icon sd-icon-like-outline')]");
		builder.moveToElement(loafer).perform();
		
		driver.findElementByXPath("//div[contains(@class,'center quick-view-bar')]").click();
		
		driver.findElementByXPath("(//div[contains(@class,'close')])[1]").click();
		System.out.println("loafer selected");
		
		driver.close();
		
	}

	
}
