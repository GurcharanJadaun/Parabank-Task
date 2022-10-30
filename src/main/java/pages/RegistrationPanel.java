package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import apiObjects.UserData;
import stepDefinitions.BaseClass;

public class RegistrationPanel extends BaseClass {
	WebElement firstNameTextBox;
	WebElement lastNameTextBox;
	WebElement addressTextBox;
	WebElement cityTextBox;
	WebElement stateTextBox;
	WebElement zipCodeTextBox;
	WebElement phoneNoTextBox;
	WebElement ssnTextBox;
	WebElement userNameTextBox;
	WebElement passwordTextBox;
	WebElement confirmPasswordTextBox;
	WebElement registerButton;
	By usernameErrorMessageSelector;

	@SuppressWarnings("static-access")
	public RegistrationPanel() {

		firstNameTextBox = this.browser.driver.findElement(By.name("customer.firstName"));
		lastNameTextBox = this.browser.driver.findElement(By.name("customer.lastName"));
		addressTextBox = this.browser.driver.findElement(By.name("customer.address.street"));
		cityTextBox = this.browser.driver.findElement(By.name("customer.address.city"));
		stateTextBox = this.browser.driver.findElement(By.name("customer.address.state"));
		zipCodeTextBox = this.browser.driver.findElement(By.name("customer.address.zipCode"));
		phoneNoTextBox = this.browser.driver.findElement(By.name("customer.phoneNumber"));
		ssnTextBox = this.browser.driver.findElement(By.name("customer.ssn"));
		userNameTextBox = this.browser.driver.findElement(By.name("customer.username"));
		confirmPasswordTextBox = this.browser.driver.findElement(By.name("repeatedPassword"));
		passwordTextBox = this.browser.driver.findElement(By.name("customer.password"));
		registerButton = this.browser.driver.findElement(By.cssSelector("input.button[value='Register']"));

		usernameErrorMessageSelector = (By.cssSelector("span[id='customer.username.errors']"));

	}

	public boolean isUsernameErrorMessageDisplayed() {
		return this.browser.isElementDisplayed(usernameErrorMessageSelector);
	}

	public boolean isRegisterFormVisible() {
		return registerButton.isDisplayed();
	}

	public void clickRegisterButton() {
		this.registerButton.click();
	}

	public void setUsername(String data) {
		userNameTextBox.clear();
		userNameTextBox.sendKeys(data);
	}

	public void setPassword(String data) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(data);
	}

	public void setConfirmPassword(String data) {
		confirmPasswordTextBox.clear();
		confirmPasswordTextBox.sendKeys(data);
	}

	public void fillRegistrationForm(int num) {
		UserData data = this.runParameters.getUser(num);

		firstNameTextBox.sendKeys(data.getFirstName());

		lastNameTextBox.sendKeys(data.getLastName());

		addressTextBox.sendKeys(data.getAddress());

		cityTextBox.sendKeys(data.getCity());

		stateTextBox.sendKeys(data.getState());

		zipCodeTextBox.sendKeys(data.getZipCode());

		phoneNoTextBox.sendKeys(data.getPhoneNo());

		ssnTextBox.sendKeys(data.getSSN());

		userNameTextBox.sendKeys(data.getUserName());

		passwordTextBox.sendKeys(data.getPassword());

		confirmPasswordTextBox.sendKeys(data.getPassword());

	}

}
