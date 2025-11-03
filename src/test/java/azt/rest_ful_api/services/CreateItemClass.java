package azt.rest_ful_api.services;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import azt.rest_ful_api.baseclass.BaseAPIClass;
import azt.rest_ful_api.model.Items;
import azt.rest_ful_api.model.Items.Data;
import azt.rest_ful_api.response.CreateItemResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CreateItemClass extends BaseAPIClass {
	
	private Response response;
	private Items items;
	private Data data;
	private String endpoint = "/objects";
	
	@BeforeMethod
	public void requestBody() {
		items = new Items();
		data = new Data();
		items.setName("Neo 18 Pro");
		items.setData(data);
		data.setYear(2027);
		data.setPrice(35000);
		data.setCpuModel("Snapdragon 8E");
		data.setHardDisk("512 GB");
	}
	
	@Test
	public void createitem() {
		response = RestAssured
				.given()
					.contentType(ContentType.JSON)
				    .body(items)
				 .when()
				 	.post(endpoint)
				 .then()
				 	.log().ifError()
				 	.assertThat().statusCode(200)
				 	.extract()
				 	.response();
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);
		CreateItemResponse resp = response.as(CreateItemResponse.class);
		
		Assert.assertNotNull(resp.getId(),"Item id is null");
		Assert.assertNotNull(resp.getName(),"Item name is null");
		Assert.assertNotNull(resp.getCreatedAt(),"Created date is null");
		Assert.assertNotNull(resp.getData().getYear(),"Item Year is null");
		Assert.assertNotNull(resp.getData().getPrice(),"Item Price is null");
		Assert.assertNotNull(resp.getData().getCpuModel(),"Item CPU Model is null");
		Assert.assertNotNull(resp.getData().getHardDisk(),"Item hard disk is null");
		
	}
}
