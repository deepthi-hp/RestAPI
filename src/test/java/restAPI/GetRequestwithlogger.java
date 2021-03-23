package restAPI;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetRequestwithlogger {
	  static Logger logger = Logger.getLogger(Loggers.class);
	    Response response;
	    
	    @BeforeTest
	    public void setup() {
	        
	        BasicConfigurator.configure();
	        logger.setLevel(Level.DEBUG);
	        
	        response = RestAssured.given()
	                .baseUri("http://localhost:8088/employees")
	                .when()
	                .get();
	    }
	    
	    @Test
	    public void test1() {
	        
	        logger.info("*************************Inside CheckStatus Code********************");

	 

	        int statusCode = response.getStatusCode();
	        
	        logger.info("StatusCode ==> " +statusCode);
	        
	        Assert.assertEquals(statusCode, 200);
	
}
}
