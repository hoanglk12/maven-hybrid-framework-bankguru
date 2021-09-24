package commons;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessFirefoxManager extends DriverManager{

	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1366*768");
		driver = new FirefoxDriver(options);
		
	}

	@Override
	protected void closeBrowserAndDriver() {
		// TODO Auto-generated method stub
		
	}

}
