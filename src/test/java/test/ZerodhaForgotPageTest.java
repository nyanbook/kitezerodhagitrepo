package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaForgotPage;
import utility.Parametrization;

public class ZerodhaForgotPageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		 driver=LaunchBrowser.chromeBrowser();
	}
	
	
	@Test
	public void ZerodhaForgotTest() throws IOException, InterruptedException {
	ZerodhaForgotPage zerodhaForgotPage=new ZerodhaForgotPage(driver);
	String PANnoS=Parametrization.getData("Credentials", 4, 1);
	String emailOrMobNo=Parametrization.getData("Credentials", 6, 1);
	zerodhaForgotPage.clickOnForgot();
	zerodhaForgotPage.clickOnIForgotMyUserID();
	zerodhaForgotPage.enterPANno(PANnoS);
	zerodhaForgotPage.clickOnSms();
	zerodhaForgotPage.enterEmailOrMobNo(emailOrMobNo);
	Thread.sleep(10000);
	zerodhaForgotPage.clickOnReset();
	
	boolean response=zerodhaForgotPage.checkInvalidCred(driver);
	Assert.assertTrue(response);
	System.out.println("Thank you");
	 
		 
	
	
	
	
	}
}

