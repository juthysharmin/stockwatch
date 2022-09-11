package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewFullPortfolioPage  {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		driver.findElement(By.linkText("My Watch")).click();
		String userName = "talentechcy";
		String passWord = "CyTech2022";
		driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys(userName);
		driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys(passWord);
		driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();

		driver.findElement(By.linkText("My Emails")).click();
		driver.findElement(By.id("ContentPlaceHolder1_radUpdateType_0")).click();
		driver.findElement(By.id("ContentPlaceHolder1_btnSave")).click();
		driver.findElement(By.id("ContentPlaceHolder1_divUpdated"));

		driver.findElement(By.linkText("My Portfolio")).click();
		driver.findElement(By.id("tabWLoverview")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();

	}

}
