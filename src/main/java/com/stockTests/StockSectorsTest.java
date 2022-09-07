package com.stockTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StockSectorsTest extends TestBase {

	@Test
	public void stockSectorsCountOfLinks() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.manage().window().maximize();

		WebElement stockSectors = driver.findElement(By.id("row2"));
		System.out.println(stockSectors.findElements(By.tagName("h2")).size());

		Assert.assertNotNull(stockSectors);
}
    @Test
	public void sectorsText() {
		driver.findElement(By.id("sectors"));
		System.out.println(driver.findElement(By.id("sectors")));

		if (driver.getPageSource().contains("sectors"))

		{

			System.out.println("Name is Present");

		}

		else

		{

			System.out.println("Name is not Present");

		}
		
		
		}
   @Test
    public void conDiscret () {
		driver.findElement(By.linkText("Con. Discret"));
		driver.findElements(By.id("Con. Discret")).isEmpty();
		
		Assert.assertEquals(true, true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
