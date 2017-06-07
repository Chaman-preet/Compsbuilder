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
public void testlogin(String testcasename,String keyword, String objectname,String objectType,String value) throws Exception
{
	if(testcasename!=null&&testcasename.length()!=0&&keyword!=null) // &&keyword.length()!=0
	{
		//System.setProperty("webdriver.chrome.driver", "C://Comps_workspace//Comps_project//Driver//driver path//chromedriver.exe");
		//webdriver=new ChromeDriver();
		
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\rajeev.singh2\\Downloads\\softwares\\geckodriver\\geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver","./src/objects/geckodriver.exe");
		webdriver=new FirefoxDriver(fp);
		webdriver.manage().window().maximize();
		

	}
		Readobject robject=new Readobject();
		Properties allobjects=robject.getobjectrepository();
		
		UIoperations Uoperation=new UIoperations(webdriver);
		Uoperation.perform(allobjects, keyword, objectname, objectType, value);
	}

@DataProvider(name="hybridData")
public Object[][] getDatafromDataprovider() throws IOException
{
	Object[][] object=null;
	POIexcel file=new POIexcel();

	// original path by Sweta
	// XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//test-output", "TestCase.xlsx", "Comps");
	
	XSSFSheet sheet=file.readexcel("C://Users//rajeev.singh2//git//Compsbuilder//Comps_project", "TestCase.xlsx", "Comps");

	int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	System.out.println("row count is" +rowcount);
	object=new Object[rowcount][5];
	for(int i=0;i<rowcount;i++)
	{
		XSSFRow row=sheet.getRow(i+1);
		 for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print excel data in console
				XSSFCell cell=row.getCell(j);
	            object[i][j] = cell.toString();	
	           // System.out.println("values are" +object[i][j]);
	        }
	    }
	    System.out.println("");
	     return object;    
	    }

@AfterTest
public void teardown()
{
	
	//webdriver.close();
	webdriver.quit();
	
}
	}
