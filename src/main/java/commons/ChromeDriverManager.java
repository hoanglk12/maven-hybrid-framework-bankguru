package commons;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	protected final Log log;

	protected ChromeDriverManager() {
		log = LogFactory.getLog(getClass());
	}

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver(options);
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
				cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
			} else {
				cmd = "pkill chromedriver";
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
