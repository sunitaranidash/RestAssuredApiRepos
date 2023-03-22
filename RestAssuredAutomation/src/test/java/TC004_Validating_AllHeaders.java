import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Validating_AllHeaders {
	@Test
	public void getAllHeaders()
	{
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		Assert.assertEquals(responseBody.contains("Hyderabad"),true);
		 
		
		
	}
}
