package azt.rest_ful_api.configutil;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {
	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static Properties properties = new Properties();
	private static String fileName = "config.properties";
	
	static {
		try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
			if(inputStream != null) {
				properties.load(inputStream);
				logger.info("{} loaded successfully.", fileName);
			}else {
				logger.error("Unable to locate {}", fileName);
			}
		} catch (Exception e) {
			logger.error("Unable to load {}", fileName, e);
		}
	}
	
	public static String get(String key) {
		String evnVal = System.getenv(key);
		if(evnVal != null) return evnVal;
		return properties.getProperty(key);
	}
}
