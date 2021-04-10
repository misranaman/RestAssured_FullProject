package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TestLocationAPIMultipleAddress extends TestBase {

	@BeforeTest
	public void setUp() throws InterruptedException {

		RestAssured.baseURI = "http://localhost:3000";
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/locations");

		System.out.println(response.asPrettyString());

		Address addressPrimary = new Address("122", "B Bakers Street", 12004, "primary");
		Address addressSecondary = new Address("36", "China Town", 223455, "secondary");

		List<Address> address = new ArrayList<Address>();
		address.add(addressPrimary);
		address.add(addressSecondary);

		Location location = new Location(4, "Moscow", "Russia", address);

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
