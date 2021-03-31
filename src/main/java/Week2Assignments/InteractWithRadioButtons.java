package Week2Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithRadioButtons {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/radio.html");
		
		//anothr approach to load url
		//driver.navigate().to("enter the url");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElementByClassName("myradio").click();
		
		
		List<WebElement> radioChecked = driver.findElementsByXPath("//label[text()='Find default selected radio button']/following-sibling::label");
		System.out.println(radioChecked.size());
		{
		for(int i=0;i<radioChecked.size();i++) {
		System.out.println("attribut value Selected of radio button is : " + radioChecked.get(i).isSelected());
		if(radioChecked.get(i).getAttribute("for").equals("Checked"))
		{
				System.out.println(radioChecked.get(i).getText());
			}
		}
	}
		
		List<WebElement> radio = driver.findElementsByXPath("//div[@class='example']//following-sibling::input[@name='age']");
		System.out.println(radio.size());
		boolean selected=false ;
		WebElement op1 = null;
		{
			for(int i=0;i<radio.size();i++) {
				System.out.println("attribut value Selected of radio button is : " + radio.get(i).isSelected());
				 selected = radio.get(i).isSelected();
				 
				 if(selected==true) {
					 break;
				 }
					 
			}
			
			if(selected==true)
			{
				System.out.println("value true");
			}
			else {
				op1=radio.get(1);
				op1.click();	
				}
		 driver.close();
		}
        
	}	

}

// driver.findElementByXPath("(//div[contains(@class,'large-6 small-12')])[3]")).count();
//System.out.println(selected);*/
