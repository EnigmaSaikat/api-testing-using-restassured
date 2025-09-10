package Files;

import apiTesting.BasicTest;

public class PayLoadForDeletePlace {
	public static String DeletePlace() {
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+ BasicTest.pathOfPlaceId +"\"\r\n"
				+ "}";
	}
}
