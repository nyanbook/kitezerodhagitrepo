package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;

public class ZerodhaHomePageTest {
	
		WebDriver driver;
		@BeforeMethod
		public void launchBrowser() throws IOException {
		 driver=LaunchBrowser.chromeBrowser();ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
			String user=Parametrization.getData("Credentials", 0, 1);
			String pass=Parametrization.getData("Credentials", 1, 1);
			String pin=Parametrization.getData("Credentials", 2, 1);
			zerodhaLoginPage.enterUserName(user);
			zerodhaLoginPage.enterPassword(pass);
			zerodhaLoginPage.clickOnSubmit();
			zerodhaLoginPage.enterPin(pin, driver);//this is for explicite wait and implicite wait
			zerodhaLoginPage.ClickOnContinue();
	
		}
		@Test
		public void searchStockTest()
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			int number=zerodhaHomePage.getSearchResultNumber();
			Assert.assertTrue(number>0);
		}
		@Test
		public void searchStockAndClickOnBuy()
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickOnSearchResultBuy();
			boolean result=zerodhaHomePage.checkTitle();
			Assert.assertTrue(result);
			System.out.println("Thank you");
		}
		
		@Test
		public void searchStockAndClickSell()
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickOnSearchResultSell();
			boolean result=zerodhaHomePage.checkTitle();
			Assert.assertTrue(result);
			System.out.println("Thank you");
		}
		@Test
		public void searchStockAndClickChart() throws InterruptedException
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickOnSearchResultChart();
			Thread.sleep(5000);
			
			  boolean result=zerodhaHomePage.checkTataMotorsChartOrMarketDepth();
			  Assert.assertTrue(result);
			  System.out.println("Thank you");
			 		}
		
		@Test
		public void searchStockAndClickMarketDepth() throws InterruptedException
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickOnSearchResultMarketDepth();
			boolean result=zerodhaHomePage.checkTataMotorsChartOrMarketDepth();
			Assert.assertTrue(result);
			System.out.println("Thank you");
			
		}
		@Test
		public void searchStockAndAdded() throws InterruptedException
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("TATA", driver);
			zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickOnSearchResultAdded();
			/*
			 * boolean result=zerodhaHomePage.checkTataMotorsChartOrMarketDepth();
			 * Assert.assertTrue(result); 
			 * System.out.println("Thank you");
			 */
		}
		
		@Test
		public void searchStockAndDeleted() throws InterruptedException
		{
			ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
			int number=zerodhaHomePage.getaddedSearchResultNumber();
			Assert.assertTrue(number>0);
			zerodhaHomePage.searchAndSelectaddedStock(driver, "TATAMOTORS");
			zerodhaHomePage.clickonsearchresultdelete();
			/*
			 * boolean result=zerodhaHomePage.checkTataMotorsChartOrMarketDepth();
			 * Assert.assertTrue(result); 
			 * System.out.println("Thank you");
			 */

}}
