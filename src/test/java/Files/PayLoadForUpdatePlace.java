package Files;

import apiTesting.BasicTest;

public class PayLoadForUpdatePlace {

	public static String updatePlace() {
		 return "{\r\n"
	                + "\"place_id\":\"" + BasicTest.pathOfPlaceId + "\",\r\n"
	                + "\"address\":\"70 winter walk, USA\",\r\n"
	                + "\"key\":\"qaclick123\"\r\n"
	                + "}";
	}
}
