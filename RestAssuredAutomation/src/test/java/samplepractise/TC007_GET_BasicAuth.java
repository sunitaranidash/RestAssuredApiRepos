package samplepractise;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_BasicAuth {

	//@Test
	public void getBasicAuth()
	{
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
		authscheme.setUserName("postman");
		authscheme.setPassword("password");
		RestAssured.authentication=authscheme;
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is:"+statusCode);
		  Assert.assertEquals(statusCode,200); 
		  
		 
		
	}
	@Test
	public void getBasicAuthentication()
	{
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		RequestSpecification httpRequest=RestAssured.given().auth().basic("postman","password");
		Response response=httpRequest.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		Assert.assertEquals(responseBody.contains("authenticated"),true);
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is:"+statusCode);
		  Assert.assertEquals(statusCode,200); 
		  
		  
		 
		
	}
}
