package at.ac.tuwien.inso.swtesten.lab;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SportsIdOrderMembershipsSeleniumHelper {

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
		assertNotNull(driver
				.findElement(By.xpath("//*[@id=\"logout-button\"]")));
	}

	@Test
	public void assertOnLoginPage() {
		assertNotNull(driver.findElement(By
				.xpath("//*[@id=\"login-button\"]/span")));
	}

	public void navigateToOrderMembership() throws Exception {
		driver.get(baseUrl
				+ "/admin.html#pages.order.wizard.buy_membership_nat");
	}

	public void assertOnOrderMembershipPage() {
		assertNotNull(driver.findElement(By
				.xpath("//*[@id=\"membership-order-table\"]")));
	}

	public void selectMembers() {
		WebElement row1 = driver.findElement(By
				.xpath("//tr[descendant::td[contains(.,'GR22-0021')]]"));
		WebElement row2 = driver.findElement(By
				.xpath("//tr[descendant::td[contains(.,'GR22-0022')]]"));
		row1.findElement(By.xpath(".//i")).click();
		row2.findElement(By.xpath(".//i")).click();
	}

	public void clickReviewSelected() {
		driver.findElement(By.xpath("//a[contains(@class, 'wiz-next-button')]"))
				.click();
	}

	public void clickPaymentShipping() {
		driver.findElement(By.xpath("//a[contains(@class, 'wiz-next-button')]"))
				.click();
	}

	public void fillForm() {
		driver.findElement(By.id("conformation-email-address")).clear();
		driver.findElement(By.id("conformation-email-address")).sendKeys(
				"test1@test.com");
		driver.findElement(By.id("delivery-address")).clear();
		driver.findElement(By.id("delivery-address")).sendKeys(
				"My Adress 1\n1010 Wien");
		driver.findElement(By.id("7")).click();
		driver.findElement(By.id("confirm-tac")).click();
	}

	public void clickConfirm() {
		driver.findElement(By.xpath("//a[contains(@class, 'wiz-next-button')]"))
				.click();
	}

	public void clickPlaceOrder() {
		driver.findElement(By.xpath("//a[contains(@class, 'wiz-next-button')]"))
				.click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
