package Week2Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithWebTable {
	public static void main(String[] args) {
		
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/table.html");
		
		//anothr approach to load url
		//driver.navigate().to("enter the url");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		rows.size();
		
		List<WebElement> cells = driver.findElementsByXPath("//table[@id='table_id']//tr[2]/td");
		System.out.println(cells.size());
		
		for(int i=2;i<=rows.size();i++) {
			
			for (int j=1;j<=cells.size();j++) {
			
		String text = driver.findElementByXPath("//table[@id='table_id']//tr[" + i +"]/td["+ j +"]").getText();
		System.out.println(text);
			
			}
		
		}
	}

}
