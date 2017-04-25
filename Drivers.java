package com.wd.programs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

public class Drivers {
	
	private static final DateFormat sdf = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
	
	public static WebDriver getDriver(String browserName){
		WebDriver driver = null;
		String b = browserName.toUpperCase();
		switch (b){
			case "FIREFOX":
				driver = new FirefoxDriver();
				break;
				
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", "G:\\SeleniumJars\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "IE":
				System.setProperty("webdriver.ie.driver", "G:\\SeleniumJars\\IEDriverServer_x64_2.52.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			
			case "SAFARI":
				driver = new SafariDriver();
				break;
			
			default:
				driver = new HtmlUnitDriver();
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void takeScreenshotOfDriver(WebDriver driver, String fileName, String format) throws IOException{
		String s = sdf.format(new Date());
		System.out.println(s);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("Screenshots" + "\\" + fileName + s + "." + format));
	}
	
	
	public static void takeScreenshotOfElement(WebDriver driver, WebElement element, String fileName, String format) throws IOException{
		String s = sdf.format(new Date());
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot1);
		Point point = element.getLocation();
		Dimension dim = element.getSize();
		BufferedImage renderedImage = fullImg.getSubimage(point.getX(),point.getY(),dim.getWidth(),dim.getHeight());
		ImageIO.write(renderedImage, format , screenshot1);
		File screenshotLocation = new File("Screenshots" + "\\" + fileName + s);
		FileUtils.copyFile(screenshot1, screenshotLocation);
	}

}
