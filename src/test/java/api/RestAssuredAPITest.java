package api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class RestAssuredAPITest
{
	@BeforeClass
	public static void setUp()
	{
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
	}
	
	@Test
	public void getRequest()
	{
		given().
		when().
			get("/posts/1").
		then().
			statusCode(200).
			body("userId", is(1)).
			body("id", is(1)).
			body("title", containsString("sunt aut facere"));
	}
	
	@Test
	public void postRequest()
	{
		given().
			contentType("application/json").
			body("{ \"title\":\"VR Dev Summit\", \"body\":\"blabla\", \"userId\":123 }").
		when().
			post("posts").
		then().
			statusCode(201).
			body("title", containsString("VR Dev Summit")).
			body("body", containsString("blabla")).
			body("userId", is(123));
	}
	
	@Test
	public void endpointNotFound()
	{
		given().
			contentType("application/json").
		when().
			post("/naoexiste").
		then().
			statusCode(404);
	}
}
