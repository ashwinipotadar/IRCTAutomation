package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	@FindBy(linkText="My Sites")
	WebElement lnkMySite;
	
	public DashboardPage (WebDriver driver)
	{
		this.driver=driver;
	}
public LoginPage logout()
{
	driver.findElement(By.cssSelector("html.wp-toolbar body.wp-admin.wp-core-ui.js.mp6.admin-color-mp6.legacy-color-fresh.postpost.post-php.auto-fold.admin-bar.post-type-post.branch-4.version-4-0.admin-color-fresh.locale-en.multisite.customize-support.svg div#wpwrap div#wpadminbar.ltr div#wp-toolbar.quicklinks ul#wp-admin-bar-top-secondary.ab-top-secondary.ab-top-menu li#wp-admin-bar-my-account.menupop.with-avatar.no-grav a.ab-item span.ab-display-name")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
return new LoginPage(driver);
}
public MySitePage NavigateToMysite ()
{
	 //WebElement lnkMySite= driver.findElement(By.linkText("My Sites"));
	 lnkMySite.click();
	 //return new MySitePage(driver);
	 return PageFactory.initElements(driver, MySitePage.class);
}
}
