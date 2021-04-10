package pojo.jira;

import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssueInJira_SerializationDeserialization extends TestBase {

	@Test
	public void createTicket() {

		IssueType issue = new IssueType("Task");
		Projects project = new Projects("REST");
		Payload p = new Payload("Demo", "Demo Description", issue, project);
		Fields f = new Fields(p);

		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(f)
				.post("https://create.ticket.in.jira");

		System.out.println(response.getBody().jsonPath().prettify());

	}

}
