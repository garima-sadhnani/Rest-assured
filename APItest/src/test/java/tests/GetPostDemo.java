package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetPostDemo {
	
	@Test 
	public void getDemo() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("Byron","Rachel")).
			statusCode(200).log().all();
	}
	
	
	@Test
	public void postDemo() {
		baseURI= "https://reqres.in/api";
//		Map<String, Object> map= new HashMap<String, Object>();
//		map.put("Name", "Garima");
//		map.put("Job", "Engineer");
//		System.out.println(map);
		
		JSONObject request= new JSONObject();
		request.put("Name", "Garima");
		request.put("Job", "Engineer");
//		System.out.println(request);
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}

}
