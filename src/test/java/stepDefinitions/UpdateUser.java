package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static stepDefinitions.BaseTest.apiCall;
import static stepDefinitions.BaseTest.verify;

public class UpdateUser {
    @Given("User is trying to update user details")
    public void user_is_trying_to_update_user_details() {
        // Write code here that turns the phrase above into concrete actions
       apiCall.setRequestClass(requestClassPojo.UpdateUser.class);
    }

    @When("call the Register api with name {string} and job {string}")
    public void call_the_register_api_with_name_and_job(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("name", string);
        apiCall.body().buildRequestBodyObject("job", string2);
        apiCall.callAPI(requestClassPojo.UpdateUser.class.getSimpleName());
    }
    @Then("Update user status code should be {string}")
    public void update_user_status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        verify.assertTrue(apiCall.getResponse().statusCode() == Integer.parseInt(string));
    }


}
