package Steps;

import PageClass.GoogleSearchPage;
import io.cucumber.java.en.Given;

public class GoolgeSearchStep extends GoogleSearchPage{
	

	@Given("I Launch Google")
	public void i_Launch_Google() {
		LaunchGoogle();
	}

	@Given("I Search Something")
	public void i_Search_Something() throws InterruptedException {
		GoogleSearch();
	}
}
