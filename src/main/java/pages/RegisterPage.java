package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.RandomData;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}


	By registerLink = By.xpath("//a[normalize-space()='Register here']");
	By firstName = By.xpath("//input[@id='firstName']");
	By lastName = By.xpath("//input[@id='lastName']");
	By email = By.xpath("//input[@id='userEmail']");
	By mobile = By.xpath("//input[@id='userMobile']");
	By occupationDropdown = By.xpath("//select[@formcontrolname='occupation']");
	By genderRadio = By.xpath("//input[@formcontrolname='gender']");
	By password = By.xpath("//input[@id='userPassword']");
	By confirmPassword = By.xpath("//input[@id='confirmPassword']");
	By checkbox = By.xpath("//input[@formcontrolname='required']");
	By submit = By.xpath("//input[@type='submit']");
	By Login = By.xpath("//button[text()='Login']");

	

	public void registerUser() {

		driver.findElement(registerLink).click();
		driver.findElement(firstName).sendKeys(RandomData.getFirstName());
		driver.findElement(lastName).sendKeys(RandomData.getLastName());
		driver.findElement(email).sendKeys(RandomData.getEmail());
		driver.findElement(mobile).sendKeys(RandomData.getMobileNumber());
		selectRandomOccupation();
		selectRandomGender();
		String pwd = RandomData.getPassword();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmPassword).sendKeys(pwd);
		driver.findElement(checkbox).click();
		driver.findElement(submit).click();
		driver.findElement(Login).click();

	}

	public void selectRandomOccupation() {
		WebElement dropdown = driver.findElement(occupationDropdown);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		Random random = new Random();
		int randomIndex = random.nextInt(options.size() - 1) + 1;
		select.selectByIndex(randomIndex);
		System.out.println("Selected Occupation: " + select.getFirstSelectedOption().getText());
	}

	public void selectRandomGender() {
		List<WebElement> radios = driver.findElements(genderRadio);
		Random random = new Random();
		int randomIndex = random.nextInt(radios.size());
		WebElement selectedRadio = radios.get(randomIndex);
		if (!selectedRadio.isSelected()) {
			selectedRadio.click();

		}
		System.out.println("Selected Gender: " + selectedRadio.getAttribute("value"));
	}

}