package store;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletePurchaseByID {
	String baseUrl = "https://petstore.swagger.io";
	String id = "13";
@Test
public void DeletePet() {
	RestAssured.baseURI=baseUrl;
	RequestSpecification httpRequest = RestAssured.given().header("Authorization","Bearer"+id).header("Content-Type","application/json");
	JSONObject params = new JSONObject();
	httpRequest.body(params.toJSONString());
	Response res = httpRequest.body("").delete("v2/store/order/13");
	System.out.println("The response code is - "+res.getStatusCode());
	//asseration for status
	Assert.assertEquals(res.getStatusCode(),404);
}
}
