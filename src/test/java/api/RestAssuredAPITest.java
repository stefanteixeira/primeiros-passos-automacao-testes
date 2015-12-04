package api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class RestAssuredAPITest
{
	@Test
	public void getRequest()
	{
		given().
		when().
			get("http://jsonplaceholder.typicode.com/posts/1").
		then().
			body("userId", is(1)).
			body("id", is(1)).
			body("title", containsString("sunt aut facere"));
	}
	
	@Test
	public void endpointNotFound()
	{
		given().
			accept("application/json").
			contentType("application/json").
		when().
			post("http://jsonplaceholder.typicode.com/naoexiste").
		then().
			statusCode(404);
	}
}
