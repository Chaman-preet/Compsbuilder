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
	return p;
	}
}
