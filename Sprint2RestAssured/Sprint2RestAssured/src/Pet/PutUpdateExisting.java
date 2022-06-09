package Pet;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutUpdateExisting {
	
	 @Test
	    public void UpdateExisting() {
	    String id= "0"; 
	    String name ="doggi";
	    RestAssured.baseURI = "https://petstore.swagger.io";
	    RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");

	    //Calling the Delete API with request body
	    Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"name\": \"" + name + "\"}").put("v2/pet");
	 
	    System.out.println("The response code - " +response.getStatusCode());
	    Assert.assertEquals(response.getStatusCode(),200);
	    
	}

}
