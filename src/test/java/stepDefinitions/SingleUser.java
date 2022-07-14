package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.verify;

public class SingleUser {
    @Given("User is trying to Getuser details")
    public void user_is_trying_to_getuser_details() {


    }
    @When("call the Get single get user api with user {string}")
    public void call_the_get_single_get_user_api_with_user(String string) {
             apiCall.callAPI("SingleUser");
    }

    @Then("get user status code should be {string}")
    public void get_user_status_code_should_be(String string) {
             verify.assertTrue(apiCall.getResponse().statusCode()==Integer.parseInt(string));
    }

}
