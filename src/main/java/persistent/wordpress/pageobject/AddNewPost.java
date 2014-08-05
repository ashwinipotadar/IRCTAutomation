package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewPost {
	WebDriver driver;
	
	@FindBy(id="publish")
	WebElement btnPublish;
	
	@FindBy(id="title")
	WebElement txtPostTitle;
	
	@FindBy(id="tinymce")
	WebElement txtPostDesc;

	public AddNewPost (WebDriver driver)
	{
		this.driver=driver;
	}
	public EditPostPage AddPost (String strTitle, String strDescriptin)
	{
		
	    //WebElement btnPublish=  driver.findElement(By.id("publish"));
	    //WebElement txtPostTitle=driver.findElement(By.id("title"));
	    txtPostTitle.sendKeys(strTitle);
	    String parentHandle = driver.getWindowHandle(); // get the current window handle
	    driver.switchTo().frame("content_ifr");
	    //WebElement txtPostDesc=  driver.findElement(By.id("tinymce"));
	    txtPostDesc.sendKeys(strDescriptin);
	    driver.switchTo().window(parentHandle);
	    WebDriverWait wd= new WebDriverWait(driver, 30);
	    wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("sample-permalink")));
	    btnPublish.click();
	    
		//return new EditPostPage(driver);
	    return PageFactory.initElements(driver, EditPostPage.class);
	}
}
