package operation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
case "CLOSE":
	driver.close();
//	driver.quit();
	break;
	
case "WAIT":
	try{
	long time =(long)Double.parseDouble(value);
    Thread.sleep(time*1000L);}
    catch (NumberFormatException e){
    System.out.println("not a number"); } 
	break;
	
	//Thread.sleep(5000);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
case "ROBOTwithKEYDOWN":
	
	Robot rob= new Robot();
	rob.keyPress(KeyEvent.VK_DOWN);
	rob.keyRelease(KeyEvent.VK_DOWN);
	break;
	
case "ROTBOTwithENTER":
Robot rob1= new Robot();
rob1.keyPress(KeyEvent.VK_ENTER);
rob1.keyRelease(KeyEvent.VK_ENTER);

break;
case "SELECTFROMDROPDOWN":
	WebElement element1=driver.findElement(this.getObject(p, objectname, objectType));
	Select se=new Select(element1);
	se.selectByValue(value);
	break;
	
	default:
		break;
}
	}

}
