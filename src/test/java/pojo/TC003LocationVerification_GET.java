package pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.function.Add;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003LocationVerification_GET extends TestBase {

	Location_MultipleAddress location_MultipleAddress;

	@BeforeTest
	public void setUp() throws InterruptedException {

		RestAssured.baseURI = "http://localhost:3000";
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/locations/4");
		System.out.println(response.asString());

		location_MultipleAddress = response.as(Location_MultipleAddress.class);

	}

	@Test
	public void checkStatus() {

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void checkCountry() {

		String country = location_MultipleAddress.getCountry();
		Assert.assertEquals(country, "Russia");

	}

	@Test
	public void checkAddresses() {

		List<Address> addresses = location_MultipleAddress.getAddress();

		for (Address add : addresses) {

			System.out.println("Flat Number=" + add.getFlat_no());
			System.out.println("Pin Code=" + add.getPincode());
			System.out.println("Street=" + add.getStreet());
			System.out.println("Type=" + add.getType());

		}

	}

}
