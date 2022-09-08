package com.stockTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.MarketsDropdownMenuPage;

public class MarketsDropdownMenuTest extends TestBase {
    @Test
	public void getMarkets() {
    
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.linkText("Markets"));
		action.moveToElement(ele).build().perform();

		Assert.assertFalse(driver.findElement(By.linkText("Markets")).isSelected());
		System.out.println((driver.findElement(By.linkText("Markets")).isSelected()));
	}
    @Test
	public void getworldMarkets() {
		Actions action = new Actions(driver);
		WebElement ele2 = driver.findElement(By.linkText("World Markets"));
		action.moveToElement(ele2).build().perform();
		action.click().build().perform();

		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/markets/world/today.aspx", pageURL);
		
		
		
	}

}
