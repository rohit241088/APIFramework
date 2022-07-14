package stepDefinitions;

import base.ApiCall;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.path.json.JsonPath;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public static ApiCall apiCall;
    public static SoftAssert verify;
    public static JsonPath jsonPath;
    @Before
    public void setupTest(){
        apiCall=new ApiCall();
        verify=new SoftAssert();
    }

@After
    public void tearDown(){
        apiCall.requestSpecification=null;
        }
}
