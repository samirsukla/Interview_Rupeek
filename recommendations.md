# Suggestions from My side
1. The Authentication API response body should give proper information to the end user rather than just displaying a token value.
2. JSONObject is not working when trying to pass the payload as individual JSONObject. As the payload is simple and very less, It should be allowed in all the possible ways.
     Example Code : 
	JSONObject jobj = new JSONObject();

	jobj.put("username", "rupeek"); 
	jobj.put("password", "password");
	request.body(jobj.toJSONString());

4. In case of invalid authentication, the message should be proper. Now its just displaying as "Unauthoorized" for error and message field both.
5. I guess there is no need to display the path field in the response api in case of invalid authentication.
