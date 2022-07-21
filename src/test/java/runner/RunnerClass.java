package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"}
        ,plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber" }
//        ,tags ="@Login"

)
public class RunnerClass {

}
