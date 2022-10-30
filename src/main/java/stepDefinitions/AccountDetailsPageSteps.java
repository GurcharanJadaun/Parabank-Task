package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Then;
import pages.AccountDetails;
import pages.BillPaymentService;

public class AccountDetailsPageSteps extends BaseClass{

	AccountDetails accountDetails;
	
	@Then("I verify Account Details header is displayed")
	public void isAccountDetailsHeader() throws Throwable {
		accountDetails = new AccountDetails();
		assertEquals(accountDetails.isAccountDetailsHeaderVisible(),true);
	}
	
	@Then("I verify there is a Debit transaction of {float} dollars towards user {int}")
	public void verifyTransaction(Float amount, Integer userNum) throws Throwable {
		accountDetails = new AccountDetails();
		accountDetails.verifyTransactionForUser(userNum,amount);
	}
}
