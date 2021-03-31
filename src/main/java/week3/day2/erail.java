package week3.day2;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class erail {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://erail.in/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement fromStation = driver.findElementById("txtStationFrom");
		fromStation.clear();
		fromStation.sendKeys("ms");
		fromStation.sendKeys(Keys.TAB);
		
		WebElement toStation = driver.findElementById("txtStationTo");
		toStation.clear();
		toStation.sendKeys("mdu");
		toStation.sendKeys(Keys.TAB);
		
		driver.findElementById("chkSelectDateOnly").click();
		Thread.sleep(2000);
		
		List<WebElement> rows= driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		System.out.println("Number of trains including duplicates" +rows.size());
		//List<String> listtrainName = new ArrayList<String>();
			
		List<WebElement> trainName = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
		
		Set<String> listtrainName = new LinkedHashSet<String>();
		System.out.println("The list of train names without duplicates:");
				for (WebElement web : trainName) {
			listtrainName.add(web.getText());
			System.out.println(web.getText());
		}
		
		System.out.println("Train numbers without duplicates : " +listtrainName.size());
		System.out.println("The total list of trains without duplicates : ");
		for (String s2 : listtrainName) {
			
			System.out.println(s2);
		}
		
		driver.close();
	}

}
