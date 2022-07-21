package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesHelper;

public class Request {

    public RequestSpecification requestSpecification = null;
    public static PropertiesHelper configHelper = null;



    public Request() {
        if(configHelper==null){
            configHelper = new PropertiesHelper(System.getProperty("user.dir") + "//src//main//resources//config.properties");
        }
        requestSpecification = RestAssured.given();
       requestSpecification.baseUri((String) configHelper.getValue("baseURI"));
        requestSpecification.contentType("application/json");
    }





}
