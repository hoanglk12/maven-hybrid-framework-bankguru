package commons;

public class DriverFactoryManager {

	private enum BROWSER {
		CHROME, FIREFOX, EDGE_LEGACY, EDGE_CHROMIUM, HEADLESS_CHROME, HEADLESS_FIREFOX, INTERNETEXPLORER;
	}

	public static DriverManager getBrowser(String browserName) {
		DriverManager driverManager;
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			driverManager = new FirefoxDriverManager();
		} else if (browser == BROWSER.CHROME) {
			driverManager = new ChromeDriverManager();
		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			driverManager = new EdgeChromiumDriverManager();
		} else if (browser == BROWSER.HEADLESS_FIREFOX) {
			driverManager = new HeadlessFirefoxManager();
		} else if (browser == BROWSER.HEADLESS_CHROME) {
			driverManager = new HeadlessChromeManager();
		} else {
			throw new RuntimeException("Please input the correct browserName");
		}
		return driverManager;
	}
}
