package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySitePage {
	WebDriver driver;
	@FindBy(linkText="Dashboard")
	WebElement lnkdashboard;
	public MySitePage (WebDriver driver)
	{
		this.driver=driver;
	}
	public Postpage clickOnPostLink ()
	{
		
		    //WebElement lnkdashboard= driver.findElement(By.linkText("Dashboard"));
		    String firstwindow= driver.getWindowHandle();
		    lnkdashboard.click();
		     System.out.println(driver.getTitle());
		    for (String winHandle : driver.getWindowHandles()) {
		        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    }
		//return new Postpage(driver);
		    return PageFactory.initElements(driver, Postpage.class);
	}
}
