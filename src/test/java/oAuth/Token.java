package oAuth;

import org.json.JSONObject;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Token{
    
    public String Gettoken() {
        
        String Token = null;
        String TokenType = null;
        Response response = RestAssured.given().baseUri("http://localhost:8088")
            .auth().preemptive().basic("rest-assured", "password")
            .contentType("application/x-www-form-urlencoded")
            .formParam("username", "onlyfullstack")
            .formParam("password", "secret")
            .formParam("grant_type", "password")
            .when()
            .post("oauth/token");
        
        String responsestring = response.then().extract().asString();
       // System.out.println(responsestring);
        JSONObject jobj = new JSONObject(responsestring);
        
        Token = jobj.getString("access_token");
        TokenType = jobj.getString("token_type");
        
        System.out.println(Token);
        System.out.println(TokenType);
        
        
        return Token;
        
    }
    
    @Test
    public void test1() {
    	String Token=Gettoken();
    	Response response=RestAssured.given()
    			                      .baseUri("http://localhost:8088")
    			                      .auth()
    			                      .oauth2(Token)
    			                      .when()
    			                      .get("students");
    	String responsebody=response.then().extract().asString();
    	System.out.println(responsebody);
    	
    }
    
}
