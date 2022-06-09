package Pet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class PostAddPet {
	@Test
	public void Postaddpet() throws IOException {
		File src= new File("C:\\Users\\kushal\\Desktop\\Sprint\\New folder\\Sprint2\\Sprint2RestAssured\\Sprint2RestAssured\\TestResources\\PostAddPet.property");
		FileInputStream fis = new FileInputStream(src);    
		// Load the properties File
		Properties prop = new Properties();
		prop.load(fis);
		String id= prop.getProperty("id"); 
		String name =prop.getProperty("name");
		String status=prop.getProperty("status");
		RestAssured.baseURI = "https://petstore.swagger.io";
		//requesting for json format
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
		//sending request for post
		Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"name\": \"" + name + "\",\"status\": \"" + status + "\"}").post("/v2/pet");
		ResponseBody body = response.getBody();
		System.out.println("The response code - " +response.getStatusCode());
		System.out.println(body.asString());
		//assertation status
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath eval=response.jsonPath();
		//validing the body by id 
		Assert.assertEquals("14", eval.get("id").toString());
		System.out.println("ID  is : "+eval.get("id").toString()+" and  status is : "+eval.get("status").toString());
	}
}
