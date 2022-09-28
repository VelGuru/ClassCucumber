package RunnerFile;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Account",
features="Feature",
glue={"stepDefinition"},
plugin={"pretty","html:target/cucumber.html"})
public class Runner {

}
