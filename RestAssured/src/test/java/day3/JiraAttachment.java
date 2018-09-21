package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class JiraAttachment extends JiraBase {

	@Test(dataProvider="images")
	public void jiraAddAttachment(String file) {

		File uploadFile=new File("./"+file);
			
		List<Header> allHeaders=new ArrayList<Header>();
		allHeaders.add(new Header("X-Atlassian-Token","no-check"));

		Headers headers=new Headers(allHeaders);
		
		Response response = 
				spec
				//.header(new Header("X-Atlassian-Token","no-check"))
				.headers(headers)
				.multiPart(uploadFile)
				.post("https://vino90.atlassian.net/rest/api/2/issue/PP-38/attachments");

		System.out.println(response.prettyPrint());
	}

	@DataProvider(name="images")
	public Object[] getData() {

		Object [] data=new Object[3];

		data[0] = "myfile.png";
		data[1]= "myfile2.png";
		data[2]= "myfile3.png";

		return data;


	}
}
