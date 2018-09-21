package day3;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete extends BaseRequest {

	@Test(dependsOnMethods="day3.Post.post")
	public void delete() {

		Response response = spec
				.pathParam("resources", "change_request")
				//.contentType(ContentType.JSON)
				.delete("https://dev61953.service-now.com/api/now/table/{resources}/"+sys_id);
			
		System.out.println(response.statusCode());	
	}
	
}
