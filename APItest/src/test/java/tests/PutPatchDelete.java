package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {
	@Test
	public void put() {
		baseURI= "https://reqres.in/api";
		JSONObject request= new JSONObject();
		request.put("Name", "Garima");
		request.put("Job", "Engineer");
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void patch() {
		baseURI= "https://reqres.in/api";
		JSONObject request= new JSONObject();
		request.put("Name", "Garima");
		request.put("Job", "Tester");
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void delete() {
		baseURI= "https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			delete("/users/2").
		then().
			statusCode(204).log().all();
	}
	
}
