package Files;

public class PayLoadForLibraryAPI {
	public static String payLoadOfLibraryAPI(String bookName, String isbnNumber, String aisleNumber, String bookAuthorName) {
		return "{\r\n"
				+ "  \"name\": \""+bookName+"\",\r\n"
				+ "  \"isbn\": \""+isbnNumber+"\",\r\n"
				+ "  \"aisle\": \""+aisleNumber+"\",\r\n"
				+ "  \"author\": \""+bookAuthorName+"\"\r\n"
				+ "}";
	}
}
