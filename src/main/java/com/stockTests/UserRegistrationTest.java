package com.stockTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {
	
	@Test
	public void registrationNegativeTest () throws InterruptedException {
		driver.get("https://thestockmarketwatch.com/members/login.aspx?pg=%2fmembers%2fmy-watchlist.aspx");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//a[normalize-space()='Click Here, to Register']")).click();
		
		//driver.findElement(By.xpath("//a[contains(text(),'Click Here, to Register')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ContentPlaceHolder1_txtUsername")).sendKeys("talentechcy");
		driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys("talentechcy@gmail.com");
		driver.findElement(By.id("ContentPlaceHolder1_txtPass")).sendKeys("CyTech2022");
		driver.findElement(By.id("ContentPlaceHolder1_txtPassConfirm")).sendKeys("CyTech2022");
		driver.findElement(By.id("ContentPlaceHolder1_chkNewsletters_0")).click();
		driver.findElement(By.id("ContentPlaceHolder1_btnRegister")).click();
		Thread.sleep(5000);
		
		 
        String alertMessage= driver.switchTo().alert().getText(); 
        System.out.println(alertMessage); 
		Thread.sleep(5000);
	    driver.switchTo().alert().accept();
		
	}
	
	
	
	

}
