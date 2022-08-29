package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ZerodhaForgotPage {
	@FindBy (xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy (xpath="(//form//label)[2]")private WebElement forgotUserID;
	@FindBy (xpath="//input[@placeholder='PAN']")private WebElement PANno ;
	@FindBy (xpath="(//form//label)[4]")private WebElement email ;
	@FindBy (xpath="(//form//label)[5]")private WebElement sms;
	@FindBy (xpath="//input[@placeholder='Mobile number (as on account)']")private WebElement emailOrMobNoAsOnAccount;
	@FindBy (xpath="//button[@type='submit']")private WebElement reset;
	@FindBy (xpath="//p[@class='error text-center']")private WebElement invalidCredentials;
	public ZerodhaForgotPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnForgot() {
		forgot.click();
	}
	public void clickOnIForgotMyUserID()
	{
		forgotUserID.click();
	}
	public void enterPANno(String PANnoS)
	{
		PANno.sendKeys(PANnoS);
	}
	public void clickOnEmail()
	{
		email.click();
	}
	public void clickOnSms()
	{
		sms.click();
	}
	public void enterEmailOrMobNo(String emailOrmobNo )
	{
		emailOrMobNoAsOnAccount.sendKeys(emailOrmobNo);
	}
	//for explicite wait
	
	/*
	 * public void enterCaptcha(String Captcha,WebDriver driver) { WebDriverWait
	 * wait=new WebDriverWait(driver,Duration.ofMillis(10000));
	 * wait.until(ExpectedConditions.visibilityOf(Captcha));
	 * 
	 * }
	 */
	  
	public void clickOnReset()
	{
		reset.click();
	}
	
	
	public boolean checkInvalidCred(WebDriver driver) throws InterruptedException
	{ 
		  FluentWait<WebDriver> wait=new FluentWait <WebDriver>(driver);
		  wait.withTimeout(Duration.ofMillis(10000));//this is maximum time of wait
		  wait.pollingEvery(Duration.ofMillis(5000));//this is pooling time
		  wait.ignoring(Exception.class);//this will handle exception
		  wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
		
		 boolean result=invalidCredentials.isDisplayed();
		return result;
		
	}
}
