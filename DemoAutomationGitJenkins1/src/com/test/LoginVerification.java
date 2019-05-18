package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginVerification {

	WebDriver driver;
	String url = "";
	String verificationError = "";

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\PracticeSelenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/";
	}

	@Test
	public void loginTest() {
		try {
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("saikiran@gmail.com");
			driver.findElement(By.id("enterimg")).click();
			Thread.sleep(5000);
			String loginText = driver.findElement(By.xpath("//h2[text()='Register']")).getText();
			if (!loginText.equals("Register")) {
				System.out.println("Not able to login");
			} else
				System.out.println("login successfull");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			verificationError = e.getMessage();
		}
	}

	@AfterMethod
	public void tierDown() {
		driver.quit();
		if (!verificationError.equals(""))
			Assert.fail();
	}
}
