package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.verify;

public class Register {
    public static JsonPath registerResponse=null;
    @Given("User is trying to register")
    public void user_is_trying_to_register() {
        // Write code here that turns the phrase above into concrete actions
        apiCall.setRequestClass(requestClassPojo.Register.class);
    }

    @When("call the Register api with user name {string} and password {string}")
    public void call_the_register_api_with_user_name_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("email", string);
        apiCall.body().buildRequestBodyObject("password", string2);
        apiCall.callAPI(requestClassPojo.Register.class.getSimpleName());
    }

    @Then("registration status code should be {string}")
    public void status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Response response = apiCall.getResponse();
        registerResponse=new JsonPath(response.asString());
              verify.assertEquals(apiCall.getResponse().statusCode() , Integer.parseInt(string));
        jsonPath = new JsonPath(response.asString());
         verify.assertAll();
    }

}