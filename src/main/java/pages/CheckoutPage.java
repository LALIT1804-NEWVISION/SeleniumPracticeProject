package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;

	}

	public void checkout() {

		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build()
				.perform();

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		WebElement place = driver.findElement(By.cssSelector(".btnn.action__submit"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", place);

	}

}