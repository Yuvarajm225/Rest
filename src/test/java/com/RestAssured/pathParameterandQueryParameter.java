package com.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class pathParameterandQueryParameter {
	
	//https://reqres.in//api/users?page=2&id=5
	
	@Test
	void testPathandQuery()
	{
		
		given()
			.pathParam("mypath", "users") //path parameter
			.queryParam("page", 2) //query parameter
			.queryParam("id", 7) //query parameter
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
