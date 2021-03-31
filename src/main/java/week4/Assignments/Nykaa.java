package week4.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

		public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		//Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		
		//Mouseover on Brands and Mouseover on Popular
	    WebElement mouseonbrand = driver.findElementByXPath("//a[text()='brands']");
		builder.moveToElement(mouseonbrand).perform();
		WebElement mouseonpopular = driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(mouseonpopular).perform();
		
		//Click L'Oreal Paris
		driver.findElementByXPath("//img[contains(@src,'lorealparis')]").click();
		
		//Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> allWidowHandle=driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(allWidowHandle);
		driver.switchTo().window(windowHandle.get(1));
		String title = driver.getTitle();
		System.out.println("the title is : " +title);
		
		//Click sort By and select customer top rated
		driver.findElementByXPath("//div[contains(@class,'sort')]/div[contains(@class,'clearfix')]").click();
		driver.findElementByXPath("//span[text()='customer top rated']//following-sibling::div[contains(@class,'radio')]").click();
		System.out.println("clicked on customer top rated");
		Thread.sleep(5000);
		
		//Click Category and click Shampoo
		builder.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined']//div)[1]").click();
		System.out.println("The shampoo is clicked");
		
		//check whether the Filter is applied with Shampoo
		String text = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']/li").getText();
		if(text.equalsIgnoreCase("Shampoo")) {
			System.out.println("Shampoo applied in filter");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("(//span[contains(text(),'Paris Colour Protect Shampoo')])[1]").click();
		Thread.sleep(5000);
		//GO to the new window and select size as 175ml
		Set<String> allWidowHandle2=driver.getWindowHandles();
		List<String> windowHandle2 = new ArrayList<String>(allWidowHandle2);
		System.out.println(windowHandle2);
		driver.switchTo().window(windowHandle2.get(2));
		Thread.sleep(6000);
		driver.findElementByXPath("//span[text()='175ml']").click();
		
		//Print the MRP of the product
		String mrp = driver.findElementByXPath("//span[@class='post-card__content-price-offer']").getText();
		System.out.println("The mrp of the product : " +mrp.replaceAll("\\D",""));
		
		// Click on ADD to BAG
		driver.findElementByXPath("//button[contains(@class,'combo-add-to-btn')]").click();
		Thread.sleep(5000);
		//Go to Shopping Bag 
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		Thread.sleep(6000);
		//Print the Grand Total amount
		String grandtotal = driver.findElementByXPath("//div[text()='Grand Total:']").getText();
				//div[@class='name medium-strong']/following-sibling::div[1]").getText();
		int  grandtot = Integer.parseInt(grandtotal.replaceAll("\\D",""));
		System.out.println("The grandtotal amount is : " +grandtot);
		Thread.sleep(5000);
		
		//Click Proceed
		driver.findElementByXPath(" //button[contains(@class,'btn full fill')]").click();
		Thread.sleep(5000);
		
		//Click on Continue as Guest
		WebElement guestbutton = driver.findElementByXPath("(//button[contains(@class,'btn full')])[2]");
		//builder.keyDown(guestbutton, "CONTINUE AS GUEST")
		//builder.moveToElement(guestbutton).perform();
		guestbutton.click();
		Thread.sleep(5000);
		
		//driver.findElementByXPath("(//button[@type='button'])[2]").click();
		System.out.println("Clicked on Continue as Guest button");
		
		//Check if this grand total is the same in step 13
		String grandtotalConfirm = driver.findElementByXPath("//div[contains(@class,'grand-total-cell')]//span").getText();
		int  finaltotal = Integer.parseInt(grandtotalConfirm.replaceAll("\\D",""));
		
		if(finaltotal==grandtot){
			System.out.println("The grand total is same" +grandtotalConfirm);
		}
		
		else {
			System.out.println("The amount does not match");
		}
		
	// Close all windows
		driver.close();
	}

}
