package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.sc;

public class UpdateUser {
    private Response response=null;
    private responseClassPojo.UpdateUser updateUser=null;
    @Given("User is trying to update user details")
    public void user_is_trying_to_update_user_details() {
        // Write code here that turns the phrase above into concrete actions
       apiCall.setRequestClass(requestClassPojo.UpdateUser.class);
    }

    @When("call the Register api with name {string} and job {string} and user {string}")
    public void call_the_register_api_with_name_and_job_and_user(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("name", string).buildRequestBodyObject("job", string2);
        response=apiCall.callAPI(requestClassPojo.UpdateUser.class.getSimpleName(),"index",string3);

    }
    @Then("Update user status code should be {string}")
    public void update_user_status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        if(response.getStatusCode()>=200&&response.getStatusCode()<=299){
            sc.log("User name is "+updateUser.getName());
            sc.log("User email is "+updateUser.getJob());
        }
        int actualStatusCode=response.statusCode();
        int expected=Integer.valueOf(string);
        sc.log("Actual status code is "+actualStatusCode+" and expected is "+expected);
        verify.assertTrue(actualStatusCode==expected);
        verify.assertAll();
    }


}
