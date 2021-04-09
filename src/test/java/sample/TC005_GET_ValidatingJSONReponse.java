package sample;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingJSONReponse {

	@Test
	public void getweatherDetails() {

		// specify base URI
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/Delhi");

		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);

		Assert.assertEquals(responseBody.contains("Delhi"), true);

	}

}
