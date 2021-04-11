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

		Address address1 = new Address("122", "B Bakers Street", 12004, "secondary");
		Address address2 = new Address("Street 21", "Flat No 18", 122008, "primary");
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);

		Location_MultipleAddress locationMultiple = new Location_MultipleAddress(4, "Moscow", "Russia", addresses);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(locationMultiple);

		response = httpRequest.request(Method.POST, "/locations");

		Thread.sleep(3000);
	}

	@Test
	public void checkStatus() {

		Assert.assertEquals(response.getStatusCode(), 201);

	}

}
