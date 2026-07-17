package Utilities;

import com.github.javafaker.Faker;

public class RandomData {

	private static final Faker faker = new Faker();

	public static String getFirstName() {

		String name = faker.name().firstName();

		return name.length() > 12 ? name.substring(0, 12) : name;
	}

	public static String getLastName() {

		String name = faker.name().lastName();

		return name.length() > 12 ? name.substring(0, 12) : name;
	}

	public static String getEmail() {

		return faker.internet().emailAddress();

	}

	public static String getMobileNumber() {

		return "9" + faker.number().digits(9);

	}

	public static String getPassword() {

		return "Vision1804@";

	}

}