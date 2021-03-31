package Week2Assignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class InteractWithImages {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		
		//anothr approach to load url
		//driver.navigate().to("enter the url");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//Click on image
		driver.findElementByXPath("//label[@for='home']/following::img").click();
		driver.navigate().back();
		
		//to check if image is broken
		boolean imgDisplay = driver.findElementByXPath("(//label[@for='home']/following::img)[2]").isSelected();
		System.out.println(imgDisplay);	
		
		driver.close();
		
	}

}

/*Actions builder= new Actions(driver);

Action mouseOver= builder.moveToElement().build();


driver.findElementByXPath("//label[@for='home']/following::img[3]").click();
driver.navigate().back();*/

//to do mouse over and broken image
