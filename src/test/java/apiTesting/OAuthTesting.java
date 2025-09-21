package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import POJOClasses.GetCourse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OAuthTesting {
	@Test
	public void testOauth() {
//		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
//		String response = given()
//				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
//				.formParams("scope", "trust").when().log().all()
//				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
//		
//		System.out.println(response);
//		
//		JsonPath jsonPath = new JsonPath(response);
//		
//		String accessToken = jsonPath.getString("access_token");
//		System.out.println("access token is: "+accessToken);
//		
//		GetCourse gc = given()
//			    .queryParams("access_token", accessToken)  // pass token as query param
//			    .when()
//			    .log().all()
//			    .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
//			    .as(GetCourse.class);
//		
//		System.out.println(gc.getInstructors());
//		System.out.println(gc.getCourses().getApiAutomation().get(1).getCourseTitle());
		

				// TODO Auto-generated method stub
			String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
				
			String response = 	given()
				.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type","client_credentials")
				.formParams("scope","trust")
				.when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
			
			System.out.println(response);
			JsonPath jsonPath = new JsonPath(response);
			String accessToken = jsonPath.getString("access_token");
			
			System.out.println(accessToken);
			GetCourse gc=	given()
				.queryParams("access_token", accessToken)
				.when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
			
			System.out.println(gc.getLinkedIn());
			System.out.println(gc.getInstructors());
			System.out.println(gc.getCourses().getApiAutomation().get(1).getCourseTitle());
			
			
	
					
					
					
			
			
			
			
			
			
			
			
			
			
				
				
			}

		

	}
