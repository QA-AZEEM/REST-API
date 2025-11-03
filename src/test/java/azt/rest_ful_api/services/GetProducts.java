package azt.rest_ful_api.services;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import azt.rest_ful_api.baseclass.BaseAPIClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetProducts extends BaseAPIClass {
	
	private Response response;
	private String endpoint = "/objects";
	
	@Test(description = "Get list of products")
	public void getProductList() {
		
		response = RestAssured
				.given()
					.contentType(ContentType.JSON)
				.when()
					.get(endpoint)
				.then()
					.log().ifError()
					.extract()
					.response();
		
		Assert.assertEquals(response.getStatusCode(), 200,"Status Code not matching");
		
	}
}
