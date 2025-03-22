package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
//Generate/creating data using Faker library and pass it to the POJO class(class User)
//and this data will send along with POST resquest
	Faker faker;//globally defined for the method
	User userPayload; 
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
//above data to post in below code
	@Test(priority=1)
	public void testPostUser(){
		Response response = UserEndPoints.createUser(userPayload);
//we can validate response on all types like below
		
		response.then().log().all();//validate all
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void testGetUserByName(){
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();//validate all
		response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	public void tesUpdateUserByName(){
//Update data using Payload, here it will regenerate fname/lname/emailaddress
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);

		response.then().log().body().statusCode(200);//Restassured Assertion
		Assert.assertEquals(response.getStatusCode(), 200);//TestNg Assertion
//Checking data after update
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();//validate all
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);	
		
	}
	@Test(priority=4)
	public void testUserByName() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
