package week4.Assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Justdial {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		//https://www.justdial.com/
		//driver.get("https://www.justdial.com/");
	//	driver.get("https://www.justdial.com/Chennai/search?q=Car-Repair-Services-Hyundai-Accent");
		driver.get("https://www.justdial.com/Chennai/Car-Repair-Services-Hyundai-Accent-in-Porur/nct-10961775");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		
		/*WebElement dropdown = driver.findElementById("city");
		dropdown.click();
		builder.moveToElement(driver.findElementByXPath("//li[@id='Chennai']")).click().perform();
		Thread.sleep(3000);
			
		// Click Auto Care in the left menu
		driver.findElementByXPath("//span[text()='Auto care']").click();
		Thread.sleep(2000);
		
		// Click Car Repair
		driver.findElementByXPath("//span[@title='Car Repair']").click();
		Thread.sleep(2000);
		
		//Click Car Brand as Hyundai
		driver.findElementByXPath("//span[@title='Hyundai']").click();
		Thread.sleep(2000);
		
		//Click Make as Hyundai Xcent
		driver.findElementByXPath("//span[@title='Hyundai Accent']").click();
		Thread.sleep(2000);
		
		//click on “All Options”
		driver.findElementByXPath("//span[@title='All Options']").click();
		Thread.sleep(2000);*/
		
	/*	Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> eachWindowHandle = new ArrayList<String>(allWindowHandles);
		System.out.println(eachWindowHandle);*/
		//Select Porur from the dropdown list
	driver.findElementByXPath("(//span[contains(@onclick,'closePopUp')])[4]").click();
	Thread.sleep(4000);
	/*driver.findElementByLinkText("Location").click();
		driver.findElementByXPath("//input[@id='sortbydist']").sendKeys("Porur");
		Thread.sleep(3000);
		driver.findElementByXPath("//button[@id='sortbydistbtn']").click();
		
		//Select Distance starting from 1 km
		driver.findElementByXPath("//i[contains(@class,'res_downarrowic')]").click();
		driver.findElementByXPath("//a[@id='dst1']").click();
		driver.findElementByLinkText("Submit").click();*/
	
		//Identify all the Service Center having Ratings >=4.5 and Votes >=50
	 System.out.println("Scrolling down to the end of ha page");
	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(7000);
		
		Map<String, Float> cars = new HashMap<String, Float>();
		
		List<WebElement> rating = driver.findElementsByXPath("//a[contains(@title,'Ratings')]//span[@class='green-box']");
		List<WebElement> carCenterNames = driver.findElementsByXPath("//div[@class=' col-sm-5 col-xs-8 store-details sp-detail paddingR0']//p[@class='newrtings ']"
				+ "//span[@class='green-box']/ancestor::p/preceding-sibling::h2//a");
		
		System.out.println("The number of ratings is : " +rating.size());
		System.out.println("The number of car centers : " +carCenterNames.size());
		
		for (int i=0;i<carCenterNames.size();i++) {
			//String availableCenters = carCenterNames.get(i).getText();
			//	System.out.println(availableCenters);
			/*To put names of centers with rating >4.5 with their names and pass it to map*/
			/*****************************************************************************************/
			
			if(Float.parseFloat(rating.get(i).getText())>=4.5) {
				 cars.put( carCenterNames.get(i).getText(),Float.parseFloat(rating.get(i).getText()));
			}			
		}
		List<String> listOfCenters = new ArrayList<String>();
		for (Entry<String, Float> highCarRating : cars.entrySet()) {
			listOfCenters.add(highCarRating.getKey());
			
		}
			
		System.out.println(listOfCenters);
		}

	
	
		/*
		
		12) Save all the Service Center name and Phone number matching the above condition in excel 
		13) Close the browser*/
		
		
	}


