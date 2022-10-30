package RunnerScripts;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(

		features = "src/main/java/featureFiles"

		,glue={"stepDefinitions"}

		,plugin = {"pretty", "html:target/cucumber"}
		
		,tags = "@Test1"

		)


public class RunnerClass extends AbstractTestNGCucumberTests  {
	

}