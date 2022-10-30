package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import apiObjects.UserData;

public class ApiHandler {
	public UserData generateUser() {
	  RequestSpecification requestSpec = new RequestSpecBuilder().build();
	  requestSpec.baseUri("https://randomuser.me/api/");
	  JsonPath path;
	 do {
	  Response res=given().spec(requestSpec).get();
	   path=new JsonPath(res.body().asString());
	 }while(!path.get("results[0].id.name").equals("SSN"));
	  UserData data = new UserData(path);
	return data;
	}
	
}
