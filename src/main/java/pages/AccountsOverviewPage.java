package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import apiObjects.UserData;
import stepDefinitions.BaseClass;

public class AccountsOverviewPage extends BaseClass {

	WebElement accountsOverviewHeading;
	List<WebElement> accountRows;
	List<WebElement> accountDetails;
	List<WebElement> balanceDetails;
	List<WebElement> availableAmountDetails;

	public AccountsOverviewPage() {
		accountsOverviewHeading = this.browser.driver.findElement(By.cssSelector("h1.title"));
		accountRows = this.browser.driver.findElements(By.cssSelector("#accountTable tbody tr"));

	}

	public boolean accountOverviewPageIsDisplayed() {
		return accountsOverviewHeading.isDisplayed();
	}

	private ArrayList<String> getAccountNumber() {
		ArrayList<String> accountNumberList = new ArrayList<String>();

		for (int i = 0; i < (accountRows.size() - 1); i++) {
			WebElement ele = accountRows.get(i);
			String num = ele.findElement(By.cssSelector("td:nth-child(1)")).getText();
			accountNumberList.add(num);
		}
		return accountNumberList;
	}

	private ArrayList<Float> getBalance() {
		ArrayList<Float> balanceList = new ArrayList<Float>();

		for (int i = 0; i < (accountRows.size() - 1); i++) {
			WebElement ele = accountRows.get(i);
			String num = ele.findElement(By.cssSelector("td:nth-child(2)")).getText();
			balanceList.add(Float.parseFloat(num.substring(1).replaceAll(",", "").trim()));
		}
		return balanceList;
	}

	private ArrayList<Float> getAvailableBalance() {
		ArrayList<Float> availableBalanceList = new ArrayList<Float>();

		for (int i = 0; i < (accountRows.size() - 1); i++) {
			WebElement ele = accountRows.get(i);
			String num = ele.findElement(By.cssSelector("td:nth-child(3)")).getText();
			availableBalanceList.add(Float.parseFloat(num.substring(1).replaceAll(",", "").trim()));
		}
		return availableBalanceList;
	}

	public void clickBankAccount(int num) {
		
		this.browser.waitForVisibility(By.cssSelector("td a"));
		accountRows = this.browser.driver.findElements(By.cssSelector("#accountTable tbody tr"));
		WebElement ele = accountRows.get(num-1).findElement(By.cssSelector("td a"));
		ele.click();
		
	}
	
	public boolean storeBankBalanceForUser(int num) {
		boolean result = true;
		if (accountRows.size() < 2) {
			int maxTry = 5;
			while (accountRows.size() < 2 && maxTry > 0) {
				accountRows = this.browser.driver.findElements(By.cssSelector("#accountTable tbody tr"));
				maxTry--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		ArrayList<Float> availableBalance = getAvailableBalance();
		ArrayList<Float> balance = getBalance();
		ArrayList<String> accountNumber = getAccountNumber();

		UserData obj = this.runParameters.getUser(num);

		for (int index = 0; index < accountNumber.size(); index++) {
			obj.addAccountInformation(accountNumber.get(index), balance.get(index), availableBalance.get(index));
		}
		this.runParameters.updateUserData(num, obj);
		
		result = accountNumber.size() > 0;
		return result;
	}

}
