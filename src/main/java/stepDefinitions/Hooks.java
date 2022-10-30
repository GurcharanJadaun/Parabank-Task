package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
    public void beforeScenario(){
		this.generateScenarioId();
        this.browser.setupBrowser();
    }	
	
	@After
    public void afterScenario(){
        this.browser.closeBrowser();
    }
	
	
}