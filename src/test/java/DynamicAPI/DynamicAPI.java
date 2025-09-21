package DynamicAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayLoadForLibraryAPI;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DynamicAPI {
	@Test(dataProvider = "BookData")
	public void testDynamicAPI(String bookName, String isbnNumber, String aisleNumber, String bookAuthorName) {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String responseForAddingABook = given().log().all().header("Content-Type","application/json").
		body(PayLoadForLibraryAPI.payLoadOfLibraryAPI(bookName, isbnNumber, aisleNumber, bookAuthorName))
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
		.asString();
		
		System.out.println(responseForAddingABook);
	}
	
	@DataProvider(name = "BookData")
	public Object[][] getData(){
		return new Object[][] {{"API Testing","bkcd","669","Saikat Das"}};
	}
}
