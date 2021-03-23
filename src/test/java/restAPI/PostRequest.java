package restAPI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

 

import org.testng.annotations.Test;

 

 

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PostRequest {
    Map<String, Object> map = new HashMap<>();

    

    @Test
    public void test1() {
        //json based
        //map based
        //String based
        //file based

 

        
        map.put("firstName", "lipun");
        map.put("lastName", "kumar");
        map.put("salary", 80000000);
        map.put("email", "lipun@gmail.com");
        
        RestAssured.given()
        .baseUri("http://localhost:8088/")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(map)
        .when()
        .post("employees")
        .then()
        .statusCode(201)
        .log()
        ;
    }
    
    @Test
    public void test2() throws IOException {
       
        String jsonfile = new String(Files.readAllBytes(Paths.get("input.JSON")));
       
        RestAssured.given()
        .baseUri("http://localhost:8088/employees")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(jsonfile)
        .when()
        .post()
        .then()
        .statusCode(201)
        .log()
        ;
    }
}
	

