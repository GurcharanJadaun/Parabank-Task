package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import stepDefinitions.BaseClass;

public class AccountServicesPanel extends BaseClass {

	List<WebElement> accountServices;
	WebElement welcomeMessage;

	@SuppressWarnings("static-access")
	public AccountServicesPanel() {
		accountServices = this.browser.driver.findElements(By.cssSelector("#leftPanel li"));
		welcomeMessage = this.browser.driver.findElement(By.cssSelector("#leftPanel .smallText"));
	}

	private WebElement returnService(String serviceName) {
		WebElement ele = null;
		for (WebElement element : accountServices) {
			if (element.getText().equalsIgnoreCase(serviceName)) {
				ele = element;
				break;
			}
		}
		return ele;
	}

	public void clickOnService(String serviceName) {
		WebElement ele = returnService(serviceName);
		ele.click();
	}

	public boolean checkIfUserIsLoggedIn() {
		return welcomeMessage.isDisplayed();
	}

}