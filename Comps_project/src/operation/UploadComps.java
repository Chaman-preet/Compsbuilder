package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

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
		case "Upload":
		driver.findElement(this.getObject(p, objectname, objectType)).click();
		break;
		

			default:
				break;
		}
			}
		
	}

