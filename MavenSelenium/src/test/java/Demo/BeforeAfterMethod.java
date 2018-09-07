package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
	WebDriver driver;
	
	@BeforeMethod
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
	
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
