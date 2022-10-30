package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserHelper {
	public static WebDriver driver;
	public BrowserHelper(){}
	
	public void setupBrowser() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions option = new ChromeOptions();	
		option.addArguments("start-maximized");
		option.merge(caps);
		System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("<<Chrome Browser Setup successful>>");
	}
	public void openUrl(String browserUrl) {
		driver.get(browserUrl);
	}
	public void closePage() {
		driver.close();
	}
	public void closeBrowser() {
		driver.quit();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void waitAndClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}
	
	public void waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean waitForVisibility(WebElement ele) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		if(wait.until(ExpectedConditions.visibilityOf(ele)) != null) {
			result = true;
		}
		return result;
	}
	
	public boolean isElementDisplayed(By locator) {
		boolean result = false;
		try {
			result = driver.findElement(locator).isDisplayed();
		}catch(NoSuchElementException ex) {
			System.out.println("<<Could not locate the element  with locator >>"+locator.toString());
		}
		return result;
	}
	
}
