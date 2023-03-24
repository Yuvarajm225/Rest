package com.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class parsingResponseCode {
	@Test
	void testJsonResponse()
	{
//		Approach 1
//		given()
//			.contentType("ContentType.JSON")
//		.when()
//			.get("http://localhost:3000/employees")
//		.then()
//			.statusCode(200)
//			.header("Content-Type", "application/json; charset=utf-8")
//			.body("x[0].place", equalTo(null));
		//Approach 2
		Response res = given()
				.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/employees");
		Assert.assertEquals(res.getStatusCode(),200); //validation
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		String place = res.jsonPath().get("x[0].place").toString();
		Assert.assertEquals(place, "Naperville");
		
		
		
	}

}
