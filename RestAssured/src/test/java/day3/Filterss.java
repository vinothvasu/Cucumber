package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;

public class Filterss extends BaseRequest {
	
	SessionFilter session=new SessionFilter();
	CookieFilter cookie=new CookieFilter();
	
	List<Filter> allFilter=new ArrayList<Filter>();
	
	@Test
	public void useFilter() {
		
		allFilter.add(session);
		allFilter.add(cookie);
		
		Response response = 
				spec
				.filters(allFilter)
				.get("https://dev61953.service-now.com/api/now/table/change_request");
		
		System.out.println(response.statusCode());
		System.out.println(session.getSessionId());
	}

	@Test(dependsOnMethods="useFilter")
	public void getUsingFilter() {
		
		System.out.println(session.getSessionId());
		
		//File file=new File("./jira.json");

		Response response = RestAssured
				.given()
				//.body(file)
				.filters(allFilter)
				//.contentType(ContentType.XML)
				.get("https://dev61953.service-now.com/api/now/table/change_request");
		
		//System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
	}


}
