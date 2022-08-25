package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class RESTdemo {

	@Test
	public void test1() {
		Response response= get("https://reqres.in/api/users?page=2");
		int statuscode= response.statusCode();
		System.out.println(statuscode);
		System.out.println(response.time());
		System.out.println(response.body().asString());
		System.out.println(response.statusLine());
		System.out.println(response.header("content-type"));
		
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void test2() {
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).log().all();
		
	}
}
