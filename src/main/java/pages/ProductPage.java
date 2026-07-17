package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;

	}

	public void addProduct(String productName) {

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		for (WebElement product : products) {

			String name = product.findElement(By.cssSelector("b")).getText();

			if (name.equals(productName)) {

				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

				break;

			}

		}

	}

}