package week3.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch the browser
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		//To stop unwanted alertbox/popup
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---disable-notification");
		options.merge(cap);
		Thread.sleep(3000);
		ChromeDriver driver=new ChromeDriver(options);
		
		//Go to the https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		//Choose "Koyambedu, Chennai" in FROM field
		 driver.findElementByXPath("//input[@id='src']").sendKeys("Koyambedu, Chennai");
		 Thread.sleep(3000);
		 driver.findElementByXPath("//input[@id='src']").sendKeys(Keys.TAB);
		 
		 //Choose "Madurai (All Locations)" in TO field
		 WebElement dest = driver.findElementByXPath("//input[@id='dest']");
		 dest.sendKeys("Madurai (All Locations)");
		 Thread.sleep(3000);
		 dest.sendKeys(Keys.TAB);
		 
		 //Select a day next to your current date from the calender
		 driver.findElementById("onward_cal").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("//td[@class='current day']//following::td").click();
		 Thread.sleep(3000);
		 
		 //Click "Search Buses"
		 driver.findElementById("search_btn").click(); 
		 Thread.sleep(3000);
		 
		 //Print the number of buses available. (seen at the right top as "....BusesFound"). Try printing the number alone from the whole string.
		 String text = driver.findElementByXPath("//div[@class='section-msg']//span[1]").getText();
		 System.out.println("The number of buses availale are");
		 System.out.println(text.replaceAll("[a-z]", ""));
		 Thread.sleep(3000);
		 
		 //Print the unique travels names ( ie, without duplication)
		//List<WebElement> element = driver.findElementsByXPath("//ul[@class='bus-items']//div[contains(@class,'travels lh-24')]");
		List<WebElement> noofBuses = driver.findElementsByXPath("//div[contains(@class,'travels')]");
		 Thread.sleep(8000);
		
		List<String> busList = new ArrayList<String>();
		for (WebElement buses : noofBuses) {
			busList.add(buses.getText());
			//System.out.println(busList);
		}
		Thread.sleep(3000);
		
		Set<String> busNoDuplicate = new LinkedHashSet<String>(busList);
		System.out.println("The list of buses without duplicates are");
		for (String travelsnoDup : busNoDuplicate) {
			System.out.println(travelsnoDup);
		}
		
		Thread.sleep(3000);
		System.out.println("The number of buses are :  "  +busList.size());
		System.out.println("The number of buses without duplicates are : "  +busNoDuplicate.size());
		System.out.println("The list of number of buses with duplicates are : ");
		Thread.sleep(3000);
		for (String string : busList) {
			System.out.println(string);
		}
		
		driver.findElementByXPath("//i[contains(@class,'icon-close')]").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//i[contains(@class,'icon-close')]").click();
		Thread.sleep(6000);
		
		driver.findElementByXPath("//div[text()='View Seats']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//i[contains(@class,'icon-close')]").click();
		Thread.sleep(3000);
		
		Date date=new Date();
		String strDate=date.toString();
		String dateToAppend=strDate.replaceAll(":", "");
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/redbus"+dateToAppend+".png");
		FileUtils.copyFile(source, target);
		
		System.out.println("The screenshot are available");
		driver.close();
	}

}









/* Date date = new Date();
String todate= date.toString();
System.out.println(todate);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.add(Calendar.DATE, 1);
date=calendar.getTime();
System.out.println(date);
String tommorowsDate = new SimpleDateFormat("dd-MM-YYYY").format(date); 
System.out.println(tommorowsDate);
Thread.sleep(3000);*/
