package api.testcases;

//import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

//import api.endpoints.Routes;
import api.endpoints.UserEndpoints;
import api.payload.UserPayload;
import api.utilities.DataProviders;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTestDD {
						
	//Test for create user
	
		@Test(priority=1, dataProvider= "AllData",dataProviderClass=DataProviders.class )
		public void testCreateUser(String Uid, String uName, String fName, String lName, String eMail, String pass, String phone) {
			UserPayload userPayload1 = new UserPayload();
			userPayload1.setId(Integer.parseInt(Uid));
			userPayload1.setUsername(uName);
			userPayload1.setFirstName(fName);
			userPayload1.setLastName(lName);
			userPayload1.setEmail(eMail);
			userPayload1.setPassword(pass);
			userPayload1.setPhone(phone);	

			
			Response response = UserEndpoints.createUser(userPayload1);

			//log response
			response.then().log().all();

			System.out.println("testCreateUser******************************************->>>>>>>--->>>>>>>>---");
			//Validate response
			Assert.assertEquals(response.getStatusCode(), 200);

		}
		
		//Test for Get user
		@Test(priority=2, dataProvider="UserNameData", dataProviderClass=DataProviders.class)
		public void testGetUser(String userName) {


			Response response = UserEndpoints.getUser(userName);

			//log response
			response.then().log().all();

			System.out.println("test-GetUser******************************************->>>>>>>--");
			//Validate response
			Assert.assertEquals(response.getStatusCode(), 200);

		}
		@Test(priority=3, dataProvider="UserNameData", dataProviderClass=DataProviders.class)
		public void testDelete(String userName) {


			Response response = UserEndpoints.deleteUser(userName);

			//log response
			response.then().log().all();

			System.out.println("testDelete******************************************->>>>>>>--");
			//Validate response
			Assert.assertEquals(response.getStatusCode(), 200);

		}
					
}
