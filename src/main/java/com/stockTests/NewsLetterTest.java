package com.stockTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsLetterTest extends TestBase {
	@Test(priority = 1)
	public void getnewsLetter() throws InterruptedException {
		String email = "talentifynyc@gmail.com";
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.findElement(By.xpath("//h2[normalize-space()='Join Today']"));
		driver.findElement(By.id("email")).sendKeys(email);
		try {
		     driver.findElement(By.linkText("Scans")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='submit']")));
		
		  }
		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://leads.stockmarketwatch.com/thanks/confirm.aspx",pageURL);
	
}
    @Test(priority = 1)
	public void getIcon() {
		driver.get("https://leads.stockmarketwatch.com/thanks/confirm.aspx");
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='icon']"));
		Assert.assertEquals(errorMsg.isDisplayed(), true);
	}
}
