package com.stockTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void openingBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.manage().window().maximize();
	}

	@AfterTest(alwaysRun = true)
	public void closingBrowser() {
		driver.quit();
	}
}
