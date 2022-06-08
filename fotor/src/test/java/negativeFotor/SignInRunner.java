package negativeFotor;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Negativefea/Signin.feature",glue= {"negativeFotor"},
monochrome = true
//tags="@smoketest"
)
public class SignInRunner {

}
