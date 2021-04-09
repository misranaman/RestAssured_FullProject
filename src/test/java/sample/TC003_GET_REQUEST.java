package sample;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {

	@Test
	void googleMapTest() {

		// specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);

		// headers
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/xml");

	}

}
