package day3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Incident_JSON {
	
	@Test
	public void get() {
//		BasicAuthScheme auth=new BasicAuthScheme();
//		auth.setUserName("admin");
//		auth.setPassword("Smileplease28#");
		
		Map<String, String> parametersMap=new HashMap<String, String>();
		
		parametersMap.put("sys_created_by", "admin");
		
		parametersMap.put("type", "normal");
				
		Response response = RestAssured
				.given()
				.auth()
				.basic("admin", "Smileplease28#")
				//.param("sys_created_by", "admin")
				//.params("sys_created_by", "admin", "type", "normal")
				.params(parametersMap)
				//.param("type", "normal")
				.get("https://dev61953.service-now.com/api/now/table/change_request");
		
		//System.out.println(response.prettyPrint());
		
		JsonPath jsonPath = response.jsonPath();
		
		List<Object> list = jsonPath.getList("result.number");
		
		int size=list.size();
		
		System.out.println(list.size());
		
		System.out.println(list.get(size-1));
				
	}

}
