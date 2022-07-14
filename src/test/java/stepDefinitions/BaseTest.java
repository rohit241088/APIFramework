package stepDefinitions;

import base.ApiCall;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public static ApiCall apiCall;
    public static SoftAssert verify;
    public static JsonPath jsonPath;
    public static Scenario sc;
    @Before
    public void setupTest(Scenario sc){
        BaseTest.sc=sc;
        apiCall=new ApiCall();
        verify=new SoftAssert();
    }

@After
    public void tearDown(Scenario sc){
           apiCall.requestSpecification=null;
        }
}
