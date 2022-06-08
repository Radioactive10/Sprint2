package saveimages;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/EditImage.feature",glue= {"saveimages"},
tags="@SaveImage",
monochrome = true,
plugin={"pretty","json:Reports/JSONReports/saveimage.json",
	
	}
)
public class SaveImageRunner {
	

}
