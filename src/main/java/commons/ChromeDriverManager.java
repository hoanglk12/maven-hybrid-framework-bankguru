package commons;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager{

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

}
