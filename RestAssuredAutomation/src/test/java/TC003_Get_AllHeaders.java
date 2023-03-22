import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Get_AllHeaders {
	@Test
	public void getAllHeaders()
	{
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		// Print the message body of the response received from the server 
		
		  //System.out.println("Status received => " + response.getStatusLine());
		 // System.out.println("Response=>" + response.prettyPrint()); 
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is:"+statusCode);
		  Assert.assertEquals(statusCode,200); 
		  String statusLine=response.getStatusLine(); 
		  System.out.println(statusLine);
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		Headers allHeaders=response.headers();
		for(Header header:allHeaders)
		{
			System.out.println(header.getName()+"    "+header.getValue());
			
			
		}
		
	}
}
