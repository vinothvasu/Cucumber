package slack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMessage {
	
	@Test
	public void authTest() {
		
		Response response =  RestAssured
				.given()
				.auth()
				.preemptive()
				.oauth2("xoxp-401876518548-402257237797-402257863797-5738f4646f39416de4328cb22daa0669")
				//.queryParam("fields", "created")
				.contentType("application/x-www-form-urlencoded")
				.post("https://restassuredgroup.slack.com/api/auth.test");
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response.statusCode());
	}

}
