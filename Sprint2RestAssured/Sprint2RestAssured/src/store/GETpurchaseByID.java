package store;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GETpurchaseByID {
	String baseUrl="https://petstore.swagger.io";
	@Test
	public void GETOrderByID() {
		RestAssured.baseURI=baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JSONObject params = new JSONObject();
		httpRequest.body(params.toJSONString());
		Response response = httpRequest.get("/v2/store/order/9");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("The response time is "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println("----------Headers-------");
		Headers allHeaders = response.headers();
		for(Header header : allHeaders) { 
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
		} 
		Assert.assertEquals(response.header("Connection"),"close");
	}
}
