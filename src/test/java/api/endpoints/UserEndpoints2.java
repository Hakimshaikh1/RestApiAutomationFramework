package api.endpoints;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

public class UserEndpoints2 {
	
	public static ResourceBundle getUrl() {
		ResourceBundle Routes = ResourceBundle.getBundle("Routes");
		
		return Routes;
		
	}
	
	
	//As per swagger doc
	//Create user 
	public static Response createUser(UserPayload payload) {
		
		String post_url = getUrl().getString("post_url");
				
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
		
	}
	
	//Get user 
	public static Response getUser(String userName) {
		
		String get_url = getUrl().getString("get_url");
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				
				.when()
				.get(get_url);
		
			return response;
				
				
	}
	
	//Update user 
	
	public static Response UpdateUser(String userName, UserPayload payload){
		String put_url = getUrl().getString("put_url");
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	//Delete User
	public static Response deleteUser(String userName) {
		
		String del_url = getUrl().getString("del_url");
		Response response = given()
				.accept(ContentType.JSON)
				
				.pathParam("username", userName)
				
				
				.when()
				.delete(del_url);
		
			return response;
	}
			
				

}
