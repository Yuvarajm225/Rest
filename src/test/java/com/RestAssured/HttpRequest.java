package com.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*given()//contents, authentication, query parameters, path parameters cookies
when()// request types get,post,put, delete
then() //validate status code, extract response, extract headers, cookies,response etc...

*/


public class HttpRequest {
	int id;
	@Test(priority = 1)
	void getUsers() 
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200) //validation point
			.body("page",equalTo(2)) //validation point
			.log().all();
		
		
	}
	@Test(priority = 2)
	void createUser()
	{
		HashMap hm = new HashMap<>();
		hm.put("name", "Yuvaraj");
		hm.put("Job", "Automation Engineer");
		
		id=given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id"); // for getting particular id for new data
			
		
		//.then()
		//	.statusCode(201)
		//	.log().all(); 
	}
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateUser() 
	{
		HashMap hm = new HashMap<>();
		hm.put("name", "Yuvaraj");
		hm.put("Job", "Test Lead");
		
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.put("https://reqres.in/api/users/" + id)
			
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	@Test(priority = 4 )
	void deleteUser() 
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/" + id)
		
		.then()
			.statusCode(204)
			.log().all();
		
		
	}
	

}
