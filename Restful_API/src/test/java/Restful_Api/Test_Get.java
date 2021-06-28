package Restful_Api;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get {
	@Test(priority = 1)
	  public void List_user() {
		
		String URL ="https://reqres.in/api/users";
		Response response = RestAssured.get(URL);
		  
		  System.out.println("List of user:"+response.getBody().asString());
		  System.out.println("Statues Code:"+response.getStatusCode());
		  
		  int statuescode = response.getStatusCode();
		  Assert.assertEquals(statuescode,200);
		  
	  }
	  @Test(priority = 2)
	  public void Single_user_not_fount() {
		  String URL="https://reqres.in/api/users/23";
		  Response response = RestAssured.get(URL);
		  
		  System.out.println("List of user:"+response.getBody().asString());
		  System.out.println("Statues Code:"+response.getStatusCode());
		  
		  int stauescode = response.getStatusCode();
		  AssertJUnit.assertEquals(stauescode,404);
	  }

}
