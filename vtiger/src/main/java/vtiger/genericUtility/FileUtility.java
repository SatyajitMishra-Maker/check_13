package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FileUtility {
	/**
	 * This method use to read data from property file and returns value for the key given.
	 * @author Satyajit
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getDataFromProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPORTIES_PATH);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);

	}

	public String getDataFromJson(String jsonKey) throws Throwable {
		FileReader reader=new FileReader(IPathConstant.JASONFILE_PATH);
		JSONParser parser=new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject)object;
		String value=jsonObject.get(jsonKey).toString();
		return value;
	}

}
