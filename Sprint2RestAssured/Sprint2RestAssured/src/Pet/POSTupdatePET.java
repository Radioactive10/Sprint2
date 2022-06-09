package Pet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class POSTupdatePET {

	@Test
	public void Postupdatepet() {
	    //value
		String id= "7"; 
	    String name ="Rosie";
	    String status="Available";
	    //base url
	    RestAssured.baseURI = "https://petstore.swagger.io";
	    RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
	    //sending request
	    Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"name\": \"" + name + "\",\"status\": \"" + status + "\"}").post("/v2/pet");
	    ResponseBody body = response.getBody();
	    System.out.println("The response code - " +response.getStatusCode());
	    System.out.println(body.asString());
	    //asseration by status
	    Assert.assertEquals(response.getStatusCode(),200); 
}
}
