package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
public class Login {
    public static JsonPath loginResponse=null;
    @Given("User is trying to login")
    public void user_is_trying_to_login() {
        // Write code here that turns the phrase above into concrete actions

      apiCall.setRequestClass(requestClassPojo.Login.class);

    }
    @When("call the Login api with user name {string} and password {string}")
    public void call_the_login_api_with_user_name_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("email",string);
          apiCall.body().buildRequestBodyObject("password",string2);
          apiCall.callAPI(requestClassPojo.Login.class.getSimpleName());

    }
    @Then("login status code should be {string}")
    public void login_status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Response response=apiCall.getResponse();

        verify.assertEquals(apiCall.getResponse().statusCode(),Integer.parseInt(string));
loginResponse=new JsonPath(response.asString());
         verify.assertAll();

    }


    @Then("status code should be {string}")
    public void status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Response response=apiCall.getResponse();
        response.then().log().all();
       verify.assertTrue(apiCall.getResponse().statusCode()==Integer.parseInt(string));
        verify.assertAll();
    }



}
