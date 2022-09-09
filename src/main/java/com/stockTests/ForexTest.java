package com.stockTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForexTest extends TestBase {

		// user story 007 crossRatesChart major
		@Test (priority = 7) 
		//(enabled = false)
		public void crossRatesChart_7() throws InterruptedException {
			driver.get("https://thestockmarketwatch.com/markets/today.aspx");
			driver.findElement(By.id("menu-item-58549")).click(); // clicking on the forex menu
			Thread.sleep(wait_time);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(wait_time+ 2000);
			driver.findElement(By.cssSelector("[href='pair\\.aspx\\?pair\\=EURUSD']")).click(); 
			Thread.sleep(wait_time+ 2000);
			driver.navigate().back();
			driver.findElement(By.cssSelector("[href='pair\\.aspx\\?pair\\=AUDUSD']")).click(); 
			Thread.sleep(wait_time+ 2000);
			driver.navigate().back();
			driver.findElement(By.cssSelector("[href='pair\\.aspx\\?pair\\=GBPUSD']")).click(); 
			Thread.sleep(wait_time+ 2000);
			driver.navigate().back();
			driver.findElement(By.cssSelector("[href='pair\\.aspx\\?pair\\=USDJPY']")).click(); 
			Thread.sleep(wait_time+ 2000);
			driver.navigate().back();
			Thread.sleep(wait_time+ 2000);	
		}
		
		// user story 008 majorPairColorCheck using excel file 
		String element_color_s_replace;
		@Test (priority = 8)
		//(enabled = false)
		public void majorPairColorCheck_8() throws IOException {
			// String excel_file_path = ".\\shakil_final_project_selenium.xlsx";
			String excel_file_path = "C:\\Users\\ShakilPublic\\Desktop\\shakil_final_project_selenium.xlsx";
			FileInputStream fis = new FileInputStream(excel_file_path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("forex_element_color");

			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			for (int r = 1; r <= rows; r++) { // starts from the second row
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < 2; c++) { // only working with the first two columns
					XSSFCell cell = row.getCell(c);
					switch (cell.getCellType()) {
					case STRING:
						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.println(cell.getBooleanCellValue());
						break;
					default:
						break;
					}
				}
			}
			driver.get("https://thestockmarketwatch.com/forex/");

			String[] color_elements = { "#fxHomeRight tr:nth-of-type(1) td:nth-of-type(1) div", // blue
					"#fxHomeRight tr:nth-child(3) td:nth-of-type(1) div", // red
					"#fxHomeRight tr:nth-child(5) td:nth-of-type(1) div", // yellow
					"#fxHomeRight tr:nth-child(7) td:nth-of-type(1) div" // green
			};
			int counter = 0;
			for (String c : color_elements) {

				counter++;
				WebElement element_color = driver.findElement(By.cssSelector(c));
				String element_color_s = element_color.getCssValue("background");
				element_color_s_replace = element_color_s.replace(" none repeat scroll 0% 0% / auto padding-box border-box",
						"");
				System.out.println("RGB is :" + element_color_s_replace);

				String assert_excel = workbook.getSheetAt(0).getRow(counter).getCell(1).getStringCellValue();
				;

				try {
					// Assert.assertEquals(ExpectedString, ActualString);
					Assert.assertEquals(assert_excel, element_color_s_replace);
				} catch (AssertionError e) {
					System.out.println("failed");
					throw e;
				}
				System.out.println("passed");
			}
			// Thread.sleep(5000);
		}
		
		// user story 009 forexTestUSDBDT using google search
		@Test (priority = 9)
		//(enabled = false)
		public void forexTestUSDBDT_9() throws InterruptedException {
			

			// collecting data from google

			//driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://google.com");
			WebElement r = driver.findElement(By.name("q"));
			r.sendKeys("usd to bdt today"); // search on google
			r.sendKeys(Keys.RETURN);// press ENTER
			Thread.sleep(wait_time+2000);
			WebElement webElement = driver.findElement(
					By.xpath("/html//div[@id='knowledge-currency__updatable-data-column']//span[@class='DFlfde SwHCTb']"));
			String googleUSDBDT_string = (webElement.getText());
			float googleUSDBDT = Float.parseFloat(googleUSDBDT_string);
			// googleUSDBDT = googleUSDBDT + 2.0f; //negative test
			System.out.println(googleUSDBDT);
			
			
			driver.get("https://thestockmarketwatch.com/forex/");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(wait_time);
			driver.findElement(By.xpath("//div[@id='fxHomeRight']/form[@action='/forex/pair.aspx']/input[@name='pair']"))
					.sendKeys("USDBDT");
			Thread.sleep(wait_time+3000);
			driver.findElement(By.xpath("//div[@id='fxHomeRight']/form[@action='/forex/pair.aspx']/input[@value='GO']"))
					.click();
			Thread.sleep(wait_time);

			// extracting data from the forex page
			WebElement forex_data = driver
					.findElement(By.xpath("/html//div[@id='divQMChart']/div[1]/div/div[2]/div[@class='qmjsright']"));
			String forexUSDBDT_string = (forex_data.getText());
			float forexUSDBDT_full = Float.parseFloat(forexUSDBDT_string);
			String forexUSDBDT_string_2dec = String.format("%.2f", forexUSDBDT_full); // 2 dec places
			float forexUSDBDT = Float.parseFloat(forexUSDBDT_string_2dec);
			System.out.println(forexUSDBDT);

			

			// Assert if both data matches

				try {
					// Assert.assertEquals(ExpectedString, ActualString);
					Assert.assertEquals(googleUSDBDT, forexUSDBDT);
				} catch (AssertionError edata) {
					System.out.println("failed");
					throw edata;
				}
		}
		
		// user story 010 USDBDTInterval 
		@Test (priority = 10)
		//(enabled = false)
		public void USDBDTInterval_10() throws InterruptedException {
			// switch view of interval default is 5days
			String[] elements = { "//div[@id='divQMChart']/div[@class='chartNav']/a[1]", // 1 day
							"//div[@id='divQMChart']/div[@class='chartNav']/a[2]", // 5 day default
							"//div[@id='divQMChart']/div[@class='chartNav']/a[3]", // 10 days
							"//div[@id='divQMChart']/div[@class='chartNav']/a[4]", // 1 months
							"//div[@id='divQMChart']/div[@class='chartNav']/a[5]", // 3 months
							"//div[@id='divQMChart']/div[@class='chartNav']/a[6]", // 6 months
							"/html//a[@id='a1y']" // 1 year
					};
					for (String s : elements) {
						driver.findElement(By.xpath(s)).click();
						Thread.sleep(wait_time+500);
						//System.out.println(s);
					}
					Thread.sleep(wait_time);
				}
	
	
	
}
