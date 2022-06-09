package User;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class POSTcreateUser {
@Test
public void PostCreateUser() {
	String id= "46218"; 
	String username ="Govu";
	String userstatus="active";
	RestAssured.baseURI = "https://petstore.swagger.io";
	RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
	Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"username\": \"" + username + "\",\"userstatus\": \"" + userstatus + "\"}").post("/v2/user");
	ResponseBody body = response.getBody();
	System.out.println("The response code - " +response.getStatusCode());
	System.out.println(body.asString());
	
	Assert.assertEquals(response.getStatusCode(),200);
	JsonPath eval=response.jsonPath();
	System.out.println(eval.get("code").toString());
}
}