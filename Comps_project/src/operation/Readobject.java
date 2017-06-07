package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readobject 
{
	Properties p=new Properties();
	
public Properties getobjectrepository() throws IOException
{

// original path by sweta
//	File src=new File("C:\\Comps_workspace\\Comps_project\\src\\objects\\object.properties");

	File src=new File("./src/objects/object.properties");
	
	FileInputStream fs=new FileInputStream(src);
	p.load(fs);
	p.setProperty("managecomps", "MANAGE COMPS");
	System.out.println("new branch test ");
	System.out.println("new branch test 1");
	return p;
	}
}
