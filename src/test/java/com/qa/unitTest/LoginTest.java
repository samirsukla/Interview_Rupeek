package com.qa.unitTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTest extends BaseClass {
  public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
  public void verifyLogin() {
	try {
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		String requestBody = "{\"username\":\""+prop.getProperty("userName")+"\",\"password\":\""+prop.getProperty("password")+"\"}";
	
		Response resp = request.
			when().
			header("Content-Type", "application/json").
			body(requestBody).post("/authenticate");
	
		int statusCode = resp.getStatusCode();

		String respBody = resp.getBody().asString();
		tokenId = JsonPath.read(respBody, "$.token");
		System.out.println(tokenId);
	
		Assert.assertEquals(statusCode,200,"Login API Failed");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
}
