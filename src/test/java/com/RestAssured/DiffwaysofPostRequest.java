package com.RestAssured;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.util.HashMap;
/*
Different ways of post request body
1.post request body using Hashmap
2.post request body creation using org.json
3.post request body creation using POJO class
4.post request body creation using external json file data */

public class DiffwaysofPostRequest {
	//@Test(priority = 1)
	void postusingHashMap()
	{
		HashMap hm = new HashMap<>();
		hm.put("first_name","Yuvaraj");
		hm.put("last_name", "Murugesan");
		hm.put("place", "Chennai");
		hm.put("email", "xxxyyy@xy.com");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("http://localhost:3000/employees")
		.then()
			.statusCode(201)
			.body("first_name", equalTo("Yuvaraj"))//first name is the field and equal to is an expected output
			.body("last_name",equalTo("Murugesan"))
			.body("place", equalTo("Chennai"))
			.body("email", equalTo("xxxyyy@xy.com"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
	}
	//@Test(priority = 2)
	void postusingJson()
	{
		JSONObject jo = new JSONObject();
		jo.put("first_name","Sowmi");
		jo.put("last_name", "Mohan");
		jo.put("place", "China");
		jo.put("email", "xxxyyy@xy.com");
		
		given()
			.contentType("application/json")
			.body(jo.toString())//convert the json file into string
		.when()
			.post("http://localhost:3000/employees")
		.then()
			.statusCode(201)
			.body("first_name", equalTo("Sowmi"))
			.body("last_name",equalTo("Mohan"))
			.body("place", equalTo("China"))
			.body("email", equalTo("xxxyyy@xy.com"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
	}
	//@Test(priority = 1)
	void postusingpojo()
	{
		PostRequestPojoClass ppr = new PostRequestPojoClass();
		ppr.setFirst_name("Faris");
		ppr.setLast_name("Fathima");
		ppr.setPlace("Salem");
		ppr.setEmail("xyzxyz@xyz.com");
		
		given()
			.contentType("application/json")
			.body(ppr)//convert the json file into string
		.when()
			.post("http://localhost:3000/employees")
		.then()
			.statusCode(201)
			.body("first_name", equalTo("Faris"))
			.body("last_name",equalTo("Fathima"))
			.body("place", equalTo("Salem"))
			.body("email", equalTo("xyzxyz@xyz.com"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
	}
	@Test
	void postusingExternalJson()
	{
		File f = new File(".\\body.json");
		
//		FileReader reader = new FileReader();
//		BufferedReader br = new BufferedReader(reader,0);
//		JSONTokener jt = new JSONTokener(reader);
//		JSONObject jo = new JSONObject(jt);
//		FileReader fileReader = new FileReader("file.json");
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		JSONTokener jsonTokener = new JSONTokener(bufferedReader);
		
		given()
			.contentType("application/json")
//			.body(jo.toString())//convert the json file into string
		.when()
			.post("http://localhost:3000/employees")
		.then()
			.statusCode(201)
			.body("first_name", equalTo("Surya"))
			.body("last_name",equalTo("Rolex"))
			.body("place", equalTo("Mumbai"))
			.body("email", equalTo("rolexsir@scorpio.com"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
	}
	//@Test(priority = 2)
	void testDelete()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/employees/3500")//3500 is an id which is created automatically for the inputs we given
		
		.then()
			.statusCode(404);
	}

}
