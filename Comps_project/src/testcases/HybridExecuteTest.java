package testcases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operation.UIoperations;
import operation.Readobject;
import exportExcel.POIexcel;

public class HybridExecuteTest {
	WebDriver webdriver;
	
@Test(dataProvider="hybridData")
public void testlogin(String testcasename,String keyword, String objectname,String objectType,String value,String runmode) throws Exception
{
	if(runmode.equals("Y"))
	{
	if(testcasename!=null&&testcasename.length()!=0)
	{
		//System.setProperty("webdriver.chrome.driver", "C://Comps_workspace//Comps_project//Driver//driver path//chromedriver.exe");
		//webdriver=new ChromeDriver();
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		System.setProperty("webdriver.gecko.driver", "C://Users//chaman.preet//Downloads//geckodriver.exe");
		webdriver=new FirefoxDriver(fp);
	}
		Readobject robject=new Readobject();
		Properties allobjects=robject.getobjectrepository();
		UIoperations Uoperation=new UIoperations(webdriver);
		Uoperation.perform(allobjects, keyword, objectname, objectType, value);
		}
	else if(runmode.equals("N"))
	{
		throw new SkipException("Test case is skipped as Run mode is N");
	}
}
	

@DataProvider(name="hybridData")
public Object[][] getDatafromDataprovider() throws IOException
{
	Object[][] object=null;
	POIexcel file=new POIexcel();
	XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//test-output", "TestCase.xlsx", "Comps");
	int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	System.out.println("row count is " +rowcount);
	int col_count=sheet.getRow(1).getPhysicalNumberOfCells();
	object=new Object[rowcount][col_count];
	for(int i=0;i<rowcount;i++)
	{
		XSSFRow row=sheet.getRow(i+1);
		 for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print excel data in console
				XSSFCell cell=row.getCell(j);
	            object[i][j] = cell.toString();
	           System.out.println("values are" +object[i][j]);
	        }
	    }
	    System.out.println("");
	     return object;    
	    }

//@AfterMethod
public void teardown()
{
	webdriver.close();
}
	}
