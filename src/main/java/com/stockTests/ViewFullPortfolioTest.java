package com.stockTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class ViewFullPortfolioTest extends TestBase {
	
	@Test(priority = 1)
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		loginPage.login("talentechcy", "CyTech2022");
        String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/members/my-watchlist.aspx", pageURL);
	}
	@Test(priority = 2)
	public void myEmailsTest () throws InterruptedException	{
		driver.findElement(By.linkText("My Emails")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ContentPlaceHolder1_radUpdateType_0")).click();
		driver.findElement(By.id("ContentPlaceHolder1_btnSave")).click();
		driver.findElement(By.id("ContentPlaceHolder1_divUpdated"));
		
		WebElement confirmation = driver.findElement(By.id("ContentPlaceHolder1_divUpdated"));
		Assert.assertEquals(confirmation.isDisplayed(), true);
		System.out.println(confirmation.getText());
		
		}
	
	@Test(priority = 3)
	public void logOutViewFullPortFolio () throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Portfolio")).click();
	    driver.findElement(By.id("tabWLoverview")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();

	    WebElement logOutconfirmation = driver.findElement(By.id("ContentPlaceHolder1_divInfo"));
		Assert.assertEquals(logOutconfirmation.isDisplayed(), true);
		System.out.println(logOutconfirmation.getText());
	}
}