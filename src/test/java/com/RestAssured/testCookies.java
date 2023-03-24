package com.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class testCookies {
	//@Test(priority = 1)
	void  cookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC", "ARSKqsLTx4JYhlq9ynVSgs4EVc_6BDmv9XukFD29KDTx01jD6QFFj7DtuA") //cookie name and value
			.log().all();
	}
	@Test(priority = 2)
	void getCookiesInfo()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		//get single cookie info
		//String cookie_Value = res.getCookie("AEC");
		//System.out.println("The value of cookie is : "+ cookie_Value);
		
		//get all cookie info
		Map<String, String> cookies_Values = res.getCookies();
		System.out.println(cookies_Values.keySet());// key set is used to get the cookies names
		
		for (String k: cookies_Values.keySet()) 
		{
			String cookie_Value = res.getCookie(k);
			System.out.println(k + " " + cookie_Value);
			
		}
	}

}
