package sample;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST {

	@Test
	void registrationSuccessful() {

		// specify base URI
		RestAssured.baseURI = "http://demoqa.com/customer/";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Payload or Body
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "John");
		requestParams.put("LastName", "Doe");
		requestParams.put("UserName", "JohnDoe1992");
		requestParams.put("Password", "John@123");
		requestParams.put("Email", "JohnXYZ@gmail.com");

		// attach data to request
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		// Response object
		Response response = httpRequest.request(Method.POST, "register");

		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// Success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION SUCCESS");

	}

}
