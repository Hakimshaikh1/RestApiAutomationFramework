package api.endpoints;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class UserEndpoints {
	
	//As per swagger doc
	//Create user 
	public static Response createUser(UserPayload payload) {
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
		
	}
	
	//Get user 
	public static Response getUser(String userName) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				
				.when()
				.get(Routes.get_url);
		
			return response;
				
				
	}
	
	//Update user 
	
	public static Response UpdateUser(String userName, UserPayload payload)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(Routes.put_url);
		
		return response;
	}
	//Delete User
	public static Response deleteUser(String userName) {
		Response response = given()
				.accept(ContentType.JSON)
				
				.pathParam("username", userName)
				
				
				.when()
				.delete(Routes.del_url);
		
			return response;
	}
			
				

}
