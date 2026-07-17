package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;

	}

	public void verifyProduct(String productName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		By spinner = By.cssSelector(".ngx-spinner-overlay");
		By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");

		try {
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
		} catch (Exception e) {
		    System.out.println("Spinner not displayed or already disappeared");
		}

		wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
	    
		List<WebElement> products = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = false;
		for (WebElement product : products) {
			if (product.getText().equalsIgnoreCase(productName)) {
				match = true;
				break;
			}
		}

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

	}

}