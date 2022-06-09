package User;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class PUTupdateUser {
    @Test
    public void UpdatePUTuser() {
    String id= "13"; 
    String username ="Gabby";
    RestAssured.baseURI = "https://petstore.swagger.io";
    RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
    Response response = httpRequest.body("{ \"id\": \"" + id + "\", \"username\": \"" + username + "\"}").put("/v2/user/Gabby");
    ResponseBody body = response.getBody();
    System.out.println(body.asString());
    System.out.println("The response code - " +response.getStatusCode());
    Assert.assertEquals(response.getStatusCode(),200); 
    JsonPath eval=response.jsonPath();
    Assert.assertEquals("13", eval.get("message").toString());
    }
}
