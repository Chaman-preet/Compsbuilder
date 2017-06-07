package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readobject {
	Properties p=new Properties();
public Properties getobjectrepository() throws IOException
{
	File src=new File("C:\\Comps_workspace\\Comps_project\\src\\objects\\object.properties");
	FileInputStream fs=new FileInputStream(src);
	p.load(fs);
	p.setProperty("managecomps", "MANAGE COMPS");
	p.setProperty("Team_arrow", "//span[@aria-owns='drp_Team_listbox']");
	p.setProperty("Team_select", "//div[@class='k-list-scroller']//ul[@id='drp_Team_listbox']//li[@data-offset-index='0']");
	p.setProperty("Template_arrow", "//span[@aria-owns='drp_Template_listbox']");
	p.setProperty("Template_select","//div[@class='k-list-scroller']//ul[@id='drp_Template_listbox']//li[text()='NY']");
	p.setProperty("UploadcompsTab", "Upload Comps");
	p.setProperty("upload", "attachment");
	return p;
	}
}
