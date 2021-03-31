package week4.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMap_Erail {

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
		
		List<WebElement> trainName = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
		List<WebElement> trainNumber = driver.findElementsByXPath("//a[contains(@title,'Click on train number')]");
		
		Map<String, Integer> trains = new HashMap<String, Integer>();
		for( int i= 0; i<trainName.size();i++) {
			//System.out.println(trainName.get(i).getText());
			//System.out.println(trainNumber.get(i).getText());
			int trainval = Integer.parseInt(trainNumber.get(i).getText());
			trains.put(trainName.get(i).getText(), trainval);
		}	
		
			int biggestTrainNum= Integer.MIN_VALUE;
			for (Entry<String, Integer> compareTrain : trains.entrySet()) {
				 Integer traiNum = compareTrain.getValue();
				 biggestTrainNum = Math.max(biggestTrainNum, traiNum);
			}
			
			System.out.println(biggestTrainNum);
			for  (Entry<String, Integer> compareTrain : trains.entrySet()) {
				Integer traiNum = compareTrain.getValue();
				if(biggestTrainNum==traiNum) {
					System.out.println(compareTrain.getKey());
					break;
			}
		}	
	}

}
