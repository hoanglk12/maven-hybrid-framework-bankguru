package commons;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.BROWSER_LOGS_FOLDER_PATH + File.separator + "FirefoxLog.log");
		driver = new FirefoxDriver(options);
	}

}
