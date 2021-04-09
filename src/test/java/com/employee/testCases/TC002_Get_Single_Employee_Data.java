package com.employee.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Data extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		logger.info("*********** Started TC002_Get_Single_Employee Data *********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" + empID);

		Thread.sleep(3);
	}

	@Test
	void checkResponseBody() {

		logger.info("****** Checking Response Body *****");

		String responseBody = response.getBody().asString();
		//logger.info("Response Body==>" + responseBody);

		Assert.assertTrue(responseBody.contains(empID));

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
		Assert.assertEquals(contentType, "application/json");

	}

	@AfterClass
	public void tearDown() {

		logger.info("*** Test Case End ***");

	}

}
