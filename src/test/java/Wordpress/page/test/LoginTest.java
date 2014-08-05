package Wordpress.page.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import persistent.reusable.FileHandle;
import persistent.wordpress.pageobject.AddNewPost;
import persistent.wordpress.pageobject.DashboardPage;
import persistent.wordpress.pageobject.EditPostPage;
import persistent.wordpress.pageobject.LoginPage;
import persistent.wordpress.pageobject.MySitePage;
import persistent.wordpress.pageobject.Postpage;

public class LoginTest {
	WebDriver driver;
	LoginPage LP;
	DashboardPage DP;
	MySitePage MP;
	Postpage PostPage;
	AddNewPost addPost;
	EditPostPage editPost;
	String baseUrl = "https://wordpress.com/";
	
/*	@FindBy(linkText="Log In")
	private  WebElement lnkLogin;*/
	
	@BeforeTest
	public void loginnavigatetoAddPost()
	{
		
		  driver= new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get(baseUrl);
		  WebElement lnkLogin= driver.findElement(By.linkText("Log In"));
		  lnkLogin.click();
		  LP= PageFactory.initElements(driver, LoginPage.class);
		  DP=LP.login_sucessful("ashpotadar@gmail.com", "sanash1!");
		  /*MP=DP.NavigateToMysite();
		  PostPage=MP.clickOnPostLink();
		  addPost=PostPage.clickOnAddPostLink();*/
	}
  @Test(dataProvider="AddPostdata")
  public void testAddPost(String strTitle, String strDescriptin) {
	  

	  editPost=  addPost.AddPost( strTitle,  strDescriptin);
	  addPost=editPost.clickOnAddPostLink();
	  //  LP=DP.logout();
	  
  }
  @AfterTest
  public void teardown()
  {
	  driver.quit();
  }
  @DataProvider(name="AddPostdata")
  public Object[][] movieData () throws Exception
  {
	  String sheetPath = "./src/test/AddPost.xls";
	  FileHandle FH = new FileHandle();
	   Object[][] retObjArr = FH.getExcelData(sheetPath, "AddPost");
	    System.out.println("getData function executed!!");
	    return retObjArr; 	 	 
  }
}
