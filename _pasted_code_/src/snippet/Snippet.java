package snippet;

public class Snippet {
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

