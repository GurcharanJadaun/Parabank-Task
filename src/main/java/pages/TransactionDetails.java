package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import stepDefinitions.BaseClass;

public class TransactionDetails extends BaseClass {

	WebElement transactionDetailsHeader;
	WebElement transactionID;
	WebElement date;
	WebElement description;
	WebElement type;
	WebElement amount;
	
	public TransactionDetails() {
		 transactionDetailsHeader = this.browser.driver.findElement(By.xpath("//h1[text()='Transaction Details']"));
		 transactionID = this.browser.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"));
		 date = this.browser.driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)"));
		 description = this.browser.driver.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(2)"));
		 type = this.browser.driver.findElement(By.cssSelector("tbody tr:nth-child(4) td:nth-child(2)"));
		 amount = this.browser.driver.findElement(By.cssSelector("tbody tr:nth-child(5) td:nth-child(2)"));
	}
	
	public boolean isTransactionDetailsPresent() {
		return this.browser.waitForVisibility(transactionDetailsHeader);
	}
	
}
