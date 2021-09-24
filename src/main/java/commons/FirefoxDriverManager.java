package commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {
	protected final Log log;

	protected FirefoxDriverManager() {
		log = LogFactory.getLog(getClass());
	}
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

	@Override
	protected void closeBrowserAndDriver() {
		// Initialize a variable cmd to execute
		String cmd = "";
		try {
			// Get os name and convert to lowercase
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			// Quit driver executable file in Task Manager

			if (osName.contains("windows")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
			} else {
				cmd = "pkill geckodriver";
			}
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				log.info(e.getMessage());
			} catch (InterruptedException e) {
				log.info(e.getMessage());
			}

		}

	}

}
