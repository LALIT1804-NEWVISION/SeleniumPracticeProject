package Tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.RegisterPage;


public class SubmitOrderTest extends BaseTest {

	String product = "ZARA COAT 3";

	@Test
	public void orderTest() {

		RegisterPage register = new RegisterPage(driver);
		register.registerUser();
		LoginPage login = new LoginPage(driver);
		login.login("guptalalit4223@gmail.com", "Vision1804@");
		ProductPage productPage = new ProductPage(driver);
		productPage.addProduct(product);
		CartPage cart = new CartPage(driver);
		cart.verifyProduct(product);
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.checkout();
		ConfirmationPage confirmation = new ConfirmationPage(driver);
	    confirmation.verifyOrderConfirmation();

	}

}