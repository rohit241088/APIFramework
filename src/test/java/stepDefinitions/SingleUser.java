package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.verify;

public class SingleUser {
    private Response response=null;
private responseClassPojo.SingleUser singleUser=null;
    @Given("User is trying to Getuser details")
    public void user_is_trying_to_getuser_details() {


    }
    @When("call the Get single get user api with user {string}")
    public void call_the_get_single_get_user_api_with_user(String string) {
                 response=apiCall.callAPI(this.getClass().getSimpleName(),"index",string);
                 singleUser=response.as(responseClassPojo.SingleUser.class);

    }

    @Then("get user status code should be {string}")
    public void get_user_status_code_should_be(String string) {
        if(response.getStatusCode()>=200&&response.getStatusCode()<=299){
            singleUser=response.as(responseClassPojo.SingleUser.class);
        }
               verify.assertEquals(response.statusCode(),Integer.parseInt(string));
             verify.assertAll();
    }

}

