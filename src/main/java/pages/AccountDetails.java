package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import apiObjects.UserData;
import stepDefinitions.BaseClass;

public class AccountDetails extends BaseClass {
	WebElement accountDetailsHeader;
	WebElement accountNumber;
	WebElement accountType;
	WebElement balance;
	WebElement availableBalance;

	WebElement accountActivityHeader;
	WebElement activityPeriod;
	WebElement transactionType;
	WebElement goButton;

	By transactionRows;

	public AccountDetails() {
		accountDetailsHeader = this.browser.driver.findElement(By.xpath("//h1[text()='Account Details']"));
		accountNumber = this.browser.driver
				.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2)"));
		accountType = this.browser.driver
				.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2)"));
		balance = this.browser.driver
				.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(3) td:nth-child(2)"));
		availableBalance = this.browser.driver
				.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(4) td:nth-child(2)"));
		accountActivityHeader = this.browser.driver.findElement(By.xpath("//h1[text()='Account Activity']"));
		activityPeriod = this.browser.driver.findElement(
				By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) select"));
		transactionType = this.browser.driver.findElement(
				By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) select"));
		goButton = this.browser.driver.findElement(By.cssSelector("td input.button"));

		transactionRows = By.cssSelector("table:nth-child(4) tbody tr");
	}

	public boolean isAccountDetailsHeaderVisible() {
		return this.browser.waitForVisibility(accountDetailsHeader);
	}

	public boolean verifyTransactionForUser(int userNum, float amount) {
		boolean result = false;

		this.browser.waitForVisibility(transactionRows);
		UserData data = this.runParameters.getUser(userNum);
		List<WebElement> tableColumns = this.browser.driver.findElement(transactionRows)
				.findElements(By.cssSelector("td"));
		String expectedAmount = String.valueOf(amount);
		String actualAmount = tableColumns.get(2).getText().substring(1);
		String expectedMessage = tableColumns.get(1).getText();
		
		result = expectedAmount.equals(actualAmount)
				&& expectedMessage.contains(data.getFirstName() + " " + data.getLastName());
		return result;
	}
}
