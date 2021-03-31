package week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameandAlert {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get(" https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame( driver.findElementById("iframeResult"));
		
		WebElement element = driver.findElementByXPath("//button[text()='Try it']");
		element.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		
		Date date=new Date();
		String strDate=date.toString();
		String dateToAppend=strDate.replaceAll(":", "");
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/Frameslearn"+dateToAppend+".png");
		FileUtils.copyFile(source, target);
		
		
	//	System.out.println(alert.getText());
	}

}
