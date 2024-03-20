package api.testcases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.UserPayload;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTest {

	Faker faker;
	UserPayload userPayload1;
	Logger logger;

	@BeforeClass
	public void genrateTestData() {

		faker = new Faker();
		userPayload1 =new UserPayload();

		//Generate Faker
		userPayload1.setId(faker.idNumber().hashCode());
		userPayload1.setUsername(faker.name().username());
		userPayload1.setFirstName(faker.name().firstName());
		userPayload1.setLastName(faker.name().lastName());
		userPayload1.setEmail(faker.internet().safeEmailAddress());
		userPayload1.setPassword(faker.internet().password());
		userPayload1.setPhone(faker.phoneNumber().cellPhone());	
		
		logger = LogManager.getLogger("RestAssuredAutomationFramework_test");	

	}

	//Test for create user
	@Test(priority=1)
	public void testCreateUser() {

		Response response = UserEndpoints.createUser(userPayload1);

		//log response
		response.then().log().all();

		System.out.println("testCreateUser updated------------------>>>>>>>>---");
		//Validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		
//Log
		logger.info("testCreateUser executed***************");
	}

	//Test for Get user
	@Test(priority=2)
	public void testGeteUser() {


		Response response = UserEndpoints.getUser(this.userPayload1.getUsername());

		//log response
		response.then().log().all();

		System.out.println("testGeteUser updated ------------------->>>>>>>--");
		//Validate response
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Log
				logger.info("testGeteUser executed***************");

	}
	//Test for Update user



	@Test(priority=3)
	public void testUpdateUser()
	{
		userPayload1.setFirstName(faker.name().firstName());
		Response response = UserEndpoints.UpdateUser(this.userPayload1.getUsername(),userPayload1);


		//log response
		response.then().log().body();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		System.out.println("after user updated --------------------->>>>>>>>");
		Response responseAfterUpdate = UserEndpoints.getUser(this.userPayload1.getUsername());
		responseAfterUpdate.then().log().all();
		
		//Log
		logger.info("testUpdateUser executed***************");
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		
		Response response = UserEndpoints.deleteUser(this.userPayload1.getUsername());


		//log response
		response.then().log().body();
		System.out.println("after user Deleted -------------------->>>>>>>>>-");

		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Log
				logger.info("testDeleteUser executed***************");

	}
}
