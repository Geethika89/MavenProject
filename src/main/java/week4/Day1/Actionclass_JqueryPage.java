package week4.Day1;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionclass_JqueryPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver=new ChromeDriver();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.jqueryui.com");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Sortable").click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElementByXPath("//iframe[contains(@class,'demo')]"));
		System.out.println("we are inside the frame");
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		//js.executeScript("arguments[0].scrollIntoView();", item4);
		int x = item4.getLocation().getX();
		int y = item4.getLocation().getY();
	
	//js.executeScript("window.scrollBy(0,200)", "");
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		builder.dragAndDropBy(item1, x, y).perform();
		System.out.println("Done");
		
		} 

}
