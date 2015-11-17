package AutomationWithWebDrive.webApps;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SimpleExample {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  String path = "C:\\Users\\Papatheodorou\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\pstqfrxg.default";
		  File profileDirectory = new File(path);
		  FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		  driver = new FirefoxDriver(profile);
		  
	   
	    baseUrl = "https://www.google.gr/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test1() throws Exception {
		  driver.get(baseUrl);
		    driver.findElement(By.id("lst-ib")).clear();
		    driver.findElement(By.id("lst-ib")).sendKeys("cat");
		    driver.findElement(By.name("btnG")).click();
		    driver.findElement(By.linkText("Cat - Wikipedia, the free encyclopedia")).click();
		    try {
		      assertTrue(isElementPresent(By.linkText("felids")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
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
