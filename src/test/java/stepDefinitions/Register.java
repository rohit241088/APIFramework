package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static stepDefinitions.BaseTest.*;
import static stepDefinitions.BaseTest.verify;

public class Register {
  public static responseClassPojo.Register registerResponse =null;
    private Response response=null;
    @Given("User is trying to register")
    public void user_is_trying_to_register() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Token catched in Registration class"+Login.loginResponse.getToken());
        apiCall.setRequestClass(requestClassPojo.Register.class);
            }

    @When("call the Register api with user name {string} and password {string}")
    public void call_the_register_api_with_user_name_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("email", string).buildRequestBodyObject("password", string2);
        response = apiCall.callAPI(this.getClass().getSimpleName());
    }

    @Then("registration status code should be {string}")
    public void status_code_should_be(String string) {
                if(response.getStatusCode()>=200&&response.getStatusCode()<=299){
               registerResponse=response.as(responseClassPojo.Register.class);
                  }
               verify.assertEquals(response.statusCode() , Integer.parseInt(string));
        verify.assertAll();
    }

}