package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static stepDefinitions.BaseTest.*;
public class LoginT {
        public static responseClassPojo.Login loginResponse =null;
        private Response response=null;
    @Given("User is trying to login")
    public void user_is_trying_to_login() {
        // Write code here that turns the phrase above into concrete actions
       if(ifRequestBodyRequired(requestClassPojo.Login.class.getSimpleName())) {
           apiCall.setRequestClass(requestClassPojo.Login.class);
       }
    }

        @When("call the Login api with user name {string} and password {string}")
    public void call_the_login_api_with_user_name_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        apiCall.body().buildRequestBodyObject("email",string).buildRequestBodyObject("password",string2);
         response= apiCall.callAPI(this.getClass().getSimpleName());

    }


    @Then("login status code should be {string}")
    public void login_status_code_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        if(response.getStatusCode()>=200&&response.getStatusCode()<=299){
            loginResponse=response.as(responseClassPojo.Login.class);

        }
         verify.assertEquals(response.statusCode(),Integer.parseInt(string));
         verify.assertTrue(loginResponse.getToken()!=null);
         verify.assertAll();
    }


}
