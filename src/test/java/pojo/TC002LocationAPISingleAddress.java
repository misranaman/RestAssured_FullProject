package pojo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002LocationAPISingleAddress extends TestBase {

	@BeforeTest
	public void setUp() throws InterruptedException {

		RestAssured.baseURI = "http://localhost:3000";
		httpRequest = RestAssured.given();

		Address address = new Address("122", "B Bakers Street", 12004);

		Location_SingleAddress location = new Location_SingleAddress(3, "London", "United Kingdom", address);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(location);

		response = httpRequest.request(Method.POST, "/locations");

		Thread.sleep(3000);
	}

	@Test
	public void checkStatus() {

		Assert.assertEquals(response.getStatusCode(), 201);

	}

}
