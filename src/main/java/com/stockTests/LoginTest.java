package com.stockTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends TestBase {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		driver.manage().window().maximize();
		loginPage.login("talentechcy", "CyTech2022");

		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/members/my-watchlist.aspx", pageURL);
	}

	@Test
	public void logoutTest() {
		driver.get("https://thestockmarketwatch.com/members/my-watchlist.aspx");
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();

		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/members/login.aspx?msg=You+have+been+logged+out.",
				pageURL);

	}

	@Test
	public void negativeloginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		loginPage.login("techcy", "CyTech2022");

		Thread.sleep(5000);
		WebElement errorMsg = driver.findElement(By.id("ContentPlaceHolder1_divError"));
		Assert.assertEquals(errorMsg.isDisplayed(), true);
	}

}
