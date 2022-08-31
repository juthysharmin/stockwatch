package com.stockTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;





public class LoginTest extends TestBase {


	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='My Watch']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys("talentechcy");
		driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys("CyTech2022");
		driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();
		
		String pageURL =driver.getCurrentUrl();
    	Assert.assertEquals("https://thestockmarketwatch.com/members/my-watchlist.aspx", pageURL);
    	
    	
    	
    	
	
}
	@Test
	public void logoutTest(){
		driver.get("https://thestockmarketwatch.com/members/my-watchlist.aspx");
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		
		String pageURL =driver.getCurrentUrl();
    	Assert.assertEquals("https://thestockmarketwatch.com/members/login.aspx?msg=You+have+been+logged+out.", pageURL);
    	
		
		
	}
	@Test
	public void negativeloginTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("https://thestockmarketwatch.com/markets/today.aspx#google_vignette");
		driver.findElement(By.xpath("//a[normalize-space()='My Watch']")).click();
		driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys("techcy");		
		driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys("CyTech2022");
		driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();
		
		
		WebElement errorMsg = driver.findElement(By.id("ContentPlaceHolder1_divError"));
		Assert.assertEquals(errorMsg.isDisplayed(), true);
	}
	
}
