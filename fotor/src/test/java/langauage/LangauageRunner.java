package langauage;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/EditImage.feature",glue= {"langauage"},
monochrome = true,
plugin={"pretty","html:Reports/HTML/Langauagereport"},
tags="@Language"
)
public class LangauageRunner {

}
