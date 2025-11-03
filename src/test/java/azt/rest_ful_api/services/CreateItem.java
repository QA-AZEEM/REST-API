package azt.rest_ful_api.services;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import azt.rest_ful_api.baseclass.BaseAPIClass;
import azt.rest_ful_api.model.Items;
import azt.rest_ful_api.model.Items.Data;
import azt.rest_ful_api.response.CreateItemResponse;
import azt.rest_ful_api.testdatautil.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CreateItem extends BaseAPIClass {

	private Response response;
	private Items items;
	private String endpoint = "/objects";
	private String productID;

	@BeforeMethod(alwaysRun = true)
	public void requestBody() {
		Data data = new Data();
		data.setYear(TestData.getyear());
		data.setPrice(TestData.getPrice());
		data.setCpuModel(TestData.getCPUModel());
		data.setHardDisk(TestData.getSSD());

		items = new Items();
		items.setName(TestData.getName());
		items.setData(data);
	}

	@Test(description = "Verify that new Item can be created successfully")
	public void createitem() {
		response = RestAssured
				.given()
					.contentType(ContentType.JSON).body(items)
				.when()
					.post(endpoint)
					.then().log()
							.ifError()
							.assertThat()
							.statusCode(200)
							.extract()
							.response();
		
		CreateItemResponse resp = response.as(CreateItemResponse.class);
		productID = response.jsonPath().get("id");
		System.out.println(productID);
		
		Assert.assertNotNull(resp.getId(), "Item ID should not be null");
        Assert.assertNotNull(resp.getName(), "Item name should not be null");
        Assert.assertNotNull(resp.getCreatedAt(), "Created date should not be null");

        Assert.assertNotNull(resp.getData(), "Data object should not be null");
        Assert.assertNotNull(resp.getData().getYear(), "Year should not be null");
        Assert.assertNotNull(resp.getData().getPrice(), "Price should not be null");
        Assert.assertNotNull(resp.getData().getCpuModel(), "CPU Model should not be null");
        Assert.assertNotNull(resp.getData().getHardDisk(), "Hard Disk should not be null");
        
        // Created at data format validation
        
        Assert.assertTrue(productID.matches("^[a-f0-9]{32}$"), "Item Id format is invalid");
	}
	
	@Test(dependsOnMethods = "createitem", description = "Validate Response Schema")
	public void validateResponseSchema() {
		
		response
				.then()
					.log().ifError()
					.assertThat().statusCode(200)
					.body(matchesJsonSchemaInClasspath("schema/create-item.json"));
				
	}
}
