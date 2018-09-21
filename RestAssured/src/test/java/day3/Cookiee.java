package day3;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;

public class Cookiee extends JiraBase {

	@Test
	public void useCookie() {

		Response response = 
				spec
				.get("https://vino90.atlassian.net/rest/api/2/issue/PP-37");

		Map<String, String> cookies = response.getCookies();

		for (Entry<String, String> cookie : cookies.entrySet()) {

			System.out.println(cookie.getKey());

			System.out.println(cookie.getValue());

		}

	}

	@Test(dependsOnMethods="useCookie")
	public void postUsingCookie() {
		
		File file=new File("./jira.json");
		
		Cookie session=new Cookie
				.Builder("atlassian.xsrf.token","9def69b0-a39a-4c36-8abe-c2ba0c9e412d_ca32277ee72b19e20852bcec30a099bdfccfe5d2_lin")
				.build();

		Response response = RestAssured
				.given()
				//.body(file)
				.cookie(session)
				//.contentType(ContentType.JSON)
				.get("https://vino90.atlassian.net/rest/api/2/issue/PP-37");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
	}


}
