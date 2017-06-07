package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UploadComps extends Getobjectclass
{
	WebDriver driver;

	public UploadComps(WebDriver driver)
	{
		this.driver=driver;
	}
	public void upload(Properties p,String operation,String objectname,String objectType,String value) throws Exception
	{
	
		switch(operation.toUpperCase())
		{
		case "UPLOAD":
			Thread.sleep(5000); 
			
			WebElement element = driver.findElement(this.getObject(p, objectname, objectType));
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(falsetest@evalueserve.com);", element);
			//js.executeScript("window.scrollBy(0,-250)", "");
			Thread.sleep(500); 
			
			


			element.click();;
			

			Thread.sleep(100);
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\AutoIt3\\upload.exe");
		break;
		
		
		
			default:
				break;
		}
			}
		
	}

