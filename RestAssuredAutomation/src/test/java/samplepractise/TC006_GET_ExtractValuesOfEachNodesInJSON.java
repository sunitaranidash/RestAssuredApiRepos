package samplepractise;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractValuesOfEachNodesInJSON {
	@Test
	public void getBookDetails()
	{
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("Weather Description"));
		System.out.println(jsonpath.get("Wind Speed"));
		System.out.println(jsonpath.get("Wind Direction degree"));
		Assert.assertEquals(jsonpath.get("Tempratue"),"6 Degree celsius"); 
		
		
		
		
		
		
		
		
		
		
		 
		
	}
}
