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

public class MetalsTest extends TestBase {

	
	// user story 001 click on metals menu and find spot market price
		@Test (priority = 1)
		//(enabled = false)
		public void metalsPage_001() throws InterruptedException {

			// driver.get("https://thestockmarketwatch.com/markets/today.aspx");
			Thread.sleep(wait_time);
			driver.findElement(By.id("menu-item-58158")).click(); // clicking on the metals menu
			// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			// // scrolling down
			Thread.sleep(wait_time);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1300)", "");
			Thread.sleep(3000);
			System.out.println("Spot market price: ");
			WebElement webElement1 = driver.findElement(By.cssSelector(
					"body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > article:nth-child(1) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
			String spotGold = (webElement1.getText());
			System.out.println(spotGold);

			WebElement webElement2 = driver.findElement(By.cssSelector(
					"body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > article:nth-child(1) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)"));
			String spotSilver = (webElement2.getText());
			System.out.println(spotSilver);

			WebElement webElement3 = driver.findElement(By.cssSelector(
					"body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > article:nth-child(1) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)"));
			String spotPlatinum = (webElement3.getText());
			System.out.println(spotPlatinum);

			WebElement webElement4 = driver.findElement(By.cssSelector(
					"body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > article:nth-child(1) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2)"));
			String spotPalladium = (webElement4.getText());
			System.out.println(spotPalladium);
			Thread.sleep(wait_time + 2000);

		}

		// user story 002 gold silver copper... price cycle in the metals page
		@Test (priority = 2)
		//(enabled = false)
		public void metalsPage_002() throws InterruptedException {

			System.out.println("Cyceling throught tabs of metals page: ");
			String[] metals_tabs = {
					"//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/gold-price.aspx']", // gold
					"//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/silver-price.aspx']", // silver
					"//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/platinum-price.aspx']", // platinum
					"//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/palladium-price.aspx']", // palladium
					// "//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/copper-price.aspx']",
					// // copper
					// "//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/prices.aspx']",
					// // metals
			};
			for (String metals_tab_elements : metals_tabs) {
				driver.findElement(By.xpath(metals_tab_elements)).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(wait_time + 2000);
				js.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(wait_time + 2000);
				System.out.println(metals_tab_elements);
			}

			// special treatment for copper
			driver.findElement(
					By.xpath("//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/copper-price.aspx']"))
					.click();
			Thread.sleep(wait_time + 2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(wait_time + 2000);

			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			js.executeScript("window.scrollBy(0,-700)", "");
			Thread.sleep(wait_time + 2000);

		}

		// user story 003 chart labeled
		@Test (priority = 3)
		// (enabled = false)
		public void metalsPage_003() throws InterruptedException {
			// for testing
			driver.get("https://thestockmarketwatch.com/metal/prices.aspx");
			driver.findElement(
					By.xpath("//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/gold-price.aspx']"))
					.click();
			Thread.sleep(wait_time + 2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(wait_time + 2000);
			WebElement spotPriceLabel = driver.findElement(By.cssSelector(".tblMetalsCell:nth-of-type(1) h2"));
			String spotPriceLabel_string = (spotPriceLabel.getText());
			Thread.sleep(wait_time + 2000);
			// System.out.println(spotPriceLabel_string);
			String spotPriceLabel_assert = "Gold Spot Price Chart";
			try {
				// Assert.assertEquals(ExpectedString, ActualString);
				Assert.assertEquals(spotPriceLabel_assert, spotPriceLabel_string);
			} catch (AssertionError espot) {
				System.out.println("failed");
				throw espot;
			}
			WebElement futuresLabel = driver.findElement(By.cssSelector(".tblMetalsCell:nth-of-type(2) h2"));
			String futuresLabel_string = (futuresLabel.getText());
			Thread.sleep(wait_time + 2000);
			// System.out.println(futuresLabel_string);
			String futuresLabel_assert = "Gold Futures";
			try {
				// Assert.assertEquals(ExpectedString, ActualString);
				Assert.assertEquals(futuresLabel_assert, futuresLabel_string);
			} catch (AssertionError efutures) {
				System.out.println("failed");
				throw efutures;
			}

		}

		// user story 004 Paragraph
		@Test (priority = 4)
		//(enabled = false)
		public void metalsPage_004() throws InterruptedException {
			// for testing
			// driver.get("https://thestockmarketwatch.com/metal/prices.aspx");
			// driver.findElement(
			// By.xpath("//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/gold-price.aspx']"))
			// .click();
			Thread.sleep(wait_time + 2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			Thread.sleep(wait_time + 2000);
			WebElement paragraph = driver.findElement(By.cssSelector(".themeform p"));
			String paragraph_string = (paragraph.getText());
			Thread.sleep(wait_time + 2000);
			System.out.println(paragraph_string);

			String paragraph_assert = "The precious metal gold is a very popular investment. Gold is commonly viewed as a safe haven investment and is often used as a hedge against currency issues or an equity downturn. The price of gold acts more as a currency than an commodity, as it usually moves more in correlation with fiat currencies than with other commodities.";
			try {
				// Assert.assertEquals(ExpectedString, ActualString);
				Assert.assertEquals(paragraph_assert, paragraph_string);
			} catch (AssertionError espot) {
				System.out.println("failed");
				throw espot;
			}
		}

		// user story 005 spot price tab
		@Test (priority = 5) 
		//(enabled = false)
		public void metalsPage_005() throws InterruptedException {
			// for testing
			// driver.get("https://thestockmarketwatch.com/metal/prices.aspx");
			// driver.findElement(
			// By.xpath("//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/gold-price.aspx']"))
			// .click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1700)", "");

			String[] spot_price_tabs = {
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[1]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//td[2]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[3]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[4]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[5]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[6]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[1]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[7]" };
			for (String spot_price_tabs_elements : spot_price_tabs) {
				driver.findElement(By.xpath(spot_price_tabs_elements)).click();
				Thread.sleep(wait_time + 2000);
			}

		}

		// user story 006 futures price tab
		@Test (priority = 6)
		//(enabled = false)
		public void metalsPage_006() throws InterruptedException {
			// for testing
			// driver.get("https://thestockmarketwatch.com/metal/prices.aspx");
			// driver.findElement(
			// By.xpath("//ul[@id='ulInnerTabs']//a[@href='https://thestockmarketwatch.com/metal/gold-price.aspx']"))
			// .click();

			String[] futures_price_tabs = {
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[1]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//td[2]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[3]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[4]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[5]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[6]",
					"//div[@id='page']/div[@class='container-inner']/div[@class='main']/div/section[@class='content']/div/article/div/div[5]/div[2]/div/table[@class='qmmt_main']//table[@class='qm_miniQuotes_chartScaleTab']//tr/td[7]" };
			for (String futures_price_tabs_elements : futures_price_tabs) {
				driver.findElement(By.xpath(futures_price_tabs_elements)).click();
				Thread.sleep(wait_time + 2000);
			}
		}
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
