package at.ac.tuwien.inso.swtesten.lab;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Random;
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

import at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver;

public class SportsIDRegisterSeleniumHelper {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://sportsid.risedev.at/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  
  public void loadLoginPage() {
	    driver.get(baseUrl + "/personal/#pages.registration");
  }
  
  @Test
  public void testUntitled() throws Exception {
    driver.findElement(By.id("member-family-name")).clear();
    driver.findElement(By.id("member-family-name")).sendKeys("TESTEROVA");
    driver.findElement(By.id("member-first-name")).clear();
    driver.findElement(By.id("member-first-name")).sendKeys("TESTEROVA");
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("member-gender-m")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.id("ui-id-201")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    driver.findElement(By.id("ui-id-253")).click();
    driver.findElement(By.id("registration-comment")).clear();
    driver.findElement(By.id("registration-comment")).sendKeys("Why not!");
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("password");
    driver.findElement(By.id("input-password-confirm")).clear();
    driver.findElement(By.id("input-password-confirm")).sendKeys("password");
    driver.findElement(By.id("input-terms")).click();
    driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();
    driver.findElement(By.linkText("12")).click();
    driver.findElement(By.id("create-account")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.id("ui-id-263")).click();    
    Random randomGenerator = new Random();
	driver.findElement(By.id("input-email")).sendKeys(randomGenerator.nextInt(1000000000) + "@email.com");
    driver.findElement(By.id("create-account")).click();
  }

  public void successTextVisible(){
		assertNotNull(driver.findElement(By.xpath("//*[@id=\"single-page-content\"]/div/form/h1")));
		try {
			tearDown();
		} catch (Exception e) {
			e.printStackTrace();
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
