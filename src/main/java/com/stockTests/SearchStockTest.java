package com.stockTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SearchStockPage;

public class SearchStockTest extends Base {
//Search with a valid Stock Symbol
	@Test(priority = 1)
	public void searchTest() throws InterruptedException {

		SearchStockPage searchStockPage = new SearchStockPage(driver);
		searchStockPage.searchStock("AAPL");
		String company = driver.findElement(By.id("h1Company")).getText();
		String expectedTitle = "AAPL Stock Quote - Apple, Inc. Stock Price Today";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Positive Search Test  ::: Showing Stock Values for " + company);

	}

//Check current Stock Price, 1 Year graph 
	@Test(priority = 2)
	public void currentStockPrice() throws InterruptedException {

		SearchStockPage searchStockPage = new SearchStockPage(driver);
		searchStockPage.searchStock("AMZN");
		String company = driver.findElement(By.id("h1Company")).getText();
		String price = driver.findElement(By.id("lastPrice")).getText();
		System.out.println(company + " Stock Price ::: $" + price);
		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals(pageURL, "https://thestockmarketwatch.com/stock/?stock=AMZN");
	}

//Check Last Year Stock Fluctuation Graph	
	@Test(priority = 3)
	public void oneYearGraph() throws InterruptedException {

		SearchStockPage searchStockPage = new SearchStockPage(driver);
		searchStockPage.searchStock("TSLA");
		WebElement year = driver.findElement(By.linkText("1 year"));
		Actions action = new Actions(driver);
		action.moveToElement(year).build().perform();
		action.click().build().perform();
		Assert.assertEquals(year.isDisplayed(), true);
		System.out.println("One Year Graph        ::: 1 Year Graph has Displayed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement pastYear = driver.findElement(By.xpath("//*[name()='tspan' and contains(@dy,'0')]"));
		Assert.assertEquals(pastYear.isDisplayed(), true);
	}

//Search with invalid Stock Symbol
	@Test(priority = 4)
	public void neagativeSearchTest() throws InterruptedException {

		SearchStockPage invalidStock = new SearchStockPage(driver);
		invalidStock.invalidStockSymbol("AAAAAPL");
		WebElement symbolSearch = driver.findElement(By.cssSelector("div[class='entry themeform'] div h2"));
		Assert.assertEquals(symbolSearch.isDisplayed(), true);
		System.out.println("Negative Search Test  ::: Searched with Invalid Company Symbol");
		Thread.sleep(3000);
	}

//Search for a Company Symbol	
	@Test(priority = 5)
	public void companySymbolLookup() throws InterruptedException {

		driver.get("http://thestockmarketwatch.com/stock-lookup.aspx");
		WebElement searchBy = driver.findElement(By.xpath("//select[@id='searchBy']"));
		Actions action = new Actions(driver);
		action.moveToElement(searchBy).click();
		WebElement byName = driver.findElement(By.xpath("//select[@id='searchBy']/option[1]"));
		action.moveToElement(byName).click().build().perform();
		driver.findElement(By.id("searchString")).click();
//		driver.findElement(By.id("searchString")).sendKeys("Microsoft Corporation");
//		driver.findElement(By.xpath("//button[@name='submit']")).submit();
//		WebElement microsoft = driver.findElement(By.xpath("//tr[4]/td[@innertext='Microsoft Corporation']"));
//		Assert.assertEquals(microsoft, true);

	}

//Search for Top Gainers and Losers	
	@Test(priority = 6)
	public void gainersLosers() {

	}
}
