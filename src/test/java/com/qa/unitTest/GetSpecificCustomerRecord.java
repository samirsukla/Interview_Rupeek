package com.qa.unitTest;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSpecificCustomerRecord extends BaseClass {
  public GetSpecificCustomerRecord() throws IOException {
		super();
		
	}

@Test
  public void getOneCustomerRecord() {
	boolean flag=false;
	try {
		RestAssured.baseURI = baseURL+prop.getProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer "+tokenId);
		
		Response resp = request.get("/"+phoneNo);
		String respBody = resp.getBody().asString();
		
		String actualPhoneNo = JsonPath.read(respBody, "$.phone");
		int respCode = resp.getStatusCode();
		
		if((actualPhoneNo.equals(phoneNo)) && respCode == 200) {
			flag=true;
		}
		
		
		Assert.assertTrue(flag,"Specific Customer Record can not be fetched");
	}catch(Exception e) {
		e.printStackTrace();
	}
  }
}
