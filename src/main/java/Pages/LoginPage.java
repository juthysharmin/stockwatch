package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.stockTests.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage  {
	
	WebDriver driver;
	
	public void loginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://thestockmarketwatch.com/markets/today.aspx");
		driver.manage().window().maximize();
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		login("talentechcy","CyTech2022");
	}
	
	
	
//	@Test
//	public void tearDown() {
//		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
//		driver.quit();
		
	//}
	
	@Test(priority=1)
	public void toDayChange(){
		driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_divMsg1']//div[1]")).click();
	}
	
	
	public void login(String userName , String password) {
	driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys(userName);
	driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys(password);
	//driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();
	WebElement loginBtn = driver.findElement(By.id("ContentPlaceHolder1_btnLogin"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", loginBtn);


	}
}

