package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import stepDefinitions.BaseClass;

public class LoginPanel extends BaseClass{
	WebElement userNameTextBox;
	WebElement passwordTextBox;
	WebElement loginButton;
	WebElement registerNewUserLink;
	@SuppressWarnings("static-access")
	public LoginPanel(){
	
		userNameTextBox = this.browser.driver.findElement(By.name("username"));
		passwordTextBox = this.browser.driver.findElement(By.name("password"));
		loginButton = this.browser.driver.findElement(By.cssSelector(".login .button"));
		registerNewUserLink = this.browser.driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		
	}
	
	public boolean isLoginPanelDisplayed() {
		
		return this.userNameTextBox.isDisplayed();
	}
	
	public void clickRegisterNewUserLink() {
		this.registerNewUserLink.click();
	}
	
	public void enterDataInUserNameTextBox(String username) {
	 	this.userNameTextBox.sendKeys(username);
	}
	
	public void enterDataInPasswordTextBox(String password) {
		this.passwordTextBox.sendKeys(password);
	}

	public void clickloginButton() {
		this.loginButton.click();
	}
}
