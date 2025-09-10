package apiTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.PayLoadForDeletePlace;
import Files.PayLoadForUpdatePlace;
import Files.PayLoadFrorAddPlace;

public class BasicTest {
	
	public static String pathOfPlaceId;
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add Place
		System.out.println("===========================Add Place===========================");
		String ResponseForAddPlace = given().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(PayLoadFrorAddPlace.AddPlace()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).
		header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();		
		JsonPath js = new JsonPath(ResponseForAddPlace);
		pathOfPlaceId = js.getString("place_id");
		System.out.println(pathOfPlaceId);
		
		//Update Place
		System.out.println("===========================Update Place===========================");
		String ResponseForUpdatePlace = given().queryParam("place_id", pathOfPlaceId).queryParam("key", "qaclick123")
		.body(PayLoadForUpdatePlace.updatePlace()).when().put("/maps/api/place/update/json").then().log().all().assertThat().
		statusCode(200).extract().response().asString();
		
		//Get Place
		System.out.println("===========================Get Place===========================");
		String ResponseForGetPlace = given().queryParam("place_id", pathOfPlaceId).queryParam("key", "qaclick123").when()
				.get("/maps/api/place/get/json").then().log().all()
				.assertThat()
				.statusCode(200).extract().response().asString();
		
		//Delete Place
		System.out.println("===========================Delete Place===========================");
		String ResponseForDeletePlace = given().queryParam("key", "qaclick123").body(PayLoadForDeletePlace.DeletePlace()).when().delete("/maps/api/place/delete/json")
				.then().log().all().assertThat().statusCode(200).extract().response().toString();
		
	}

}
