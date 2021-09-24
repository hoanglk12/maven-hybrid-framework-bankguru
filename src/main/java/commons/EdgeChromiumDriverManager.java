package commons;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeChromiumDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

}
