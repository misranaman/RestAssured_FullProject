package com.employee.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		logger.info("*********** Started TC005_Delete_Employee_Record *********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/employees");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String empId = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/" + empId);

		Thread.sleep(3000);
	}

	@Test
	void checkStatusCode() {

		logger.info("*** Checking Status Code ***");

		int statusCode = response.getStatusCode();
		logger.info("Status Code==>" + statusCode);

		Assert.assertEquals(statusCode, 200);
	}

	@Test
	void checkResponseTime() {

		logger.info("*** Checking Response Time ***");

		long responseTime = response.getTime();
		logger.info("Response Time==>" + responseTime);

		Assert.assertTrue(responseTime < 10000);
	}

	@Test
	void checkstatusLine() {

		logger.info("*** Check status line ***");

		String statusLine = response.getStatusLine();
		logger.info("Status Line is ==>" + statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test
	void checkContentType() {

		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");

	}

	@AfterClass
	public void tearDown() {

		logger.info("*** Test Case End ***");

	}

}
