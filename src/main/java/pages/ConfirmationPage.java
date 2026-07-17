package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {

		this.driver = driver;

	}

	// Locator
	By confirmationMessage = By.cssSelector(".hero-primary");

	// Verify Order Confirmation
	public void verifyOrderConfirmation() {

		String actualMessage = driver.findElement(confirmationMessage).getText();
		Assert.assertEquals(actualMessage, "THANKYOU FOR THE ORDER.", "Order confirmation message is not displayed");

	}

}