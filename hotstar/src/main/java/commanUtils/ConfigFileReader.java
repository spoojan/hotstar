package commanUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public String getReportConfigPath(String fileName, String key) throws FileNotFoundException, IOException {
		final Properties prop = new Properties();
		prop.load(new FileInputStream("config" + File.separator + "config.properties"));
		String keyValue = prop.getProperty(key);
		return keyValue;
	}

}
