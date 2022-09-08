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
    	MarketsDropdownMenuPage DROPDOWNMENU = new MarketsDropdownMenuPage(driver);
    	DROPDOWNMENU.marketsDropdownMenu();
    	
		Assert.assertFalse(driver.findElement(By.linkText("Markets")).isSelected());
		System.out.println((driver.findElement(By.linkText("Markets")).isSelected()));
		
		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/markets/world/today.aspx", pageURL);
		
	}
    @Test
	public void getWorldMarkets() {
    	MarketsDropdownMenuPage DROPDOWNMENU = new MarketsDropdownMenuPage(driver);
    	DROPDOWNMENU.marketsDropdownMenu();
		
        String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/markets/world/today.aspx", pageURL);
		
		
		
	}

}
