package stepDefinitions;

import static org.testng.Assert.assertEquals;

import apiObjects.UserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountServicesPanel;
import pages.AccountsOverviewPage;
import pages.BillPaymentService;

public class AccountPageSteps extends BaseClass {
	AccountServicesPanel accountServicesPanel;
	AccountsOverviewPage accountsOverviewPage;
	BillPaymentService billPaymentService;

	@Then("I verify user is successfully logged in")
	public void displayUserData() throws Throwable {
		accountServicesPanel = new AccountServicesPanel();
		assertEquals(accountServicesPanel.checkIfUserIsLoggedIn(), true);
	}

	@When("^I click on (.*) on Account service tab$")
	public void clickOnAccountService(String service) throws Throwable {
		accountServicesPanel = new AccountServicesPanel();
		accountServicesPanel.clickOnService(service);
	}

	@Then("I verify bank account information is being displayed")
	public void displayAccountOverview() throws Throwable {
		accountsOverviewPage = new AccountsOverviewPage();
		assertEquals(accountsOverviewPage.accountOverviewPageIsDisplayed(), true);
	}

	@Then("I store bank account information for user {int}")
	public void getUserAccounts(Integer num) throws Throwable {
		accountsOverviewPage = new AccountsOverviewPage();
		accountsOverviewPage.storeBankBalanceForUser(num);
	}

	@Then("^I verify (.*) is displayed on Bill Service Panel$")
	public void getHeadingOn(String data) throws Throwable {
		billPaymentService = new BillPaymentService();
		boolean actual=false;
		if(data.equalsIgnoreCase("Bill Payment Service")) {
		 actual = billPaymentService.verifyBillPaymentServiceHeader();
		}
		else if(data.equalsIgnoreCase("Bill Payment Complete")) {
		 actual = billPaymentService.verifyBillPaymentSuccessHeader();
		}
		else {
		 actual = billPaymentService.verifyBillPaymentErrorHeader();		
		}
		assertEquals(actual,true);
	}

	@Then("I send an amount of {int} from user {int} to user {int}")
	public void fillPaymentDetails(Integer amount, Integer from, Integer to) throws Throwable {
		billPaymentService = new BillPaymentService();
		billPaymentService.fillPaymentForm(from, to, amount.toString());
		billPaymentService.clickSendPaymentButton();
	}
	
	@Then("I click send payment button on Bill Payment form")
	public void sendPaymentButton() throws Throwable {
		billPaymentService = new BillPaymentService();
		billPaymentService.clickSendPaymentButton();
	}
	
	@Then("I verify Success Message is displayed")
	public void getSuccessMessageForBillPayment() throws Throwable {
		billPaymentService = new BillPaymentService();
		System.out.println(billPaymentService.getSuccessMessage());
	}
	
	@When("I click on Account number in row {int}")
	public void getAccountRows(Integer num) throws Throwable {
		accountsOverviewPage = new AccountsOverviewPage();
		accountsOverviewPage.clickBankAccount(num);
	}

}
