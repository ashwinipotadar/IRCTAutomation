package persistent.reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {

	public void setupAutomation()
	{
		// do some stuff
	}
	public WebDriver selectBrowser(String strBrowserName)
	{
		WebDriver driver = null;
		if (strBrowserName.equalsIgnoreCase("firefox"))
		{
		 driver = new FirefoxDriver();
		}
		return driver;
		// do some stuff
	}
}
