package apiTesting;

import org.testng.annotations.Test;

import POJOClasses.Location;
import POJOClasses.addPlace;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;

public class SerializationTesting {
	@Test
	public void SerializationTes() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		addPlace add = new addPlace();
		add.setAccuracy(50);
		add.setName("Frontline house");
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress("29, side layout, cohen 09");
		add.setWebsite("http://google.com");
		add.setLanguage("French-IN");
		List<String> types = Arrays.asList("shoe park", "shop");
		add.setTypes(types);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		add.setLocation(l);
		String response = given().log().all().queryParam("key", "qaclick123").body(add).when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response().asString();
	}
}
