package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	By email = By.id("userEmail");

	By password = By.id("userPassword");

	By login = By.id("login");

	public void login(String user, String pass) {

		driver.findElement(email).sendKeys(user);

		driver.findElement(password).sendKeys(pass);

		driver.findElement(login).click();

	}

}