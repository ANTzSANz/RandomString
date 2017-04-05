import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TestSel {

	public static void main(String[] args) throws InterruptedException {

		// regNewAccount();

	}

	public static void regNewAccount() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");

		/*
		 * ProfilesIni profiles = new ProfilesIni();
		 * 
		 * FirefoxProfile profile = profiles.getProfile("default");
		 * 
		 * profile.setPreference("permission.default.image", 1);
		 * 
		 * profile.setPreference("network.proxe.type", 1);
		 * 
		 * profile.setPreference("network.proxe.http", "121.122.123.2");
		 * 
		 * profile.setPreference("network.proxe.http_port", 8502);
		 */
		WebDriver webdr = new FirefoxDriver();

		webdr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		webdr.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		webdr.get("https://www.amazon.com/");

		WebElement newAccountElement = webdr.findElement(By.id("nav-flyout-ya-newCust"));

		WebElement newAccLinkElement = newAccountElement.findElement(By.tagName("a"));

		String newAccLink = newAccLinkElement.getAttribute("href");

		webdr.get(newAccLink);

		WebElement inputNameField = webdr.findElement(By.id("ap_customer_name"));

		inputNameField.sendKeys("Anton Vladimirovich");

		WebElement inputEmailField = webdr.findElement(By.id("ap_email"));

		inputEmailField.sendKeys("sakne@saintly.com");

		WebElement inputPassField = webdr.findElement(By.id("ap_password"));

		inputPassField.sendKeys("1234567890");

		WebElement inputPassCheckField = webdr.findElement(By.id("ap_password_check"));

		inputPassCheckField.sendKeys("1234567890");

		Thread.sleep(1000 * 20);

		WebElement regButton = webdr.findElement(By.id("continue"));

		regButton.click();

		Thread.sleep(1000 * 5);

		String logginedPageLink = webdr.getCurrentUrl();

		webdr.get(logginedPageLink);

		Thread.sleep(1000 * 10);

		/* System.out.println(newAccLink); */

		webdr.quit();
		
		
	}

	public static String getProveLogin(String email, String password) throws InterruptedException {

		String logginedPage = "";

		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");

		WebElement authLinkBtn = driver.findElement(By.id("nav-flyout-ya-signin"));

		WebElement authLinkElement = authLinkBtn.findElement(By.tagName("a"));

		String loginLink = authLinkElement.getAttribute("href");

		driver.get(loginLink);

		WebElement inputEmailField = driver.findElement(By.id("ap_email"));

		inputEmailField.sendKeys(email);

		WebElement inputPassField = driver.findElement(By.id("ap_password"));

		inputPassField.sendKeys(password);

		Thread.sleep(1000 * 20);

		WebElement authButton = driver.findElement(By.id("signInSubmit"));

		authButton.click();

		Thread.sleep(1000 * 10);

		String logginedPageLink = driver.getCurrentUrl();
		
		Thread.sleep(1000 * 10);

		logginedPage = driver.getPageSource();

		return logginedPage;
	}
}
