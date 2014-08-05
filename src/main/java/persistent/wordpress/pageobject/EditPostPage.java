package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import persistent.MavenFirstPrj.Login;

public class EditPostPage {
	WebDriver driver;
	@FindBy(css="div.postpost-module-publish.postpost-module > h2")
	WebElement publishMessage;

	@FindBy(linkText="New Post")
	WebElement lnkAddNew;

	
	public EditPostPage (WebDriver driver)
	{
		this.driver=driver;
	}
	public AddNewPost clickOnAddPostLink ()
	{
//WebElement publishMessage= driver.findElement(By.cssSelector("div.postpost-module-publish.postpost-module > h2"));
WebDriverWait waitForPublishMessage= new WebDriverWait(driver, 60);
waitForPublishMessage.until(ExpectedConditions.visibilityOf(publishMessage));
//WebElement lnkAddNew=driver.findElement(By.linkText("New Post"));
lnkAddNew.click();
System.out.println(driver.getTitle());
if (driver.getTitle().equalsIgnoreCase("Add New Post ‹ ashpotadar — WordPress"))
{
	
System.out.println("Add New post page lodaed");}

		//return new AddNewPost(driver);
	return PageFactory.initElements(driver, AddNewPost.class);
	}

}
