package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;

	protected abstract void createDriver();

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver(String appUrl) {
		if (driver == null) {
			createDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return this.driver;
	}
}
