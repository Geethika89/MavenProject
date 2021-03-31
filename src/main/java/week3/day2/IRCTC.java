package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//button[@type='submit']").click();
		driver.findElementByLinkText("FLIGHTS").click();
		Thread.sleep(5000);
		
		Set<String> allWidowHandle=driver.getWindowHandles();
		System.out.println(allWidowHandle);
		
		List<String> listHandle = new ArrayList<String>(allWidowHandle);
		driver.switchTo().window(listHandle.get(1));
		
		String title = driver.getTitle();
		System.out.println("the title is : " +title);
		
		String mail = driver.findElementByXPath("//a[@class='d-block font-weight-bold']").getAttribute("href");
		System.out.println(mail);
		
	
		driver.switchTo().window(listHandle.get(0));
		driver.close();

	}

}
