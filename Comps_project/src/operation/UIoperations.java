package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIoperations extends Getobjectclass {
WebDriver driver;
public UIoperations(WebDriver driver)
{
	this.driver=driver;
}

public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
{
//System.out.println("manage value " +p.getProperty("managecomps"));
switch(operation.toUpperCase())
{
case "CLICK":
driver.findElement(this.getObject(p, objectname, objectType)).click();
break;
case "SETTEXT":
	driver.findElement(this.getObject(p, objectname, objectType)).sendKeys(value);
break;
case "GOTOURL":
	driver.get(p.getProperty(value));
	break;
case "IMPLICITWAIT":
	driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	break;
case "EXPLICITWAIT":
	WebDriverWait wait= new WebDriverWait(driver, 3000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.getObject(p, objectname, objectType))));
	break;
case "DRIVERWAIT":
int i=Integer.parseInt(value);
	Thread.sleep(i);
	System.out.println("wait is" +i);
//	Thread.sleep(2000);
	break;
case "CLOSE":
	driver.close();
	break;
default:
		break;
}
	}
}
