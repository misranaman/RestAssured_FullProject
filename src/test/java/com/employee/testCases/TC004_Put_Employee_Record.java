package com.employee.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Employee_Record extends TestBase {

	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		logger.info("*********** Started TC004_Put_Employee_Record *********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		Thread.sleep(2000);

		JSONObject requestParam = new JSONObject();
		requestParam.put("name", empName);
		requestParam.put("salary", empSalary);
		requestParam.put("age", empAge);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam);

		response = httpRequest.request(Method.PUT, "/update/" + empID);

		Thread.sleep(3000);
	}

	@Test
	void checkResponseBody() {

		logger.info("****** Checking Response Body *****");

		String responseBody = response.getBody().asString();
		// logger.info("Response Body==>" + responseBody);

		Assert.assertTrue(responseBody.contains(empName));
		Assert.assertTrue(responseBody.contains(empSalary));

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
