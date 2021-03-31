import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class acmeTest {

	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.findElementByName("email").sendKeys("kumar.testleaf@gmail.com");
		
		driver.findElementByName("password").sendKeys("leaf@12");
		
		//driver.findElementByTagName("").click();
		
		
        String title1 = driver.getTitle();
		
		System.out.println("The title of afterlogin page is :  " +title1);
		
		/* 
		 5. Get the title of the page and print
		 6. Click on Log Out
		 7. Close the browser*/
		
	}

}
