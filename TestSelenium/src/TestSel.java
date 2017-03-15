import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSel {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");

		WebDriver webdr = new FirefoxDriver();
		
		try {
			Thread.sleep(20*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		webdr.quit();

	}
}
