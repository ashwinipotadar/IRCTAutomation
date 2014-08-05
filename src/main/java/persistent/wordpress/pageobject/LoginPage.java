package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.*;

import persistent.MavenFirstPrj.Login;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user_login")
	WebElement txtlogin;
	
	@FindBy(id="user_pass")
	WebElement txtPwd;
	
	@FindBy(id="wp-submit")
	WebElement btnLogin;
	
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	public DashboardPage login_sucessful (String strUname, String strPwd)
	{
//		WebElement txtlogin=driver.findElement(By.id("user_login"));
//	    WebElement txtPwd=driver.findElement(By.id("user_pass"));
//	    WebElement btnLogin=driver.findElement(By.id("wp-submit"));
	    txtlogin.clear();
	    txtlogin.sendKeys(strUname);
	    txtPwd.clear();
	    txtPwd.sendKeys(strPwd);
	    btnLogin.click();
		return PageFactory.initElements(driver, DashboardPage.class);
	}

}
