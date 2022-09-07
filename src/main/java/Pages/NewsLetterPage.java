package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewsLetterPage {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.findElement(By.xpath("//h2[normalize-space()='Join Today']"));
		String email = "talentifynyc@gmail.com";
		driver.findElement(By.id("email")).sendKeys(email);
		
		try {
		     driver.findElement(By.linkText("Scans")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='submit']")));
		
		     
		     
		     
		     
		Thread.sleep(5000);
		WebElement errorMsg = driver.findElement(By.id("icon"));
		Assert.assertEquals(errorMsg.isDisplayed(), true);

		driver.findElement(By.id("primary-button")).click();

		String pageURL = driver.getCurrentUrl();
		Assert.assertEquals("https://thestockmarketwatch.com/markets/today.aspx", pageURL);

		driver.quit();

	}

	}
}
