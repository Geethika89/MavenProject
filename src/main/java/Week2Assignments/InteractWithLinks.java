package Week2Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithLinks {
	public static void main(String[] args) {	
WebDriverManager.chromedriver().browserVersion("88.0.4324.182").setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//navigte to homepage
		driver.findElementByLinkText("Go to Home Page").click();
		driver.navigate().back();
		
		//Get url without clicking the link
	String linkattr = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println(linkattr);
		
		//navigating to the same home page
		driver.findElementByLinkText("Go to Home Page").click();
		driver.findElementByXPath("//img[@src='images/link.png']").click();
	
		//no of links in th page
        List<WebElement> noOfLinks = driver.findElementsByXPath("//div[@class='large-6 small-12 columns']");
        System.out.println(noOfLinks.size());
     
        //verify a broken link
        driver.findElementByLinkText("Verify am I broken?").click();
        String title = driver.getTitle();{
        //System.out.println(title);
        if(title.contains("404")) {
        	System.out.println("The page is broken");
        }
        
        else {
        	System.out.println("The page is not broken");
        }
        }  
        driver.close();
	}     
 }

/*To iterate and verify all links
 *  String brokenUrl = driver.findElementByLinkText("Verify am I broken?").getAttribute("href");
      // String brokenUrl = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
        //System.out.println(brokenUrl);
        verifyLinks(brokenUrl);
	} 
        public static void verifyLinks(String linkUrl)
        {
        	try
            {
                URL brokenUrl = new URL(linkUrl);
                //System.out.println(brokenUrl);

                //Now we will be creating url connection and getting the response code
                HttpURLConnection httpURLConnect=(HttpURLConnection)brokenUrl.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if(httpURLConnect.getResponseCode()>=400)
                {
                	System.out.println(brokenUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
                }    
           
                //Fetching and Printing the response code obtained
                else{
                    System.out.println(brokenUrl+ " - " +httpURLConnect.getResponseMessage()+"is not a broken link");
                }
            }catch (Exception e) {
          }
         
       
		
	}
 */

 