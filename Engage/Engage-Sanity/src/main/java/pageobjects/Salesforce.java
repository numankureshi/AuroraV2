package pageobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Salesforce {
	
	private static String token_type = null;
	private static String access_token = null;
	
	
	/*** 
	 * Public constructor to connect Salesforce and initialize the token_type and access_token for oauth2
	 */
	public Salesforce() {
		RestAssured.baseURI = "https://login.salesforce.com/services/oauth2/token";
		RequestSpecification request = RestAssured.given().queryParam("grant_type", "password")
				.queryParam("client_id", "3MVG9wt4IL4O5wvJoSsCUgWdG7xzM_6W5y5dd6YUS9e79pYmiuCrNBFeppoqX5fqi_28OdQRzBzgpedKEeMNa")
				.queryParam("client_secret", "8D2B170226E055C8A7A8B040DA487127F537D4D9293428AACE0DFF85ED9AF65C")
				.queryParam("username","nayan@zisystech.com")
				.queryParam("password", "Maxrunner@123")
				.header("Content-Type", "application/json");
		Response response = request.post();
		token_type = response.jsonPath().getString("token_type");
		access_token = response.jsonPath().getString("access_token");
	}
	
	
	/**
	 * Get all records from list by passing query as parameter in Salesforce
	 * @param query
	 * @return
	 */

	public Response getRecords(String query) {
		RestAssured.baseURI = "https://zisysetch-dev-ed.my.salesforce.com/services/data/v55.0/query";
		RequestSpecification request = RestAssured.given()
				.headers("Authorization", token_type + " " + access_token)
				.queryParam("q", query);
		return request.get();
	}
	

}
