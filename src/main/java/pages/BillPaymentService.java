package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import apiObjects.UserData;
import stepDefinitions.BaseClass;

public class BillPaymentService extends BaseClass {

	List<WebElement> billPaymentHeaders;
	WebElement billPaymentServiceHeader;
	WebElement billPaymentSuccessHeader;
	WebElement billPaymentErrorHeader;
	WebElement payeeNameTextBox;
	WebElement addressTextBox;
	WebElement cityTextBox;
	WebElement stateTextBox;
	WebElement zipCodeTextBox;
	WebElement phoneNoTextBox;
	WebElement accountNumberTextBox;
	WebElement verifyAccountNumberTextBox;
	WebElement amountTextBox;
	WebElement accountDropDown;
	WebElement sendPaymentButton;

	By successMessageSelector;

	public BillPaymentService() {

		billPaymentHeaders = this.browser.driver.findElements(By.cssSelector("div[ng-show] h1.title"));
		payeeNameTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(1) td:nth-child(2) input"));
		addressTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(2) td:nth-child(2) input"));
		cityTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(3) td:nth-child(2) input"));
		stateTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(4) td:nth-child(2) input"));
		zipCodeTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(5) td:nth-child(2) input"));
		phoneNoTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(6) td:nth-child(2) input"));
		accountNumberTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(8) td:nth-child(2) input"));
		verifyAccountNumberTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(9) td:nth-child(2) input"));
		amountTextBox = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(11) td:nth-child(2) input"));
		accountDropDown = this.browser.driver
				.findElement(By.cssSelector("table tbody tr:nth-child(13) td:nth-child(2) select"));
		sendPaymentButton = this.browser.driver.findElement(By.cssSelector("input.button[value = 'Send Payment']"));
		billPaymentServiceHeader = this.browser.driver.findElement(By.cssSelector("div[ng-show='showForm'] h1.title"));
		billPaymentSuccessHeader = this.browser.driver
				.findElement(By.cssSelector("div[ng-show='showResult'] h1.title"));
		billPaymentErrorHeader = this.browser.driver.findElement(By.cssSelector("div[ng-show='showError'] h1.title"));

		successMessageSelector = By.cssSelector("div[ng-show='showResult'] p:nth-child(2)");
	}

	public void clickSendPaymentButton() {
		sendPaymentButton.click();
	}

	public String getSuccessMessage() {
		this.browser.waitForVisibility(successMessageSelector);
		return this.browser.driver.findElement(successMessageSelector).getText();
	}

	public boolean verifyBillPaymentServiceHeader() {
		boolean header = this.browser.waitForVisibility(billPaymentServiceHeader);
		return header;
	}

	public boolean verifyBillPaymentSuccessHeader() {
		boolean header = this.browser.waitForVisibility(billPaymentSuccessHeader);
		return header;
	}

	public boolean verifyBillPaymentErrorHeader() {
		boolean header = this.browser.waitForVisibility(billPaymentErrorHeader);
		return header;
	}

	public void fillPaymentForm(int from, int to, String amount) {
		UserData fromUser = this.runParameters.getUser(from);
		UserData toUser = this.runParameters.getUser(to);

		payeeNameTextBox.sendKeys(toUser.getFirstName() + " " + toUser.getLastName());
		addressTextBox.sendKeys(toUser.getAddress());
		cityTextBox.sendKeys(toUser.getCity());
		stateTextBox.sendKeys(toUser.getState());
		zipCodeTextBox.sendKeys(toUser.getZipCode());
		phoneNoTextBox.sendKeys(toUser.getPhoneNo());
		accountNumberTextBox.sendKeys(toUser.getAccountNumbers().get(0));
		verifyAccountNumberTextBox.sendKeys(toUser.getAccountNumbers().get(0));
		amountTextBox.sendKeys(amount);

		Select obj = new Select(accountDropDown);
		obj.selectByValue(fromUser.getAccountNumbers().get(0));
	}

}
