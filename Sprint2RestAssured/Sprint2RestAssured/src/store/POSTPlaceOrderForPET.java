package store;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class POSTPlaceOrderForPET {
	@Test
	public void POSTplaceorder() {
		String id= "56"; 
		String petId ="65";
		String quantity="4";
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
		Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"petId\": \"" + petId + "\",\"quantity\": \"" + quantity + "\"}").post("/v2/store/order");
		ResponseBody body = response.getBody();
		System.out.println("The response code - " +response.getStatusCode());
		System.out.println(body.asString());
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath eval=response.jsonPath();
		Assert.assertEquals("56", eval.get("id").toString());
		System.out.println("ID  is : "+eval.get("id").toString()+" and  complete is : "+eval.get("complete").toString());
	}
}
