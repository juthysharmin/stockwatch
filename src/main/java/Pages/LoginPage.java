package Pages;
<<<<<<< HEAD
=======

>>>>>>> main
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
<<<<<<< HEAD
	
	WebDriver driver;
public LoginPage(WebDriver driver) {
		this.driver=driver;		
		}
	
    public void login(String userName , String password) {
	driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys(userName);
	driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys(password);
	driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();
	}
}
=======

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String userName, String password) {
		driver.findElement(By.id("ContentPlaceHolder1_txtUserName")).sendKeys(userName);
		driver.findElement(By.id("ContentPlaceHolder1_txtPassword")).sendKeys(password);
		driver.findElement(By.id("ContentPlaceHolder1_btnLogin")).click();
	}
}
>>>>>>> main
