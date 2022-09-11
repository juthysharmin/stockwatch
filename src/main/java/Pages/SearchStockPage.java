package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchStockPage {
	WebDriver driver;

	public SearchStockPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchStock(String stockSymbol) {
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.findElement(By.id("quoteForm_symbol")).sendKeys(stockSymbol);
		driver.findElement(By.id("quoteForm_button")).click();
	}

	public void invalidStockSymbol(String invalidSymbol) {
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.findElement(By.id("quoteForm_symbol")).sendKeys(invalidSymbol);
		driver.findElement(By.id("quoteForm_button")).click();

	}

	public void companyName(String companySymbol) {
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.findElement(By.id("quoteForm_symbol")).sendKeys(companySymbol);
		driver.findElement(By.id("quoteForm_button")).click();
		driver.findElement(By.xpath("//div[#'h1Company']")).getText();

	}

//	public void company_Symbol_Lookup(String companyFullName) {
//		Actions action = new Actions(driver);
//		driver.get("http://thestockmarketwatch.com/stock-lookup.aspx");
//		WebElement searchBy = driver.findElement(By.id("searchBy"));
//		action.moveToElement(searchBy).build().perform();
//		WebElement byName = driver.findElement(By.xpath("//select[@id='searchBy']/option[1]"));
//		action.moveToElement(byName).build().perform();
//		action.click().build().perform();
//		driver.findElement(By.id("searchString")).sendKeys(companyFullName);
//	}
}
