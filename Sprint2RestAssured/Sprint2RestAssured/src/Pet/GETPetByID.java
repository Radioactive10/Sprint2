package Pet;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class GETPetByID {
	String baseUrl="https://petstore.swagger.io";
	@Test
	public void GetPET() { 
		RestAssured.baseURI=baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		//json format
		httpRequest.header("Content-Type", "application/json");
		JSONObject params = new JSONObject();
		httpRequest.body(params.toJSONString());
		//get request
		Response response = httpRequest.get("/v2/pet/14");
		//responce body
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("The response time is "+response.getStatusCode());
		//response assertion
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println("----------Headers-----------");
		Headers allHeaders = response.headers();
		//printing for header
		for(Header header : allHeaders) 
		{ 
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
		} 
		//assertation for header
		Assert.assertEquals(response.header("Connection"),"close");
	}
}
