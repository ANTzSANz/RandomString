import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;

public class AccountCreatorTest {

	@Test
	public void testCreateNewAccount() {
		Account account = AccountCreator.createNewAccount();
		assertEquals("246813579", account.password);
	}
	
	/*@Test
	public void testGetProxyFirefoxDriver() {
		WebDriver driver = AccountCreator.getProxyFirefoxDriver();
		String content = driver.getPageSource();
		WebDriverFactory.dismissDriver(driver);
		assertTrue(content.contains("Amazon.com"));
		
	}*/
	@Test
	public void testGetRandomIndex() {
		
	}
	
	@Test
	public void testGetRandomAccEmail() {
		
	}
	
	@Test
	public void testGetRandomAccName() {
		
	}
	
	@Test
	public void testGetRandomName() {
		
	}
	
	@Test
	public void testGetRandomNumber() {
		
	}
	

}
