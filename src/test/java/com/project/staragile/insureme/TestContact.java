package com.project.staragile.insureme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContact {
    @Test
    void verifymessage1() {
            System.out.println("Regression test started for ContactUS page");
            String expected = "Message Sent";

            //Set up ChromeDriver
            WebDriverManager.chromedriver().setup();

            //Setup Chrome options for headless test
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.addArguments("--headless");

            //Initialize Webdriver
            WebDriver driver = new ChromeDriver(chromeoptions);

            //Open Test Server URL
            driver.get("http://54.183.184.195:8081/contact.html");
            driver.manage().window().maximize();

            //Locate name field and enter name
            driver.findElement(By.id("inputName")).sendKeys("john");
            System.out.println("Entered Name");

            //Locate number field and enter number
            driver.findElement(By.id("inputNumber")).sendKeys("8888888888");
            System.out.println("Entered Mobile number");

            //Locate email field and enter email
            driver.findElement(By.id("inputMail")).sendKeys("test@test.com");
            System.out.println("Entered Email address");

            //Locate message field and enter message
            driver.findElement(By.id("inputMessage")).sendKeys("Test selenium");
            System.out.println("Entered message");

            //Locate Send button and click
            driver.findElement(By.id("my-button")).click();
            System.out.println("Clicked on Send button");

             //Get response text after clicking send button and save
            String actualMessage = driver.findElement(By.id("response")).getText();

            //Verify if actual and expected text are matching
            assertEquals(expected, actualMessage);

            System.out.println("Regression test completed for ContactUs Page");
            driver.close();
    }

    }


