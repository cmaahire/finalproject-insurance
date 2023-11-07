package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assume;
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

	/*@Test
	void verifyMessage() throws InterruptedException {
		// TODO Auto-generated method stub

		String urlToCheck = "http://52.53.182.232:8081/contact.html";
		Thread.sleep(5000);

		boolean isURLReachable = checkURLReachability(urlToCheck);

		if (isURLReachable) {

			System.out.println("Regression test started for ContactUS page");

			String expected = "Message Sent";

			WebDriverManager.chromedriver().setup();

//			ChromeOptions chromeoptions = new ChromeOptions();
//			chromeoptions.addArguments("--headless");

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com");
//			driver.get("http://54.183.232.28:8081/contact.html");
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

		} else {
			Assume.assumeTrue("Skipping test because the URL is not reachable.", false);
		}

	}*/

/*	private boolean checkURLReachability(String urlString) {

		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set up a HEAD request to check the URL
			connection.setRequestMethod("HEAD");

			// Set a reasonable timeout (e.g., 5 seconds)
			connection.setConnectTimeout(5000);

			int responseCode = connection.getResponseCode();
			return (responseCode == HttpURLConnection.HTTP_OK);
		} catch (MalformedURLException e) {
			// URL is not valid
			return false;
		} catch (IOException e) {
			// URL is not reachable
			return false;
		}

	}*/



}
