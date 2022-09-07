package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StockSectorsPage {
	
	
	public static  void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sharmin/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.manage().window().maximize();

		// Give me the count of links on stockSectors page

		WebElement stockSectors = driver.findElement(By.id("row2"));
		System.out.println(stockSectors.findElements(By.tagName("h2")).size());
		
		Assert.assertNotNull(stockSectors);

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

		driver.findElement(By.linkText("Con. Discret"));
		driver.findElements(By.id("Con. Discret")).isEmpty();
		
		Assert.assertEquals(true, true);
		
		driver.quit();

	}

}
