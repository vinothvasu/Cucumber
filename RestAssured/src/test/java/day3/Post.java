package day3;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post extends BaseRequest  {

	@Test
	public void post() {

		File jsonFile =new File("./post.json");

		Response response = 
				spec
				.queryParams("sysparm_fields", "sys_id,number,short_description")
				.pathParam("resources", "change_request")
				.body(jsonFile)
				.contentType(ContentType.JSON)
				.post("https://dev61953.service-now.com/api/now/table/{resources}");

		System.out.println(response.prettyPrint());

		JsonPath jsonPath = response.jsonPath();

		//Object sys_id=jsonPath.get("result.sys_id");

		//System.out.println(sys_id);

		sys_id=jsonPath.get("result.sys_id");

	}

}
