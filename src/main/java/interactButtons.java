import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class interactButtons {

	public static void main(String[] args) {


WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.findElementById("home").click();
		
		driver.navigate().back();
		
		System.out.println("The position of button is : ");
		System.out.println(driver.findElementById("position").getLocation());
		
		
	   WebElement where = driver.findElementById("color");
		String color= where.getCssValue("background-color");
		System.out.println("The color of button is : " +color);
		
		WebElement wheresize = driver.findElementById("size");
		System.out.println("The size of button is : " + wheresize.getSize());
		

	}

}
