package day3;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {


	public static String sys_id;
	public static RequestSpecification spec;

	@BeforeMethod
	public void init() {

		spec= RestAssured
				.given()
				.auth()
				.basic("admin", "Smileplease28#");
	}
}
