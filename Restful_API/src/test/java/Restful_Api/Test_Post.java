package Restful_Api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Post {
	@Test(priority = 1)
	public void  Successful_registration() {
		String URL="https://reqres.in/api/resgister";
		String ContentType ="application/json";
		String BodyData ="{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}";
		
		Response response = RestAssured.
				given().
				contentType(ContentType).
				body(BodyData).
				when().
				post(URL).
				then().
				extract().
				response();
		//when i write statuescode 200 give me error but i run this API at postman and give me the result of  status code was 201 
		Assert.assertEquals(response.getStatusCode(),201,"Response code mismatch");
		String email =response.jsonPath().get("email");
		String password=response.jsonPath().get("password");
		
		Assert.assertEquals(email,"eve.holt@reqres.in","email mismatch");
		Assert.assertEquals(password,"pistol","password mismatch" );
	}
		
		@Test(priority = 2)
		public void UNSuccessful_registration() {
			String URL="https://reqres.in/api/register";
			String ContentType ="application/json";
			String BodyData ="{\r\n"
					+ "    \"email\": \"sydney@fife\"\r\n"
					+ "}";
			
			Response response = RestAssured.
					given().
					contentType(ContentType).
					body(BodyData).
					when().
					post(URL).
					then().
					extract().
					response();
			
			Assert.assertEquals(response.getStatusCode(),400,"Response code mismatch");
			/*
			String email =response.jsonPath().get("email");
			Assert.assertEquals(email,"sydney@fife","Missing password");
			*/
}
		}
