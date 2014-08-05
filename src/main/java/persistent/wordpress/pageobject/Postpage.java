package persistent.wordpress.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Postpage {
	WebDriver driver;
	@FindBy(xpath="//li[@id='menu-posts']/a/div[3]")
	WebElement menuPost;
	
	@FindBy(css="a.add-new-h2")
	WebElement lnkAddNew;
	
	
	public Postpage (WebDriver driver)
	{
		this.driver=driver;
	}
	public AddNewPost clickOnAddPostLink ()
	{
	    //WebElement menuPost= driver.findElement(By.xpath("//li[@id='menu-posts']/a/div[3]"));

	    menuPost.click();
	    //WebElement lnkAddNew= driver.findElement(By.cssSelector("a.add-new-h2"));

	    lnkAddNew.click();
	
		//return new AddNewPost(driver);
	    return PageFactory.initElements(driver, AddNewPost.class);
	}

}
