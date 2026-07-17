package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = DriverFactory.initializeDriver();

		driver.get("https://www.rahulshettyacademy.com/client/#/auth/login");

	}

	@AfterMethod
	public void tearDown() {

		DriverFactory.quitDriver();

	}

}