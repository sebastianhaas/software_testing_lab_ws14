package at.ac.tuwien.inso.swtesten.lab;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SportsIDSeleniumHelper {
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
	    driver.get(baseUrl + "/#pages.login");
  }
  
  @Test
  public void login_enterAccountInfo() throws Exception {
    driver.findElement(By.id("input-username")).clear();
    driver.findElement(By.id("input-username")).sendKeys("gruppe22a");
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("1234");
  }
  
  @Test
  public void login_clickOnLogin() throws Exception {
	    driver.findElement(By.id("login-button")).click();
  }
  
  @Test
  public void assertLogoutButtonVisibile() {
		assertNotNull(driver.findElement(By.xpath("//*[@id=\"logout-button\"]")));
  }
  
  @Test
  public void assertOnLoginPage() {
		assertNotNull(driver.findElement(By.xpath("//*[@id=\"login-button\"]/span")));
  }
//*[@id="members-table"]/thead/tr[2]/th[2]/div/input
  public void loadMemberListPage() {
	  driver.get(baseUrl + "/admin.html#pages.member.list");
  }
  
  @Test
  public void assertOnMemberListPage() {
		assertNotNull(driver.findElement(By.xpath("//*[@id=\"new-member\"]/span/span")));		
  }
  
  @Test
  public void assertMemberTest1Exists() {
		assertNotNull(driver.findElement(By.xpath("//*[@id=\"members-table\"]/tbody/tr/td[2]")));
  }
  
  @Test
  public void searchForTEST1(){
	    driver.findElement(By.xpath("//*[@id=\"members-table\"]/thead/tr[2]/th[2]/div/input")).click();
	    driver.findElement(By.xpath("//*[@id=\"members-table\"]/thead/tr[2]/th[2]/div/input")).clear();
	    driver.findElement(By.xpath("//*[@id=\"members-table\"]/thead/tr[2]/th[2]/div/input")).sendKeys("TEST1");
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