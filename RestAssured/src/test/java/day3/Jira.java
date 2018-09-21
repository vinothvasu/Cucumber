package day3;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Jira extends JiraBase {

	@Test
	public void getJiraTicket() {

		Response response = 
				spec
				.queryParam("fields", "created")
				.get("https://vino90.atlassian.net/rest/api/2/issue/PP-37");

		//System.out.println(response.prettyPrint());

		JsonPath jsonpath=response.jsonPath();

		Object object = jsonpath.get("fields.created");

		System.out.println(object);

	}

	@Test
	public void postJiraTicket() {

		File file=new File("./jira.json");

		Response response = 
				spec	
				.body(file)
				.contentType(ContentType.JSON)
				.post("https://vino90.atlassian.net/rest/api/2/issue");

		//System.out.println(response.prettyPrint());

		int status=	response.statusCode();

		String statuscode=Integer.toString(status);

		JsonPath jsonpath=response.jsonPath();

		issue_id = jsonpath.get("key");

		System.out.println(issue_id);

		Assert.assertEquals("201", statuscode, "Issue not created");

	}

	@Test(dependsOnMethods="postJiraTicket")
	public void deleteJiraTicket() {

		Response response = 
				spec	
				.contentType(ContentType.JSON)
				.delete("https://vino90.atlassian.net/rest/api/2/issue/"+issue_id);

		//System.out.println(response.statusCode());
		
		int status=	response.statusCode();

		String statuscode=Integer.toString(status);

		Assert.assertEquals("204", statuscode, "Issue not deleted");

		System.out.println(response.time());

		if(response.time() < 3000) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}

	}
}
