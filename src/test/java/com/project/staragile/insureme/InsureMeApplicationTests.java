package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class InsureMeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCreatePolicy() {
		Policy policy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService(); // Policy outputPolicy = pService.CreatePolicy();
		assertEquals(policy.getPolicyId(), pService.generateDummyPolicy().getPolicyId());

	}

	@Test
	void testSearchPolicy() {
		PolicyService pService = new PolicyService();
		assertEquals(null, pService.searchPolicy());
	}

	@Test
	void verifyMessage() {
		// TODO Auto-generated method stub

		System.out.println("Regression test started for ContactUS page");

		String expected = "Message Sent";

		WebDriverManager.chromedriver().setup();

		  ChromeOptions chromeoptions = new ChromeOptions();
		  chromeoptions.addArguments("--headless");

		WebDriver driver = new ChromeDriver(chromeoptions);

		driver.get("http://54.183.232.28:8081/contact.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputName")).sendKeys("john");
		System.out.println("Entered Name");

		driver.findElement(By.id("inputNumber")).sendKeys("8888888888");
		System.out.println("Entered Mobile number");

		driver.findElement(By.id("inputMail")).sendKeys("test@test.com");
		System.out.println("Entered Email address");

		driver.findElement(By.id("inputMessage")).sendKeys("Test selenium");
		System.out.println("Entered message");

		driver.findElement(By.id("my-button")).click();
		System.out.println("Clicked on Send button");

		String actualMessage = driver.findElement(By.id("response")).getText();

		assertEquals(expected, actualMessage);

		System.out.println("Regression test completed for ContactUs Page");
		driver.close();

	}
	
}
