package commons;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeManager extends DriverManager{

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1366*768");
		driver = new ChromeDriver(options);
		
	}

}
