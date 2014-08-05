package persistent.MavenFirstPrj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginFunctionTestClass {
	WebDriver driver;
	Login testLogin = new Login(driver);
	@Test
	  public void VerifyLoginSucessful() {
		
		testLogin.Login("Uname", "PWD");
	  }
	  @Test
	  public void VerifyInvalidLoginl() {
		  testLogin.invalidLogin("unm", "wrongpwd");
	  }
	  @Test
	  public void VerifyForgotPassword() {
		  testLogin.Forgot_Password("strEmail");
	  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
