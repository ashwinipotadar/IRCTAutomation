package persistent.MavenFirstPrj;

import java.security.DomainCombiner;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  private static Logger log=Logger.getLogger(NewTest.class);
@Test
  public void f() {
	DOMConfigurator.configure("log4j.xml");
	  System.out.println("First Test method");
	  log.info("First Test Method");
	  
  }
  @Test (dependsOnMethods={ "f" })
  public void secondMethod() {
		DOMConfigurator.configure("log4j.xml");

	  System.out.println("second Test method");
	  log.info("Second Test Method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Test method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Test method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Befor class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Befor Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Befor Test Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Test Suite");
  }

}
