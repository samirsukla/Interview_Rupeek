package com.qa.unitTest;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetCustomerRecords extends BaseClass {
  public GetCustomerRecords() throws IOException {
		super();
		
	}

@Test
  public void getAllCustomerRecords() {
	try {
		RestAssured.baseURI = baseURL+prop.getProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer "+tokenId);
		
		Response resp = request.get();
		String respBody = resp.getBody().asString();
		
		int totalRecords = JsonPath.read(respBody, "$.length()");
		int randomNo = ThreadLocalRandom.current().nextInt(0, totalRecords);
		
		//System.out.println("Total Record = "+totalRecords); 
		
		phoneNo = JsonPath.read(respBody, "$.["+randomNo+"].phone");
		//System.out.println(phoneNo);
		
		int respCode = resp.getStatusCode();
		
		Assert.assertEquals(respCode,200,"Customer Records can not be fetched");
	}catch(Exception e) {
		e.printStackTrace();
	}
  }
}
