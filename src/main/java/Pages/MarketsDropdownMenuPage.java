package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MarketsDropdownMenuPage {

	WebDriver driver;

	public MarketsDropdownMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void marketsDropdownMenu() {

		Actions action = new Actions(driver);

		WebElement ele = driver.findElement(By.linkText("Markets"));
		action.moveToElement(ele).build().perform();

		WebElement ele2 = driver.findElement(By.linkText("World Markets"));
		action.moveToElement(ele2).build().perform();
		action.click().build().perform();
		System.out.println(ele2);

	}

}
