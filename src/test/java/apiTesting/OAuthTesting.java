package apiTesting;

import org.testng.annotations.Test;
import POJOClasses.GetCourse;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class OAuthTesting {
	@Test
	public void testOauth() {
		String response = given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);

		String accessToken = jsonPath.getString("access_token");
		System.out.println("access token is: " + accessToken);

		GetCourse gc = given().queryParams("access_token", accessToken) // pass token as query param
				.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

	}
}
