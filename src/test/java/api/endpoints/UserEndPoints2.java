package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//this(endpoints)class used for create/read/update/Delete requests to the user API.
public class UserEndPoints2 {

	public static Response createUser(User payload) {
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)

				.when().post(Routes.post_url);

		return response;

		// .then() we not use this, we get response above and validate

	}

	public static Response readUser(String userName) {
		Response response = given().pathParam("userName", userName).when().post(Routes.get_url);

		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
				.pathParam("userName", userName).body(payload).when().put(Routes.update_url);

		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("userName", userName).when().delete(Routes.delete_url);
		return response;
	}

}
