package day3;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraBase {

	public static RequestSpecification spec;
	
	public static String issue_id;
	
	@BeforeMethod
	public void init(){
		
		spec =  RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("vino.psgtech1990@gmail.com", "Smileplease28#");
		
	}
}
