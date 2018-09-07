package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class User {
	WebDriver driver;
	
	@Test (priority=1)
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Automation\\Tools\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test (priority=2)
	public void NavigationURL() {
		driver.get("https://www.ministryoftesting.com/signin");
		Assert.assertEquals("https://www.ministryoftesting.com/signin", driver.getCurrentUrl());
	}
	
	@Test (priority=3)
	public void VerifyPageTitle() {
		driver.get("https://www.ministryoftesting.com/signin");
		Assert.assertEquals("Sign In | MoT", driver.getTitle());
	}
	
	@Test (priority=4)
	public void VerifyPageElements() {
		Assert.assertEquals(true, driver.findElement(By.linkText("Sign Up")).isDisplayed());
	}
	
	@Test (priority=5)
	public void UserRegistration() {
		driver.get("https://www.ministryoftesting.com/account/signup?plan=theclub");
		
		driver.findElement(By.id("user_first_name")).sendKeys("dcc");
		driver.findElement(By.id("user_email")).sendKeys("cecc");
		driver.findElement(By.id("user_username")).sendKeys("ecec");
		driver.findElement(By.id("user_password")).sendKeys("ecc");
		driver.findElement(By.id("user_password_confirmation")).sendKeys("");
		
		Select dropdown = new Select(driver.findElement(By.id("user_country_code")));
		dropdown.selectByVisibleText("Not resident in EU");
	}
	
	@Test (priority=6)
	public void CloseBrowser() {
		driver.close();
	}

}
