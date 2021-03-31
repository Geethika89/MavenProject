package week4.Assignments;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		//Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		
		// Mouse over on WOMEN
		WebElement women = driver.findElementByXPath("//a[@href='/shop/women']");
		builder.moveToElement(women).perform();
		
		//Click Jackets & Coats
		driver.findElementByXPath("//li[@data-reactid='232']/a[contains(text(),'Jackets')]").click();
		Thread.sleep(3000);
		
		//Find the total count of item 
		String text = driver.findElementByXPath("(//span[contains(@class,'title')])[1]").getText();
		//String string = text.replaceAll("\\D","");
		//System.out.println(string);
		int totalCount = Integer.parseInt(text.replaceAll("\\D",""));
		System.out.println("The total count displayed : " +totalCount);
		
		//Validate the sum of categories count matches
		String jacket = driver.findElementByXPath("(//span[contains(@class,'categories')])[1]").getText();
		String coat = driver.findElementByXPath("(//span[contains(@class,'categories')])[2]").getText();
		String countJacket = jacket.replaceAll("\\D", "");
		//String countCoat = coat.replaceAll("\\D","");
		int count1 = Integer.parseInt(countJacket);
		int count2 = Integer.parseInt(coat.replaceAll("\\D",""));
		System.out.println("The count of Jackets in categories section displayed : " +count1);
		System.out.println("The count of coats in categories section displayed : " +count2);
		int categoriescount = count1 + count2;{
		if(totalCount==categoriescount) {
			System.out.println("The total count matches with the sum of categories");
		}
		
		else {
		System.out.println("The count does not match");
		}
		}
		
		
		//Check Coats
		driver.findElementByXPath("(//div[contains(@class,'checkboxIndicator')])[2]").click();
		Thread.sleep(6000);
		
		// Click + More option under BRAND	
		WebElement brandplus = driver.findElementByXPath("//ul[contains(@class,'brand')]/following-sibling::div[contains(@class,'brand')]");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(brandplus));
		brandplus.click();
		
		//Type MANGO and click checkbox
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		driver.findElementByXPath("//span[contains(@class,'FilterDirectory')]//following-sibling::div[contains(@class,'checkboxIndicator')]").click();
		
		//Close the pop-up
		driver.findElementByXPath("//span[contains(@class,'close sprites')]").click();
		Thread.sleep(5000);
		
		// Confirm all the Coats are of brand MANGO
		List<WebElement> brandnames = driver.findElementsByXPath("//h3[text()='MANGO']");
		//System.out.println(brandnames.size());
		int count=0;
		for(int i=0;i<brandnames.size();i++) {
			if(brandnames.get(i).getText().contentEquals("MANGO")) {
				count=count+1;	
			}
		}
		String text2 = driver.findElementByXPath("//input[@value='MANGO']//following-sibling::span[contains(@class,'brand')]").getText();
		int Mangocategorycount = Integer.parseInt(text2.replaceAll("\\D", ""));{
		if(count ==Mangocategorycount) {
			System.out.println("All dresses displayed are from brand MANGO  :  " +Mangocategorycount);
		}
		else {
			System.out.println("The brand names are different from MANGO");
		}
		
		}
		
		
		Thread.sleep(5000);
		//Sort by Better Discount
		Actions builder2= new Actions(driver);
		WebElement recommended = driver.findElementByXPath("//span[text()='Recommended']");
		builder2.moveToElement(recommended).perform();
		
		
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(2000);
		
		//Find the price of first displayed item
		String firstProductPrice = driver.findElementByXPath("(//span[contains(@class,'discountedPrice')])[1]").getText();
		System.out.println("The price of first product is : " +firstProductPrice);
		
		//Mouse over on size of the first item
		WebElement mouseover = driver.findElementByXPath("(//h3[text()='MANGO'])[1]");
		builder.moveToElement(mouseover).perform();
		
		WebElement size = driver.findElementByXPath("(//span[contains(text(),'XS,')])[1]");
		builder.moveToElement(size).perform();
		System.out.println("Mouse moved to size");
		
		//Click on WishList Now
		WebElement wishlist = driver.findElementByXPath("//div[contains(@class,'actions')]//span[contains(@class,'wishlist')]");
		wishlist.click();
		System.out.println("wishlist clicked");
		
		// Close Browser
			driver.close();		
	}

}
