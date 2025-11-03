package azt.rest_ful_api.baseclass;

import org.testng.annotations.BeforeClass;

import azt.rest_ful_api.configutil.ConfigReader;
import io.restassured.RestAssured;

public class BaseAPIClass {
	
	private String baseUrl = ConfigReader.get("baseurl");
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = baseUrl;
	}
	
	
}
