package Negative;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletePET {
	String baseUrl = "https://petstore.swagger.io";
	String id = "14";
@Test
public void DeletePet() {
	RestAssured.baseURI=baseUrl;
	RequestSpecification httpRequest =
	RestAssured.given().header("Authorization","Bearer"+id).header("Content-Type","application/json");
	Response res = httpRequest.queryParam("v2","pet","14").delete();
	//Response res = httpRequest.body("").delete("/v2/pet/13");
	System.out.println("The response code is - "+res.getStatusCode());
	
	Assert.assertEquals(res.getStatusCode(),200);
}
}
