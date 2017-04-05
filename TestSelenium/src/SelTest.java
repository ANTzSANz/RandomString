import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelTest {

	public static void main(String[] args) throws InterruptedException {

		String someURL = getSearchURL();
		/* System.out.println(someURL); */
		String linkForPage = getLinkForPage(someURL, 5);
	}

	private static String getLinkForPage(String someURL, int i) {
		String correctPageLink = "";
		//https://www.amazon.com/s/ref=sr_pg_2?fst=as%3Aon&rh=n%3A2619533011%2Cn%3A2975241011%2Cn%3A2975243011%2Ck%3Ascratching+post&page=2&keywords=scratching+post&ie=UTF8&qid=1491236170&spIA=B01LY5L4ON,B00ZK8QPRO,B0132ACCEG
			char[] symbols = someURL.toCharArray();		
			ArrayList<Character> symbs = new ArrayList<>();
			for(int k=0; k<symbols.length; k++){
				symbs.add(String.valueOf(symbols[k]));
							}
			int indexForChange=-1;
			boolean pageNotChanged = true;
			for(int k=0; k<symbols.length; k++){
				correctPageLink = correctPageLink + symbs.get(k);
				if(symbs.get(k).equals("=")&&symbs.get(k-1).equals("e")&&symbs.get(k-2).equals("g")&&symbs.get(k-3).equals("a")&&symbs.get(k-4).equals("p")){
					indexForChange = k+1;
									}
				if(indexForChange==k && pageNotChanged){
					symbs.remove(k);
					
					if(!symbs.get(k+1).equals("&")){
						char[] page;
						correctPageLink = correctPageLink  +String.valueOf(page);
						pageNotChanged = false;
					}
					k--;
				}
					
			}
		
		return correctPageLink;
	}

	public static WebDriver getFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		return driver;
	}

	private static String getSearchURL() {

		String searchUrl = "";

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.com/");

		WebElement inputField = driver.findElement(By.id("twotabsearchtextbox"));

		inputField.sendKeys("scratching post");

		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		WebElement searchBtnBlock = driver.findElement(By.id("nav-search-submit-text"));

		searchBtnBlock.click();

		try {
			Thread.sleep(1000 * 7);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		String currentUrl = driver.getCurrentUrl();

		driver.get(currentUrl);

		WebElement nextPageLink = driver.findElement(By.id("pagnNextLink"));

		String nextPageHREF = nextPageLink.getAttribute("href");

		driver.navigate().to(nextPageHREF);

		/* nextPageLink.click(); */

		try {
			Thread.sleep(1000 * 7);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
			getSearchURL();
		}

		String nextPageUrl = driver.getCurrentUrl();

		driver.get(nextPageUrl);

		try {
			Thread.sleep(1000 * 7);
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