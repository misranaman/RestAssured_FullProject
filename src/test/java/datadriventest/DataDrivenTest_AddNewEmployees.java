package datadriventest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployees {

	@Test(dataProvider = "empdataprovider")
	void postNewEmployees(String name, String salary, String age) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Data to be sent along with the Post Request
		JSONObject requestparams = new JSONObject();

		requestparams.put("name", name);
		requestparams.put("salary", salary);
		requestparams.put("age", age);

		// add header stating request body is JSON
		httpRequest.header("Content-Type", "application/json");

		// add the JSON body to request
		httpRequest.body(requestparams.toJSONString());

		// Post request
		Response response = httpRequest.request(Method.POST, "/create");

		// Capture response body
		String responseBody = response.getBody().asString();

		// System.out.println("Response Body is ---> " + responseBody);

		Assert.assertEquals(responseBody.contains(name), true);
		Assert.assertEquals(responseBody.contains(salary), true);
		Assert.assertEquals(responseBody.contains(age), true);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@DataProvider(name = "empdataprovider")
	public String[][] getEmpData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/datadriventest/empdata.xls";

		int rowNum = XLUtility.getRowCount(path, "Sheet1");
		int colCount = XLUtility.getCellCount(path, "Sheet1", 1);

		String empdata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				empdata[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);

			}
		}

		// String empdata[][] = { { "abc", "20000", "20" }, { "pqr", "30000", "53" }, {
		// "xyz", "50000", "55" } };
		
		return empdata;
	}
}
