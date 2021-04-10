package pojo.jira;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FinalPayLoad {

	public static void main(String[] args) {

		IssueType issue = new IssueType("Task");
		Projects project = new Projects("REST");
		Payload p = new Payload("Demo", "Demo Description", issue, project);
		Fields f = new Fields(p);

	}

}
