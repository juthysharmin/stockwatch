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

	public static void main(String[] args) {
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
		
		WebElement errorMsg = driver.findElement(By.id("icon"));
	    driver.findElement(By.id("primary-button")).click();

		
		

	}

	}
}
