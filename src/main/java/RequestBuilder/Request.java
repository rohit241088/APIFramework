package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesHelper;

public class Request {

    public RequestSpecification requestSpecification = null;
    public PropertiesHelper configHelper = null;



    public Request() {
        requestSpecification = RestAssured.given();
        configHelper = new PropertiesHelper(System.getProperty("user.dir") + "//src//main//java//resources//config.properties");
        requestSpecification.baseUri((String) configHelper.getValue("baseURI"));
        requestSpecification.contentType("application/json");
    }





}
