package persistent.MavenFirstPrj;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import persistent.reusable.FileHandle;

import com.thoughtworks.selenium.Wait;

public class AddPostDDT {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://wordpress.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys("ashpotadar@gmail.com");
    driver.findElement(By.id("user_pass")).clear();
    driver.findElement(By.id("user_pass")).sendKeys("sanash1!");
    driver.findElement(By.id("wp-submit")).click();
    driver.findElement(By.linkText("My Sites")).click();
    driver.findElement(By.linkText("Dashboard")).click();
    System.out.println(driver.getTitle());
    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    }
    
    driver.findElement(By.xpath("//li[@id='menu-posts']/a/div[3]")).click();
    driver.findElement(By.cssSelector("a.add-new-h2")).click();
  }

  @Test(dataProvider="AddPostdata")
  public void testDashboard(String strTitle, String strDescriptin) throws Exception {
	  driver.get("https://ashpotadar.wordpress.com/wp-admin/post-new.php");
	  System.out.println("Data input : "+strTitle+","+strDescriptin);
	  driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys(strTitle);
    String parentHandle = driver.getWindowHandle(); // get the current window handle
    driver.switchTo().frame("content_ifr");
    driver.findElement(By.id("tinymce")).clear();
    driver.findElement(By.id("tinymce")).sendKeys(strDescriptin);
    driver.switchTo().window(parentHandle);
    WebDriverWait wd= new WebDriverWait(driver, 30);
       wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("sample-permalink")));
    driver.findElement(By.id("publish")).click();
    WebDriverWait WD= new WebDriverWait(driver, 60);
    WD.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.postpost-module-publish.postpost-module > h2"))));
    
    
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
 	/*public String[][] getExcelData(String xlPath, String shtName) throws BiffException, IOException
    {
Workbook workbk = Workbook.getWorkbook(new File(xlPath));
System.out.println(shtName);
Sheet sht = workbk.getSheet(shtName);
int rowCount = sht.getRows();
int colCount = sht.getColumns();
String [] [] tabArray = new String[rowCount][colCount];
for (int i = 0; i < rowCount; i++) {
   for (int j = 0; j < colCount; j++) {
   	System.out.println("i: "+i+"j : "+j);
   	System.out.println(sht.getCell(j, i).getContents());
       tabArray[i][j] = sht.getCell(j, i).getContents();
   }
}
return (tabArray);
}*/
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    
    }
  

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
