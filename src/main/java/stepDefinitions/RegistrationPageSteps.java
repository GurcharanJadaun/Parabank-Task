package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;

import apiObjects.UserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountServicesPanel;
import pages.LoginPanel;
import pages.RegistrationPanel;
import utility.ApiHandler;

public class RegistrationPageSteps extends BaseClass {

	LoginPanel loginPanel;
	RegistrationPanel registrationPanel;
	AccountServicesPanel accountServicesPanel;

	@Given("^I navigate to URL$")
	public void navigateToUrl() throws Throwable {
		this.browser.openUrl("https://parabank.parasoft.com");
	}

	@Given("^I verify (.*) page is displayed$")
	public void verifyPage(String pageName) throws Throwable {
		String title = this.browser.getTitle();
		loginPanel = new LoginPanel();
		boolean result = title.contains(pageName) && loginPanel.isLoginPanelDisplayed();
		assertEquals(result, true);
	}

	@Given("^I login with user (.*)$")
	public void loginWithUser(String userName) throws Throwable {
		loginPanel = new LoginPanel();

		loginPanel.enterDataInUserNameTextBox(userName);
		loginPanel.enterDataInPasswordTextBox("ahdfg123655");
		loginPanel.clickloginButton();

	}

	@Given("I generate data for {int} user")
	public void generateData(int number) throws Throwable {
		ApiHandler api = new ApiHandler();
		while (number > 0) {
			this.runParameters.addUser(api.generateUser());
			number--;
		}
	}

	@Given("I display data for user {int}")
	public void displayUserData(Integer userNum) throws Throwable {
		UserData data = this.runParameters.getUser(userNum);
		data.display();
	}

	@When("I click on Register Link on login panel")
	public void clickRegisterUserLink() throws Throwable {
		loginPanel = new LoginPanel();
		loginPanel.clickRegisterNewUserLink();
	}

	@Then("I verify user registration form is available")
	public void checkUserRegisterForm() throws Throwable {
		registrationPanel = new RegistrationPanel();
		assertEquals(registrationPanel.isRegisterFormVisible(), true);
	}

	@Then("I fill the form details with user {int} details")
	public void fillUserRegisterForm(Integer num) throws Throwable {
		registrationPanel = new RegistrationPanel();
		registrationPanel.fillRegistrationForm(num);
	}

	@Then("I wait for {int} seconds")
	public void hardWait(Integer num) throws Throwable {
		Thread.sleep(num * 1000);
	}

	@Then("I click Register button on Registration panel")
	public void clickRegisterButtonOnRegistrationPanel() throws Throwable {
		registrationPanel = new RegistrationPanel();
		registrationPanel.clickRegisterButton();
	}

	@Then("I make user {int} account has been created")
	public void makeUserAccountHasBeenCreated(Integer num) throws Throwable {

		try {
			accountServicesPanel = new AccountServicesPanel();
		} catch (NoSuchElementException ex) {
			registrationPanel = new RegistrationPanel();
			UserData obj = this.runParameters.getUser(num);
			String random = "";
			while (registrationPanel.isUsernameErrorMessageDisplayed()) {
				random = this.generateRandomStringOfLength(5);

				registrationPanel.setUsername(obj.getUserName() + random);
				registrationPanel.setPassword(obj.getPassword());
				registrationPanel.setConfirmPassword(obj.getPassword());

				registrationPanel.clickRegisterButton();
			}
			accountServicesPanel = new AccountServicesPanel();
			if (random.length() > 0) {
				obj.setUserName(obj.getUserName() + random);
				this.runParameters.updateUserData(num, obj);
			}

		}
		finally {
		assertEquals(accountServicesPanel.checkIfUserIsLoggedIn(), true);
		}
	}

}
