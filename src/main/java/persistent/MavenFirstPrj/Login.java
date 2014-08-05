package persistent.MavenFirstPrj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	/*
	 * This is class for login to wordpress
	 */
	 private WebDriver driver= new FirefoxDriver();;
	  private String baseUrl= "https://wordpress.com/";
	  public Login (WebDriver driver)
	  {
		  this.driver=driver;
	  }
	  public void getWordpressURL()
	  {
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get(baseUrl);
		  WebElement lnkLogin= driver.findElement(By.linkText("Log In"));
		  lnkLogin.click();
	  }
	public void enterUserName(String strUname)
	{
	    WebElement txtPwd=    driver.findElement(By.id("user_login"));
	    txtPwd.clear();
	    txtPwd.sendKeys(strUname);
	}
	public void enterPwd(String strPwd)
	{
		WebElement txtlogin=driver.findElement(By.id("user_pass"));
		txtlogin.clear();
	    txtlogin.sendKeys(strPwd);
	}
	public void clickLoginButton()
	{
		  WebElement btnLogin=     driver.findElement(By.id("wp-submit"));
		   btnLogin.click();
	}
	public void Login (String strUsername, String strPassword)
	{
			getWordpressURL();
			System.out.println(driver.getTitle());
			enterUserName("ashpotadar@gmail.com");
		    enterPwd("sanash1!");
		    clickLoginButton();	  
	}
	
	public boolean invalidLogin(String strUsername, String strPassword)
	{
		return false;
		
	}
	public void Forgot_Password(String strEmail)
	{
		
	}
	public void SignUp (String [] data)
	{
		
	}
}
