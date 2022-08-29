package pom;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	
	@FindBy(xpath = "//input[@type='text']")private WebElement search;
	@FindBy(xpath = "(//span[@class='tradingsymbol'])")private List<WebElement> searchResult;
	@FindBy(xpath = "//button[@data-balloon='Buy']")private WebElement searchBuy;
	@FindBy(xpath="//header//span[text()='TATAMOTORS']")private WebElement buyTataMotors;
	@FindBy(xpath="//button[@class='button-orange']")private WebElement searchSell;
	@FindBy(xpath="(//button[@class='button-outline'])[1]")private WebElement searchChart;
	@FindBy(xpath="(//button[@class='button-outline'])[2]")private WebElement searchMarketDepth;
	@FindBy(xpath="//button[@data-balloon='Add']")private WebElement searchAdded;
	@FindBy(xpath="//span[text()='TATAMOTORS']")private WebElement inputChartOrMarketDepthField;
	@FindBy(xpath="//span[@class='icon icon-plus']")private WebElement searchadded2;
	@FindBy(xpath="//span[@class='nice-name']")private List<WebElement> addedsearchlist; 
	@FindBy(xpath="//span[@class='icon icon-trash']")private WebElement searchdeleted;
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void searchStock(String stock ,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);
	}
	public int getSearchResultNumber() {
		int listsize=searchResult.size();
		return listsize;
	}

	public void searchAndSelectDesiredStock(WebDriver driver, String requiredStock) {

		// stockList - all the shares maching name 'tata'

		for (int a = 0; a < searchResult.size(); a++)
		{
			WebElement s = searchResult.get(a);
			String Stockname = s.getText();
			if (Stockname.equals(requiredStock)) {
				Actions action = new Actions(driver);
				action.moveToElement(s);
				action.perform();
				break;
			}
		}}
	public void clickOnSearchResultBuy()
	{
	searchBuy.click();
	}
	public boolean checkTitle() {
		boolean target=buyTataMotors.isDisplayed();
		return target;
		}
	public void clickOnSearchResultSell() {
		searchSell.click();
	}
	public void clickOnSearchResultChart() {
		searchChart.click();
	}
	public void clickOnSearchResultMarketDepth() {
		searchMarketDepth.click();
	}
	public void clickOnSearchResultAdded() {
		searchadded2.click();
	}
	public boolean checkTataMotorsChartOrMarketDepth()
	{
		boolean target=inputChartOrMarketDepthField.isDisplayed();
		return target;
				
	}
	public void searchaddedstock(String addedstock,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
	wait.until(ExpectedConditions.visibilityOf(search));
	search.sendKeys(addedstock);
		}
	public int getaddedSearchResultNumber() {
		int listsize2=addedsearchlist.size();
		return listsize2;
	}
		public void searchAndSelectaddedStock(WebDriver driver, String requiredaddedStock) {

			// stockList - all the shares maching name 'tata'

			for (int a = 0; a < addedsearchlist.size(); a++) {
				WebElement ss = addedsearchlist.get(a);
				String addedStockname = ss.getText();
				if (addedStockname.equals(requiredaddedStock)) {
					Actions action = new Actions(driver);
					action.moveToElement(ss);
					action.perform();
					break;
				}
			}}
	public void clickonsearchresultdelete()
	{
		searchdeleted.click();
	}
}
