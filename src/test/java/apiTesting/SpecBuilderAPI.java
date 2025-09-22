package apiTesting;

import org.testng.annotations.Test;

import POJOClasses.Location;
import POJOClasses.addPlace;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;

import io.restassured.specification.RequestSpecification;

public class SpecBuilderAPI {
	@Test
	public void specAPITest() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
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
		RequestSpecification res = given().spec(req).body(add).log().all();
			res.when().post("/maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
	}
}
