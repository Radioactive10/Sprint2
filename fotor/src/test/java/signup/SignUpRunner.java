package signup;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/EditImage.feature",glue= {"signup"},
monochrome = true,
plugin={"pretty","junit:Reports/JunitReports/Signup.xml"},
tags="@Signup"
)
public class SignUpRunner {

}
