package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class headersDemo {
	//@Test(priority = 1)
	void testHeader()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
	}
	@Test(priority = 2)
	void testHeaderValue()
	{
		Response res = given()
		
						.when()
								.get("https://www.google.com/");
		
		//get single header value
		String headerValue = res.getHeader("Content-Type");
		System.out.println("The Header Value is : "+ headerValue);
		//get all header value 
		Headers header_Values = res.getHeaders();
		
		for (Header hd: header_Values) 
		{
			System.out.println(hd.getName()+" "+hd.getValue());
			
		}
		
	}

}
