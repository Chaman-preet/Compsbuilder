package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIoperations {
WebDriver driver;
public UIoperations(WebDriver driver)
{
	this.driver=driver;
}

public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
{
System.out.println("manage value " +p.getProperty("managecomps"));
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
case "WAIT":
	//long i=Integer.parseInt(value);
	//Thread.sleep(i);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	break;
	default:
		break;
}
	}

private By getObject(Properties p,String objectname,String objectType) throws Exception{
    //Find by xpath
    if(objectType.equalsIgnoreCase("XPATH")){
        
        return By.xpath(p.getProperty(objectname));
    }
    //find by class
    else if(objectType.equalsIgnoreCase("CLASSNAME")){
        
        return By.className(p.getProperty(objectname));
        
    }
    
  //find by id
    else if(objectType.equalsIgnoreCase("ID")){
        
        return By.id(p.getProperty(objectname));
        
    }
    //find by name
    else if(objectType.equalsIgnoreCase("NAME")){
        
        return By.name(p.getProperty(objectname));
        
    }
    //Find by css
    else if(objectType.equalsIgnoreCase("CSS")){
        
        return By.cssSelector(p.getProperty(objectname));
        
    }
    //find by link
    else if(objectType.equalsIgnoreCase("LINK")){
        
        return By.linkText(p.getProperty(objectname));
        
    }
    //find by partial link
    else if(objectType.equalsIgnoreCase("PARTIALLINK")){
        
        return By.partialLinkText(p.getProperty(objectname));
        
    }
    else
    {
        throw new Exception("Wrong object type");
    }
}
}
