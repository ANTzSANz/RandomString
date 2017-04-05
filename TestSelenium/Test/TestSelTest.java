import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TestSelTest {

	public static void main(String[] args) throws InterruptedException {

		String someURL = "https://www.amazon.com/s/ref=sr_pg_2?fst=as%3Aon&rh=n%3A2619533011%2Cn%3A2975241011%2Cn%3A2975243011%2Ck%3Ascratching+post&page=2&keywords=scratching+post&ie=UTF8&qid=1491236119&spIA=B01LY5L4ON,B00ZK8QPRO,B0132ACCEG";
		// getSearchURL();
		System.out.println(someURL);
		String linkForPage = getLinkForPage(someURL, 5);
		System.out.println(linkForPage);
		String itemLink ="";
		WebDriver driver = getFirefoxDriver();
		driver.get(searchLink);
		WebElement itemListElement = driver.findElement(By.id("s-results-list-atf"));
		List<WebElement>liElements = itemListElement.findElements(By.tagName("li"));
		WebElement foundElement = liElements.get(9);
		List<WebElement> aElement = foundElement.findElements(By.tagName("a"));
		itemLink = aElements.get(0).getAttribute("href");

		return itemLink;
	}

	private static String getLinkForPage(String someURL, int page) {
		String correctPageLink = "";
		char[] symbols = someURL.toCharArray();
		ArrayList<String> symbs = new ArrayList<>();
		for (int i = 0; i < symbols.length; i++) {
			symbs.add(String.valueOf(symbols[i]));
		}
		int indexForChange = -1;
		boolean pageNotChanged = true;
		for (int i = 0; i < symbs.size(); i++) {

			if (symbs.get(i).equals("=") && symbs.get(i - 1).equals("e") && symbs.get(i - 2).equals("g")
					&& symbs.get(i - 3).equals("a") && symbs.get(i - 4).equals("p")) {
				indexForChange = i + 1;
				System.out.println(correctPageLink);

			}

			if (indexForChange == i && pageNotChanged) {

				if (symbs.get(i + 1).equals("&")) {
					correctPageLink = correctPageLink + String.valueOf(page);
					pageNotChanged = false;
				}
				continue;
			}
			correctPageLink = correctPageLink + symbs.get(i);
		}

		// https://www.amazon.com/s/ref=sr_pg_2?fst=as%3Aon&rh=n%3A2619533011%2Cn%3A2975241011%2Cn%3A2975243011%2Ck%3Ascratching+post&page=2&keywords=scratching+post&ie=UTF8&qid=1491236119&spIA=B01LY5L4ON,B00ZK8QPRO,B0132ACCEG

		return correctPageLink;
	}

	public static WebDriver getFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", "C:\\java\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		return driver;
	}

	public static String getSearchURL() {
		String searchUrl = "";

		WebDriver driver = getFirefoxDriver();

		driver.get("https://www.amazon.com/");

		WebElement inputField = driver.findElement(By.id("twotabsearchtextbox"));
		inputField.sendKeys("scratching post");

		try {
			Thread.sleep(1000 * 15);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-text"));
		searchBtn.click();

		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		String currentUrl = driver.getCurrentUrl();

		driver.get(currentUrl);

		WebElement nextPageLink = driver.findElement(By.id("pagnNextLink"));
		String nextPageHREF = nextPageLink.getAttribute("href");
		driver.get(nextPageHREF);

		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		searchUrl = driver.getCurrentUrl();
		driver.quit();
		return searchUrl;
	}

	public static String itemLink(String searchLink) {
		String itemLink = "";

		WebDriver driver = getFirefoxDriver();
		driver.get(searchLink);

		return itemLink;
	}

}