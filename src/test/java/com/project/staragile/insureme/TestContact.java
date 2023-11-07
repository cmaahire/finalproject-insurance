package com.project.staragile.insureme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContact {
    @Test
    void verifymessage1() throws InterruptedException {

//        String urlToCheck= "http://54.183.184.195:8081/contact.html";
//	String urlToCheck= "https://www.facebook.com";
//        boolean isURLReachable = checkURLReachability(urlToCheck);
//
//        if(isURLReachable) {
            System.out.println("Regression test started for ContactUS page");

            String expected = "Message Sent";

            WebDriverManager.chromedriver().setup();
            Thread.sleep(5000);
//            ChromeOptions chromeoptions = new ChromeOptions();
//            chromeoptions.addArguments("--headless");
            WebDriver driver = new ChromeDriver();
            Thread.sleep(5000);

            driver.get("http://54.183.184.195:8081/contact.html");
            Thread.sleep(5000);
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

//        } else {
//            Assume.assumeTrue("Skipping test because URL unreachable", false);
//        }

    }

    private boolean checkURLReachability(String urlString) {
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            int responseCode =connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        }catch(MalformedURLException e){
            return false;
        }catch (IOException e){
            return false;
        }


    }

}
