package commons;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeChromiumDriverManager extends DriverManager {
	protected final Log log;

	protected EdgeChromiumDriverManager() {
		log = LogFactory.getLog(getClass());
	}

	@Override
	protected void createDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
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
				cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
			} else {
				cmd = "pkill msedgedriver";
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
