package apiTesting;

import org.testng.annotations.Test;

import Files.JsonParsing.ComplexPayloads;
import io.restassured.path.json.JsonPath;

public class CopmlexApiTest {
	@Test
	public void apiTest(){
		JsonPath js = new JsonPath(ComplexPayloads.ComplexPayLoads());
		int Sum = 0;
		System.out.println(js.getInt("courses.size()")); //Print No of courses returned by API
		System.out.println(js.getInt("dashboard.purchaseAmount")); //Print Purchase Amount
		System.out.println(js.getString("courses[0].title"));//Print Title of the first course
		for(int i = 0; i < js.getInt("courses.size()"); i++) {
			System.out.println(js.getString("courses["+i+"].title")+" price is "+js.getInt("courses["+i+"].price")); //Print All course titles and their respective Prices
			if(js.getString("courses["+i+"].title").contains("RPA"))
				System.out.println(js.getInt("courses["+i+"].copies")); //Print no of copies sold by RPA Course
			Sum += (js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
		}

		System.out.println(Sum == js.getInt("dashboard.purchaseAmount")? 
				"Sum of all Course prices matches with Purchase Amount": "Sum of all Course prices not matches with Purchase Amount"); //Verify if Sum of all Course prices matches with Purchase Amount
	}
}
