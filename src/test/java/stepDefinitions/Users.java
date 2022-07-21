package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.sc;

public class Users {
    private Response response=null;
    private responseClassPojo.Users users=null;
    @Given("User is trying to get all users")
    public void user_is_trying_to_get_all_users() {


    }


    @When("call the  api with page  and pagevalue={string}")
    public void call_the_api_with_page_and_pagevalue(String string) {
        apiCall.addQueryParameter("page",Integer.parseInt(string));
       response= apiCall.callAPI(this.getClass().getSimpleName());


    }
    @Then("Users list api status code should be {string}")
    public void users_list_api_status_code_should_be(String string) {
        if(response.getStatusCode()>=200&&response.getStatusCode()<=299){
            users=response.as(responseClassPojo.Users.class);
        }
        int actualStatusCode=response.statusCode();
        int expected=Integer.valueOf(string);
        verify.assertEquals(response.statusCode(),Integer.parseInt(string));
        verify.assertAll();
    }

}
