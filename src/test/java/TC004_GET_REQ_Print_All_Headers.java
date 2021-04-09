import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQ_Print_All_Headers {

	@Test
	void getweatherDetails() {

		// specify base URI
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city/";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);

		// Capture all the headers returned
		Headers allHeaders = response.headers();

		for (Header headers : allHeaders) {

			System.out.println("Header Name: " + headers.getName() + "     " + "Header Value: " + headers.getValue());

		}

	}

}
