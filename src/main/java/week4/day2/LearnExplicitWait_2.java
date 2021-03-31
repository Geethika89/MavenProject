package week4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnExplicitWait_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/alertappear.html");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElementById("alert").click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();

	}

}
