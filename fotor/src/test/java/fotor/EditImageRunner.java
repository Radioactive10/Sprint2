package fotor;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/EditImage.feature",glue= {"fotor"},
tags="@EditImage",
monochrome = true,
plugin={"pretty","junit:Reports/JunitReports/Editreport.xml"}
)
public class EditImageRunner {
	

}
