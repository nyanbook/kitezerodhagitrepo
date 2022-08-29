package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Screenshot {
	public static void takescreenshots(WebDriver driver, String name) throws IOException {
		
		TakesScreenshot sc = ((TakesScreenshot) driver);// upcast driver to screenshot(Takesscreenshot is an incomplete
														// interface that iscomplete by an other interdface
		File source = sc.getScreenshotAs(OutputType.FILE);

		File destination = new File("C:\\Users\\bhushan.kshirsagar\\eclipse-workspace\\KiteZeroda\\ScreenShot\\"+name+".jpg"); // creating object of
																								// file and give a path
																								// of screenshot folder
		FileHandler.copy(source, destination);

}}
