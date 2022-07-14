package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static stepDefinitions.BaseTest.apiCall;
import static stepDefinitions.BaseTest.verify;

public class Users {
    @Given("User is trying to get all users")
    public void user_is_trying_to_get_all_users() {


    }


    @When("call the  api with page  and pagevalue={string}")
    public void call_the_api_with_page_and_pagevalue(String string) {
        apiCall.callAPI("Users");
    }
    @Then("Users list api status code should be {string}")
    public void users_list_api_status_code_should_be(String string) {
        verify.assertEquals(apiCall.getResponse().statusCode(),Integer.parseInt(string));
        verify.assertAll();
    }

}
