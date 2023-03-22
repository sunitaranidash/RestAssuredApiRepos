import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	public void getBookDetails()
	{
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RestAssured.baseURI="https://restapi.demoqa.com/customer";
		
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName","JOHNabjk");
		requestParams.put("LastName","JOHNabffjk");
		requestParams.put("UserName","JOHNaffdbjk");
		requestParams.put("password","JOHNavfbjk");
		requestParams.put("Email","JOHNabjk@gmail.com");
		httpRequest.body(requestParams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"/register");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is:"+statusCode);
		  Assert.assertEquals(statusCode,201); 
		 String successCode=response.jsonPath().get("Successcode");
		 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
	}
}
